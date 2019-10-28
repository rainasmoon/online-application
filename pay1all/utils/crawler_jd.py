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
import urllib

from utils import db_utils

test_asearch_input = '手机'


def create_search_url(keyword):
    keyword = parse.quote(keyword)
    return 'https://search.jd.com/Search?keyword=' + keyword + '&enc=utf-8&wq=' + keyword + '&pvid=c060319d4120468ca810e38ab6b73545'


aheaders = {
    'Host': 'search.jd.com',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:70.0) Gecko/20100101 Firefox/70.0',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    'Accept-Language': 'zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2',
    # 'Accept-Encoding': 'gzip, deflate, br', # will cause decode problem
    'Connection': 'keep-alive',
    'Referer': 'https://www.jd.com/',
    'Cookie': '__jda=76161171.15714963011562096123417.1571496301.1572180143.1572241782.31; __jdv=76161171|cps.youmai.com|t_1000049399_68094883|tuiguang|7d9e751e36fb4868a766b7ed1a99ebcd|1571902102040; __jdu=15714963011562096123417; TrackID=18PyAbuP5mew6nzxOIkN13NLLpDs6FKo6qnC9xvabo_VCbmZnbrzEDTMx-b-nr9zYPhuxA3xDVBGt5NDZNAfewrvWCdCbItFQnTWbTrx7JQA0pZkwMxGipS2LaP6_CBLm; pinId=RI7NyUI4ksl6j_twplCNNw; _tp=F2k%2FNk8zSmdHi15Gqe%2B%2Bzg%3D%3D; _pst=rainasmoon; unpl=V2_ZzNtbUcFRBFzDkNdcxwJBmIEGg9LX0YUJQgVBHlKWVczABJbclRCFX0URlVnGlgUZwIZWUZcQhxFCEdkexhdBWIAE1RLUXMlRQtGZHopXAFhAxdVRVVCFXUMQVd6EVsFZAEXXURncxV9DHZUehhdBGQFF1VGUkslNlgeCytbAFs5XCJdRFRKFXwLQ1d6KV01ZwsSWURRQBd0CXYCFRldBGYCE1hBU0tYdQxAVH4RWwdmAxJZRVRCHXIIRVZ%2bGVo1ZjMR; shshshfp=15aa112d62f5aaba770739f63a64f80b; shshshfpa=33e91a4c-052d-68fb-d8b0-aa585e8f7707-1571717784; shshshfpb=pBcghGXQN6yMwCJvHzrtjjA%3D%3D; areaId=5; ipLoc-djd=5-239-2767-0; xtest=6076.cf6b6759; qrsc=3; __jdc=76161171; rkv=V0800; __jdb=76161171.3.15714963011562096123417|31.1572241782; shshshsID=6ce4ba4026a7a73e7d458ff351b82756_2_1572241916687; user-key=147ecdca-be2e-43c5-9bd6-28b6f7b6e81d; cn=0',
    'Upgrade-Insecure-Requests': 1
    }


def call_jd_search(keyword):
    aurl = create_search_url(keyword)
    print('CRAWEL JD FOR:' + aurl)
    req = use_no_proxy(aurl)
    with request.urlopen(req) as response:    
        rresponse = response.read().decode('utf-8', "ignore") 
        rlist = re.findall(r'(//item.jd.com/)([0-9]*)(.html)', rresponse)
        print("YEAH: FIND ITEMS NO.:" + str(len(rlist)))
        for i in rlist:
            # the 1 item is sku
            db_utils.insert_db(i[1])
            
    print("STORE THEM:" + str(len(rlist)))


def use_proxy(aurl):
    proxy = "http://112.80.248.95:80"
    proxy_support = urllib.request.ProxyHandler({'http':proxy})
    opener = urllib.request.build_opener(proxy_support)
    urllib.request.install_opener(opener)
    return request.Request(url=aurl, headers=aheaders)


def use_no_proxy(aurl):
    return request.Request(url=aurl, headers=aheaders)
# htreturn tp://118.24.52.95/get/
# call_jd_search(asearch_input)
