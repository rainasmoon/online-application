# -*- coding: utf-8 -*
from datetime import datetime
from io import StringIO
import json

from utils import db_utils_online_mysql as db_utils_online, \
    db_utils_online_mysql
from utils import jd_api, db_utils
from utils import jd_comment

MAX_PARAM = 100 


def make_menu_param(agood):
    field_json = {}
    field_json['menu_name'] = agood['cid3Name']
    field_json['cid'] = agood['cid3']
    field_json['m_scores'] = 1500
    return field_json


def make_produst_param(agood):
    field_json = {}
    sku = agood['skuId']
    field_json['product_jd_skuid'] = sku
    field_json['product_name'] = agood['goodsName']
    field_json['product_price'] = agood['unitPrice']
    field_json['product_big_pic'] = agood['imgUrl']
    url = jd_api.call_jd_promotion_url(sku)
    if not url:
        print('WARN:::NOT URL for ' + sku)        
    field_json['product_promotion_url'] = url
    field_json['p_scores'] = 1500
    
    field_json['cid'] = agood['cid']
    field_json['cid2'] = agood['cid2']
    field_json['cid3'] = agood['cid3']
    field_json['cidName'] = agood['cidName']
    field_json['cid2Name'] = agood['cid2Name']
    field_json['cid3Name'] = agood['cid3Name']
    
    field_json['pub_date'] = datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3]
    
    return field_json


def make_jd_data():
    r_set = db_utils.select_sku()
    print('FIND NEW SKU NO.:', len(r_set))
    jd_sku_list = r_set
    for j in range(len(jd_sku_list))[::MAX_PARAM]:
        t_sku_100_list = (','.join(jd_sku_list[j:j + MAX_PARAM]))
        goods_list = jd_api.call_jd_goods_detail(t_sku_100_list)
        for agood in goods_list:    
            db_utils_online.insert_product(make_produst_param(agood))
            db_utils_online.insert_menu(make_menu_param(agood))
            db_utils.done(agood['skuId'])
    print('INSERT PRODUCT, MENU, SET STORE TO DONE.')

    
def make_jd_wordcloud_comment():
    r_set = db_utils_online_mysql.select_no_wordcloud_product()
    print('FIND NO CLOUDPIC NO.:', len(r_set))
    for item in r_set:
        print(item)
        item_id = item[0]
        sku_id = item[1]
        jd_comment.batch_spider_comment(sku_id)
        wordcloud_pic_path = jd_comment.create_word_cloud(sku_id)
        if wordcloud_pic_path:
            db_utils_online_mysql.update_wordcloud_pic_path(item_id, wordcloud_pic_path)
        else:
            print('SKIP. WORDCLOUD PIC PATH EMPTY,:', wordcloud_pic_path)
