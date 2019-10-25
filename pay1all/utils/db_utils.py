import sqlite3

PROD_DB = 'prod.sqlite3'


# 0 false, 1 true
def init_db():
    conn = sqlite3.connect(PROD_DB)
    c = conn.cursor()
    c.execute('''CREATE TABLE stocks
             (sku_id integer unique, as_done integer)''')
    conn.commit()
    conn.close()


def insert_db(sku):
    conn = sqlite3.connect(PROD_DB)
    c = conn.cursor()
    c.execute('''INSERT INTO stocks(sku_id, as_done) 
                SELECT ?, 0 
                WHERE NOT EXISTS(SELECT 1 FROM stocks WHERE sku_id = ?)''', (sku, sku))
    conn.commit()
    conn.close()


def select_db():
    conn = sqlite3.connect(PROD_DB)
    c = conn.cursor()
    c.execute('select * from stocks')
    print(c.fetchall())
    conn.commit()
    conn.close()


def select_sku():
    conn = sqlite3.connect(PROD_DB)
    c = conn.cursor()
    c.execute('select sku_id from stocks where as_done = 0')
    r = c.fetchall()
    conn.commit()
    conn.close()
    return [str(x[0]) for x in r]


def done(sku):
    conn = sqlite3.connect(PROD_DB)
    c = conn.cursor()
    c.execute('update stocks set as_done = 1 WHERE sku_id = ?', sku)
    conn.commit()
    conn.close() 


# init_db()
print('end.')

