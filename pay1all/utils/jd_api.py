# -*- coding: UTF-8 -*- 
'''
Created on 2019-10-23

@author: Administrator
'''

import hashlib
from io import StringIO
import json
import time
from urllib import parse
from urllib import request

f = open('config_jd_api.json', 'r')
config_jd_api = json.load(f)
app_key = config_jd_api['app_key']
appsecret = config_jd_api['appsecret']
site_id = '1728182420'
position_id = '1915772300'
access_token = ''

method_get_promotion = 'jd.union.open.promotion.common.get'
method_get_category = 'jd.union.open.category.goods.get'
method_get_goods = 'jd.union.open.goods.promotiongoodsinfo.query'

test_jd_prod_sku_1 = 25643981948


def get_material_id(jd_prod_sku):
    return 'https://item.jd.com/' + str(jd_prod_sku) + '.html'


def get_timestamp():
    return time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())


def get_param_json_promotion_url(material_id):
    return '{"promotionCodeReq":{"siteId":"' + site_id + '","materialId":"' + material_id + '","positionId":"' + position_id + '"}}'


def get_param_json_goods_100(goods_sku_array):
    # the max is 100 i.e: 1000,1002,1113,
    return '{"skuIds":"' + goods_sku_array + '"}'


def get_param_json_category():
    return '{"req":{"parentId":"1342","grade":"2"}}'


def get_sign_key(method, timestamp, param_json):
    
    c = ''
    # c = c + 'access_token' + access_token
    c = c + 'app_key' + app_key
    c = c + 'formatjson'
    c = c + 'method' + method
    c = c + 'param_json' + param_json
    c = c + 'sign_methodmd5'
    c = c + 'timestamp' + timestamp
    c = c + 'v1.0'
    c = appsecret + c + appsecret
    sign_key = hashlib.md5(c.encode("utf-8")).hexdigest().upper()
    return sign_key
    

def get_api_url(method, param_json):
    timestamp = get_timestamp()
    
    sign_key = get_sign_key(method, timestamp, param_json)
    return 'https://router.jd.com/api?v=1.0&method=' + method + '&access_token=&app_key=' + app_key + '&sign_method=md5&format=json&timestamp=' + parse.quote(timestamp) + '&sign=' + sign_key + '&param_json=' + param_json


def call_jd_api(api_url):
    # print('CALL JD API:' + api_url)
    rresponse = request.urlopen(api_url)
    s_result = rresponse.read()
    # print('JD RESPONSES:' + str(s_result))
    json_result = json.loads(s_result)  
    return json_result

    
def call_jd_promotion_url(sku):
    material_id = get_material_id(sku)
    param_json = get_param_json_promotion_url(material_id)
    json_result = call_jd_api(get_api_url(method_get_promotion, param_json))
    r_result = json_result['jd_union_open_promotion_common_get_response']['result']
    inner_json_result = json.load(StringIO(r_result))
    # print('RESPONSE CODE:'+inner_json_result['code'])
    
    click_url = inner_json_result['data']['clickURL']
    return click_url

    
def call_jd_goods_detail(sku_list):
    param_json = get_param_json_goods_100(sku_list)
    json_result = call_jd_api(get_api_url(method_get_goods, param_json))
    r_result = json_result['jd_union_open_goods_promotiongoodsinfo_query_response']['result']
    inner_json_result = json.load(StringIO(r_result))
    
    goods_json = inner_json_result['data']

    return goods_json

    
def call_jd_category():
    param_json = get_param_json_category()
    json_result = call_jd_api(get_api_url(method_get_category, param_json))
    return json_result     

