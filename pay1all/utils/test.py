import json

def test_json():
    print("json:")
    s = b'{"main":{"result":{"code":200, "data":[{"name":"name1"},{"name":"name2"}]}}}'
    j = json.loads(s)
    print(j)
    print(j['main'])    
    print(j['main']['result']['data'][0])
    print(j['main']['result']['data'][0]['name'])
    
test_json()