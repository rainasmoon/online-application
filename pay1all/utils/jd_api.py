# -*- coding: UTF-8 -*- 
'''
Created on 2019-10-23

@author: Administrator
'''

import hashlib
import time
import json
from urllib import request
from urllib import parse
from io import StringIO

app_key = 'd6b2d3ba859446c4bbf1c36c9e4f2a8f'
appsecret = '8777e8f1207841e484be71077c9ef428'
site_id = '1728182420'
position_id = '1915772300'
access_token = ''
method_get_promotion = 'jd.union.open.promotion.common.get'
method_get_category = 'jd.union.open.category.goods.get'
method_get_goods = 'jd.union.open.goods.promotiongoodsinfo.query'

jd_prod_sku_1 = '25643981948'

def get_material_id(jd_prod_sku):
    return 'https://item.jd.com/' + jd_prod_sku + '.html'

def get_timestamp():
    return time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())

def get_param_json_promotion_url(material_id):
    return '{"promotionCodeReq":{"siteId":"' + site_id + '","materialId":"' + material_id + '","positionId":"' + position_id + '"}}'

def get_param_json_goods_100(goods_sku_array):
    # the max is 100 i.e: 1000,1002,1113,
    return '{"skuIds":"' +goods_sku_array + '"}'

def get_param_json_category():
    return '{"req":{"parentId":"1342","grade":"2"}}'

def get_sign_key(method, timestamp, param_json):
    
    c = ''
    #c = c + 'access_token' + access_token
    c = c + 'app_key' + app_key
    c = c + 'formatjson'
    c = c + 'method' + method
    c = c + 'param_json' + param_json
    c = c + 'sign_methodmd5'
    c = c + 'timestamp' + timestamp
    c = c + 'v1.0'
    c = appsecret + c + appsecret
    #print(c)
    sign_key = hashlib.md5(c.encode("utf-8")).hexdigest().upper()
    return sign_key

    

def get_api_url(method, param_json):
    timestamp = get_timestamp()
    
    sign_key = get_sign_key(method, timestamp, param_json)
    return 'https://router.jd.com/api?v=1.0&method=' + method + '&access_token=&app_key=' + app_key + '&sign_method=md5&format=json&timestamp=' + parse.quote(timestamp) + '&sign=' + sign_key + '&param_json=' + param_json

def call_jd_api(api_url):
    print(api_url)
    rresponse = request.urlopen(api_url)
    s_result = rresponse.read()
    print(s_result)
    json_result = json.loads(s_result)  
    print(json.dumps(json_result, sort_keys=True, indent=4))  
    return json_result
    
def call_jd_promotion_url():
    material_id = get_material_id(jd_prod_sku_1)
    param_json = get_param_json_promotion_url(material_id)
    json_result = call_jd_api(get_api_url(method_get_promotion, param_json))
    r_result = json_result['jd_union_open_promotion_common_get_response']['result']
    inner_json_result = json.load(StringIO(r_result))
    print(inner_json_result['code'])
    
    click_url = inner_json_result['data']['clickURL']
    print(click_url)
    
def call_jd_goods_detail():
    param_json = get_param_json_goods_100(jd_prod_sku_1)
    call_jd_api(get_api_url(method_get_goods, param_json))
    
def call_jd_category():
    param_json = get_param_json_category()
    json_result = call_jd_api(get_api_url(method_get_category, param_json))     
        
#call_jd_goods_detail()
call_jd_promotion_url()
#call_jd_category()

