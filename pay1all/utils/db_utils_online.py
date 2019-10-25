import sqlite3
ONLINE_DB = 'db.sqlite3'

'''
CREATE TABLE "products_product" ("id" integer NOT NULL PRIMARY KEY AUTOINCREMENT, "product_jd_skuid" integer NOT NULL, "product_name" varchar(200) NOT NULL, "product_price" integer NOT NULL, "product_big_pic" varchar(200) NOT NULL, "product_promotion_url" varchar(400) NOT NULL, "p_scores" integer NOT NULL, "cid" integer NOT NULL, "cid2" integer NOT NULL, "cid3" integer NOT NULL, "cidName" varchar(100) NOT NULL, "cid2Name" varchar(100) NOT NULL, "cid3Name" varchar(100) NOT NULL, "pub_date" datetime NOT NULL);
'''


def insert_db(param):
    conn = sqlite3.connect(ONLINE_DB)
    c = conn.cursor()
    c.execute('''INSERT INTO products_product(product_jd_skuid, product_name, product_price, product_big_pic, product_promotion_url, p_scores, cid, cid2, cid3, cidName, cid2Name, cid3Name, pub_date) 
                SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? 
                WHERE NOT EXISTS(SELECT 1 FROM products_product WHERE product_jd_skuid = ?)''', (param['product_jd_skuid'], param['product_name'], param['product_price'], param['product_big_pic'], param['product_promotion_url'], param['p_scores'], param['cid'], param['cid2'], param['cid3'], param['cidName'], param['cid2Name'], param['cid3Name'], param['pub_date'], param['product_jd_skuid']))
    conn.commit()
    conn.close()

    
def select_db():
    conn = sqlite3.connect(ONLINE_DB)
    c = conn.cursor()
    c.execute('select * from  "products_product" ')
    print(c.fetchall())
    conn.commit()
    conn.close()


select_db()
