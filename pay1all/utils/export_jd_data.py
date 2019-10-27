'''
Deprected.
will use db instead of files
'''
from datetime import datetime
from io import StringIO
import json

from utils import jd_api

fi = open('crawler_jd.list', 'r')
r_set = json.load(fi)
fi.close()

jd_sku_list = r_set

rlist = []

MAX_PARAM = 100 
i_id = 1
for j in range(len(jd_sku_list))[::MAX_PARAM]:
    t_sku_100_list = (','.join(jd_sku_list[j:j + MAX_PARAM]))
    goods_list = jd_api.call_jd_goods_detail(t_sku_100_list)
    for agood in goods_list:
        ajson = {}
        ajson['model'] = 'products.product'
        ajson['pk'] = i_id
        i_id += 1
        field_json = {}
        sku = agood['skuId']
        field_json['product_jd_skuid'] = sku
        field_json['product_name'] = agood['goodsName']
        field_json['product_price'] = agood['unitPrice']
        field_json['product_big_pic'] = agood['imgUrl']
        url = jd_api.call_jd_promotion_url(sku)
        if not url:
            print('WARN:::NOT URL for ' + sku)
            continue
        field_json['product_promotion_url'] = url
        field_json['p_scores'] = 1500
        
        field_json['cid'] = agood['cid']
        field_json['cid2'] = agood['cid2']
        field_json['cid3'] = agood['cid3']
        field_json['cidName'] = agood['cidName']
        field_json['cid2Name'] = agood['cid2Name']
        field_json['cid3Name'] = agood['cid3Name']
        
        field_json['pub_date'] = datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3]
        
        ajson['fields'] = field_json    
        rlist.append(ajson)
fo = open('out_data.json', 'w')
json.dump(rlist, fo, indent=4)
fo.close()
print('result:' + len(rlist))
print('finished.')
