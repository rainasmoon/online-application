import datetime 

import numpy as np
import pandas as pd


def test_lot():
    print(datetime.date(2019, 1, 1))
    print(datetime.datetime.strptime(str(20191111), '%Y%m%d'))
    
    ts_code = '300000.sz'
    print(ts_code)
    print(ts_code.isdigit())
    print(ts_code[:-3])

    
def test_df():
    df = pd.DataFrame(np.random.randn(10, 3), columns=['A', 'B', 'C'],
                 index=pd.date_range('1/1/2000', periods=10))
    
    print(df.empty)
    df = pd.DataFrame()
    print(df.empty)


def test_df_setvalues():
    df = pd.DataFrame(np.random.randn(10, 3), columns=['A', 'B', 'C'],
                 index=pd.date_range('1/1/2000', periods=10))
#     print(df)
    df['D1'] = [i * 10 for i in range(10)]
    df['D2'], df['D3'] = (10, 100)
    df['D4'] = df['D1'] / (df['D3'] - df['D2']) * 100
    print(df[['D1', 'D2', 'D3', 'D4']])


def test_str():
    print(int('10'))

    
test_df_setvalues()
test_str()

