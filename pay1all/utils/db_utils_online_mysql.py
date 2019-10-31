import MySQLdb

'''
CREATE TABLE "products_product" ("id" integer NOT NULL PRIMARY KEY AUTOINCREMENT, "product_jd_skuid" integer NOT NULL, "product_name" varchar(200) NOT NULL, "product_price" integer NOT NULL, "product_big_pic" varchar(200) NOT NULL, "product_promotion_url" varchar(400) NOT NULL, "p_scores" integer NOT NULL, "cid" integer NOT NULL, "cid2" integer NOT NULL, "cid3" integer NOT NULL, "cidName" varchar(100) NOT NULL, "cid2Name" varchar(100) NOT NULL, "cid3Name" varchar(100) NOT NULL, "pub_date" datetime NOT NULL);
'''


def get_mysql_conn():
    return  MySQLdb.connect(host='localhost', port=3306, user='pc', passwd='pc', db='online_db', charset='utf8', use_unicode=True)


def get_conn():
    return get_mysql_conn()


def insert_db(param):
    conn = get_conn()
    c = conn.cursor()
    c.execute('''INSERT INTO products_product(product_jd_skuid, product_name, product_price, product_big_pic, product_promotion_url, p_scores, cid, cid2, cid3, cidName, cid2Name, cid3Name, pub_date) 
                VALUES (%(product_jd_skuid)s, %(product_name)s, %(product_price)s, %(product_big_pic)s, %(product_promotion_url)s, %(p_scores)s, %(cid)s, %(cid2)s, %(cid3)s, %(cidName)s, %(cid2Name)s, %(cid3Name)s, %(pub_date)s FROM products_product
                )''', param)
    conn.commit()
    conn.close()


def insert_menu(param):
    conn = get_conn()
    c = conn.cursor()
    c.execute('''INSERT INTO products_menu(menu_name, cid, m_scores) 
                VALUES( %(menu_name)s, %(cid)s, %(m_scores)s FROM products_menu
                )''', param)
    conn.commit()
    conn.close()


def select_search():
    conn = get_conn()
    c = conn.cursor()
    c.execute('select id, search_context from products_search where as_done = 0')
    r = c.fetchall()
    conn.commit()
    conn.close()
    return r 


def search_done(iid):
    conn = get_conn()
    c = conn.cursor()
    c.execute('update products_search set as_done = 1 WHERE id = %s', (iid,))
    conn.commit()
    conn.close() 


def reset():
    conn = get_conn()
    c = conn.cursor()
    c.execute('update products_search set as_done = 0')
    conn.commit()
    conn.close() 


def search_update(iid, cid):
    conn = get_conn()
    c = conn.cursor()
    c.execute('update products_search set cid = %s WHERE id = %s', (cid, iid))
    conn.commit()
    conn.close() 

    
def select_db():
    conn = get_conn()
    c = conn.cursor()
    c.execute('select * from  products_product ')
    print('PRODUCTS TABLE ITEMS:', c.fetchall())
    conn.commit()
    conn.close()


if __name__ == '__main__':
    select_db()
