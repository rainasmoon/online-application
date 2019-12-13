# -*- coding: utf-8 -*-
import top.api
import json

f = open('config_api.json', 'r')
config_jd_api = json.load(f)
appkey = config_jd_api['tb_app_key']
secret = config_jd_api['tb_appsecret']

url = 'gw.api.taobao.com'
port = '80'
ADZONE_ID = 109847100359

def call_tb_kouling():
    req=top.api.TbkTpwdCreateRequest(url, port)
    req.set_app_info(top.appinfo(appkey,secret))

    req.user_id="108721660"
    req.text="长度大于5个字符"
    req.url="https://uland.taobao.com/"
    req.logo="https://uland.taobao.com/"
    req.ext="{}"
    try:
        resp= req.getResponse()
    except Exception as e:
        print(e)


def call_tb_search(search_content):
    req=top.api.TbkDgMaterialOptionalRequest(url,port)
    req.set_app_info(top.appinfo(appkey,secret))

    req.adzone_id=ADZONE_ID
    req.q=search_content

    try:
        resp= req.getResponse()
        inner_r = resp['tbk_dg_material_optional_response']
        print('TOTALS:', inner_r['total_results'])
        items = inner_r['result_list']['map_data']
        for item in items:
            print(item['title'])
    except Exception as e:
        print(e)


if __name__ == '__main__':
    #call_tb_kouling()
    call_tb_search('洛天依cos服')
