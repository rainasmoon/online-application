# -*- coding: utf-8 -*-
import top.api

appkey = '28105142'
secret = 'd456ce5712d0a1f89341a525c7b735ee'
url = 'gw.api.taobao.com'
port = '80'


req=top.api.TbkTpwdCreateRequest()
req.set_app_info(top.appinfo(appkey,secret))

req.user_id="108721660"
req.text="长度大于5个字符"
req.url="https://uland.taobao.com/"
req.logo="https://uland.taobao.com/"
req.ext="{}"
try:
	resp= req.getResponse()
	print(resp)
except Exception as e:
	print(e)
