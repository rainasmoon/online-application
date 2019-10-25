'''
response.cookies
response.headers
response.status_code
response.url

'''

import json
import re
from urllib import request

burl = 'https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&wq=%E6%89%8B%E6%9C%BA&pvid=c060319d4120468ca810e38ab6b73545'

aheaders = {'User-Agent':'Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Mobile Safari/537.36'}

req = request.Request(url=burl, headers=aheaders)
with request.urlopen(req) as response:    
    rresponse = response.read().decode('utf-8') 
    rlist = re.findall(r'(//item.jd.com/)([0-9]*)(.html)', rresponse)
    sku_list = [i[1] for i in rlist]
    print(len(sku_list))
    f = open('crawler_jd.list', 'w')
    json.dump(sku_list, f)

print('end crawl.')
