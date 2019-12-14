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
        rr = []
        resp= req.getResponse()
        inner_r = resp['tbk_dg_material_optional_response']
        print('TOTALS:', inner_r['total_results'])
        items = inner_r['result_list']['map_data']
        for item in items:
            row = [item['item_id'], item['title'], item['pict_url'], \
                    item['url'], item['reserve_price'], \
                    item['level_one_category_id'], item['category_id'], \
                    item['level_one_category_name'], item['category_name']]
            rr.append(row)
        return rr
    except Exception as e:
        print(e)
      
def make_out_file(keyword):      
    r = call_tb_search(keyword+ 'cos服')
    f = open('./content/work-' + keyword + '.rst', 'w')
    f.write('The List of Taobao OTAKU:' + keyword + '\n')
    f.write('#########################' + '##' * len(keyword) + '\n')
    f.write('\n')
    f.write(':date: 2019-12-14 10:10\n')
    f.write(':category: + ' + keyword + '\n')
    f.write('\n')
    if not r:
        print('NO RESULT FOR :', keyword)
        f.write('there is no result.')
        f.close()
        return

    for i in range(len(r)):
        item = r[i]
        title = item[8] + ' - ' + item[7]
        f.write(title + '\n')
        f.write('=' * len(title) * 2 + '\n')
        f.write('\n')
        f.write('.. image:: ' + item[2] + '_300x300' + '\n')
        f.write('   :alt: ' + item[1] + '\n')
        f.write('\n')
        f.write('\\ `' + item[1] + ' <' + item[3] + '>`__' + '\n')
        f.write('\n')
        f.write('------------------------\n')
        f.write('\n')
    f.write('this is the end.')
    f.close()

if __name__ == '__main__':
    #call_tb_kouling()
    keys = ['洛天依', '第5人格', '王者荣耀', '崩坏三', '血小板', '初音未来',
            'lolita', '斗罗大陆', '阴阳师', 'JK制服', '未闻花名']
    for k in keys:
        make_out_file(k)

