import requests
import json
COMMENT_FILE_PATH = 'a.txt'


def spider_comment(page=0):
    """
    爬取京东指定页的评价数据
    :param page: 爬取第几，默认值为0
    """
    url = 'https://sclub.jd.com/comment/productPageComments.action?callback=fetchJSON_comment98vv4646&productId=1263013576' \
          '&score=0&sortType=5&page=%s&pageSize=10&isShadowSku=0&fold=1' % page
    kv = {'user-agent': 'Mozilla/5.0', 'Referer': 'https://item.jd.com/1263013576.html'}

    try:
        r = requests.get(url, headers=kv)
        r.raise_for_status()
    except:
        print('爬取失败')
    # 截取json数据字符串
    r_json_str = r.text[26:-2]
    # 字符串转json对象
    r_json_obj = json.loads(r_json_str)
    # 获取评价列表数据
    r_json_comments = r_json_obj['comments']
    # 遍历评论对象列表
    for r_json_comment in r_json_comments:
        # 以追加模式换行写入每条评价
        with open(COMMENT_FILE_PATH, 'a+') as file:
            file.write(r_json_comment['content'] + '\n')
        # 打印评论对象中的评论内容
        print(r_json_comment['content'])
spider_comment()
