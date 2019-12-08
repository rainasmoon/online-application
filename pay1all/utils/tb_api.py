# -*- coding: UTF-8 -*- 
'''
Created on 2019-10-23

@author: Administrator
'''

import datetime
import hashlib
from io import StringIO
import json
import time
from urllib import parse
from urllib import request

f = open('config_api.json', 'r')
config_jd_api = json.load(f)
app_key = config_jd_api['tb_app_key']
appsecret = config_jd_api['tb_appsecret']
site_id = '1728182420'
position_id = '1915772300'
access_token = ''

method_get_promotion = 'jd.union.open.promotion.common.get'


STATUS_OK = 200


def get_material_id(jd_prod_sku):
    return 'https://item.jd.com/' + str(jd_prod_sku) + '.html'


def get_timestamp():
    return time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())

def get_param_json_kouling(atime, page_no):
    return '{"orderReq":{"time":"' + atime + '","pageNo":' + str(page_no) + ',"pageSize":"500","type":"1"}}'




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
    return 'http://gw.api.taobao.com/router/rest'


def call_tb_api(api_url):
    print('CALL TB API:' + api_url)
    rresponse = request.urlopen(api_url)
    s_result = rresponse.read()
    print('TB RESPONSES:' + str(s_result))
    json_result = json.loads(s_result)  
    return json_result

    
def call_tb_kouling():
    param_json = get_param_json_category(paraent_id, agrade)
    json_result = call_tb_api(get_api_url(method_get_category, param_json))
    return json_result



if __name__ == '__main__':
    call_tb_kouling();
