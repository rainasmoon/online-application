'''
response.cookies
response.headers
response.status_code
response.url

DAY2: the call frequency ratio limitation

'''

import json
import re
from urllib import parse
from urllib import request
from utils import db_utils

test_asearch_input = '手机'


def create_search_url(keyword):
    keyword = parse.quote(keyword)
    return 'https://search.jd.com/Search?keyword=' + keyword + '&enc=utf-8&wq=' + keyword + '&pvid=c060319d4120468ca810e38ab6b73545'


aheaders = {'User-Agent':'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36'}


def call_jd_search(keyword):
    aurl = create_search_url(keyword)
    print('CRAWEL JD FOR:' + aurl)
    req = request.Request(url=aurl, headers=aheaders)
    with request.urlopen(req) as response:    
        rresponse = response.read().decode('utf-8') 
        rlist = re.findall(r'(//item.jd.com/)([0-9]*)(.html)', rresponse)
        print("YEAH: FIND ITEMS NO.:" + str(len(rlist)))
        for i in rlist:
            # the 1 item is sku
            db_utils.insert_db(i[1])
            
    print("STORE THEM:" + str(len(rlist)))

# call_jd_search(asearch_input)
