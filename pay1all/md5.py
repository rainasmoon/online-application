# -*- coding: UTF-8 -*- 
'''
Created on 2019-10-23

@author: Administrator
'''

import hashlib
import time
from urllib import request
from urllib import parse

appsecret = '8777e8f1207841e484be71077c9ef428'
access_token = ''
app_key = 'd6b2d3ba859446c4bbf1c36c9e4f2a8f'
method = 'jd.union.open.promotion.common.get'
material_id = 'https://item.jd.com/25643981948.html'
param_json = '{"promotionCodeReq":{"siteId":"1728182420","materialId":"' + material_id + '","positionId":"1915772300"}}'
local_time = time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())
timestamp = local_time
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
print(sign_key)
print(local_time)

api_url = 'https://router.jd.com/api?v=1.0&method=jd.union.open.promotion.common.get&access_token=&app_key=d6b2d3ba859446c4bbf1c36c9e4f2a8f&sign_method=md5&format=json&timestamp=' + parse.quote(timestamp) + '&sign=' + sign_key + '&param_json={"promotionCodeReq":{"siteId":"1728182420","materialId":"' + material_id + '","positionId":"1915772300"}}'
print(api_url)
rresponse = request.urlopen(api_url)
print(rresponse.read())

