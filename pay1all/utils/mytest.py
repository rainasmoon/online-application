# -*- coding: utf-8 -*-
import top.api

appkey = '28160979'
secret = 'd6f162a48ecdf95a7e4fcc665b865355'
url = 'gw.api.taobao.com'
port = '80'


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
        print(resp)
    except Exception as e:
        print(e)


def call_tb_search():
    req=top.api.TbkDgMaterialOptionalRequest(url,port)
    req.set_app_info(top.appinfo(appkey,secret))

    req.adzone_id=109847100359
    req.q='洛天依cos'

    try:
        resp= req.getResponse()
        print(resp)
    except Exception as e:
        print(e)


if __name__ == '__main__':
    #call_tb_kouling()
    call_tb_search()
