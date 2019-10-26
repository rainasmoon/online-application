from io import StringIO
import json
from urllib import parse

from utils import db_utils
from utils.elo import Elorating


def test_json():
    print("json:")
    s = b'{"main":{"result":{"code":200, "data":[{"name":"name1"},{"name":"name2"}]}}}'
    j = json.loads(s)
    print(j)
    print(j['main'])    
    print(j['main']['result']['data'][0])
    print(j['main']['result']['data'][0]['name'])


def test_str():
    print('{0}, {1}, {2}'.format(5, 10.0, 100))
    print('{0},{1}'.format(1 / 2, 1 / 3))


def test_slice_array():
    r = []
    for i in range(100):
        r.append(str(i))
    print(r[::10])  
    MAX_PARAM = 10  
    for j in range(len(r))[::MAX_PARAM]:
        print(','.join(r[j:j + MAX_PARAM]))


def test_set():
    l1 = [1, 2, 3, 1, 2]
    l2 = [2, 3, 4]
    r = set()
    r = r | set(l1)
    r = r | set(l2)
    print(r)


def test_StringIO():
    print(StringIO('you are right.'))
    print(json.loads(r'[1,2,3,4]'))


def test_import_set():
    r_set = set()
    
    fi = open('crawler_jd.list', 'r')
    for line in fi:
        print(line)
        print(json.loads(line))
    fi.close()


def test_parse_quote():
    print(parse.quote('a b'))
    print(parse.quote('a今天b'))


def test_index():
    seq = [i for i in range(10, 20)]
    print(seq)
    print(seq[3])
    print(seq.index(seq[3]))
    
    for a, i in enumerate(seq):
        print(a, i)


def test_elo():
    a = Elorating(ascores=1500, bscores=1500)
    print(a)
    a.win()
    print(a)
    
    a = Elorating(ascores=1500, bscores=1500)
    print(a)
    a.lose()
    print(a)
    
    a = Elorating(ascores=1500, bscores=1500)
    print(a)
    a.tie()
    print(a)
    
    a = Elorating(ascores=1500, bscores=1600)
    print(a)
    a.tie()
    print(a)
    
    a = Elorating(ascores=1600, bscores=1500)
    print(a)
    a.tie()
    print(a)
    
    a = Elorating(ascores=1500, bscores=1900)
    a.win()
    print(a)
    a = Elorating(ascores=1900, bscores=1500)
    a.win()
    print(a)


def test_lock():    
    print(db_utils.get_lock())
#     db_utils.lock()
    print(db_utils.get_lock())
    db_utils.unlock()
    print(db_utils.get_lock())


test_lock()    
# test_index()
# test_parse_quote()
# test_StringIO()
# test_import_set()
# test_set()
# test_str()
# test_slice_array()
