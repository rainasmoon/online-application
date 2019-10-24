from datetime import datetime
import json
from utils import jd_api

print('run...')
print(jd_api)

jd_sku_list = ['100004770257', '100008643298', '100006769698']

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
            continue
        field_json['product_promotion_url'] = url
        field_json['p_scores'] = 1500
        field_json['pub_date'] = datetime.utcnow().strftime('%Y-%m-%d %H:%M:%S.%f')[:-3]
        
        ajson['fields'] = field_json    
        rlist.append(ajson)
f = open('out_data.json', 'w')
json.dump(rlist, f, indent=4)
print(len(rlist))
print('finished.')
