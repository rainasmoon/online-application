# -*- coding: utf-8 -*
import os

from pylab import mpl

import matplotlib.pyplot as plt
import pandas as pd
import tushare as ts

COMMEN_FILE_PATH = 'datas/'

ts.set_token('d5dbcb604067c88ad5b03d59d78a934fbde19d1746afa502fa24e6f8')
pro = ts.pro_api()

# 正常显示画图时出现的中文
# 这里使用微软雅黑字体
mpl.rcParams['font.sans-serif'] = ['SimHei']
# 画图时显示负号
mpl.rcParams['axes.unicode_minus'] = False


def call_all_stocks():
    '''
    ts_code     str     TS代码
    symbol     str     股票代码
    name     str     股票名称
    area     str     所在地域
    industry     str     所属行业
    fullname     str     股票全称
    enname     str     英文全称
    market     str     市场类型 （主板/中小板/创业板/科创板）
    exchange     str     交易所代码
    curr_type     str     交易货币
    list_status     str     上市状态： L上市 D退市 P暂停上市
    list_date     str     上市日期
    delist_date     str     退市日期
    is_hs     str     是否沪深港通标的，N否 H沪股通 S深股通
    '''
    filePath = COMMEN_FILE_PATH + 'all_stocks.csv'
    if not os.path.exists(filePath):
        data = pro.stock_basic(exchange='', list_status='L', fields='ts_code,symbol,name,area,industry,list_date')
        data.to_csv(filePath)
        print('STORE:', filePath)
    else:
        data = pd.read_csv(filePath)
    return data


def call_stock_info(ts_code):
    data = call_all_stocks()
    return data[data.ts_code == ts_code]
        

def call_daily(aday):
    filePath = COMMEN_FILE_PATH + f'daily_{aday}.csv'
    if not os.path.exists(filePath):
        
        df = pro.daily(trade_date=aday)
        df.to_csv(filePath)
        print('STORE:', filePath)
    else:
        df = pd.read_csv(filePath)
    return df


def call_stock(ts_code, start_date, end_date):
    filePath = COMMEN_FILE_PATH + f'stock_{ts_code}_{start_date}_{end_date}.csv'
    if not os.path.exists(filePath):
        
        df = pro.daily(ts_code=ts_code, start_date=start_date, end_date=end_date)
        df.to_csv(filePath)
        print('STORE:', filePath)
    else:
        df = pd.read_csv(filePath)
    return df


def call_stock_qfq(ts_code, start_date, end_date):
    filePath = COMMEN_FILE_PATH + f'stock_qfq_{ts_code}_{start_date}_{end_date}.csv'
    if not os.path.exists(filePath):
        
        df = ts.pro_bar(ts_code=ts_code, adj='qfq', start_date=start_date, end_date=end_date)
        df.to_csv(filePath)
        print('STORE:', filePath)
    else:
        df = pd.read_csv(filePath)
    return df


df = call_daily('20191119')
today_focus = df[(df.pct_chg > 4.5) & (df.pct_chg < 5.5)]

print(today_focus.loc[:, 'ts_code'])

astock = call_stock_info('300462.SZ')
temp = astock['list_date'].iloc[0]

df = call_stock_qfq('300462.SZ', str(temp), '20191119')
print(df)

main_info = df.describe().round(2)

print('MAIN INFO:', main_info)

# df.index = pd.to_datetime(df.trade_date)
# 画出上证指数收盘价的走势
df['close'].plot(figsize=(12, 6))
plt.title('上证指数1990-2018年走势图')
plt.xlabel('日期')
plt.show()
