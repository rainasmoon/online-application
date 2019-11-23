# -*- coding: utf-8 -*-
import json
import os

import pandas as pd
import tushare as ts

COMMEN_FILE_PATH = '../datas/'

f = open('config_api.json', 'r')
config_jd_api = json.load(f)
app_key = config_jd_api['app_key']

ts.set_token(app_key)
pro = ts.pro_api()

test_ts_code_1 = '000001.SZ'


def to_date(date):
    return pd.to_datetime(date, format='%Y%m%d')


def to_date_v1(date):
    return pd.to_datetime(date)


def make(df):    
    # pandas有个专门把字符串转为时间格式的函数，to_datetime。第一个参数是原始数据，第二个参数是原始数据的格式
    df['trade_date'] = to_date(df['trade_date'])
    # 把trade_date设置为索引
    df.set_index('trade_date', inplace=True)
    return df


def make_v1(df):
    df['date'] = to_date_v1(df.date)
    df.set_index('date', inplace=True)
    return df


def make_index(df):
    df.set_index('ts_code', inplace=True)
    return df


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
        data = pro.stock_basic(exchange='', list_status='L', fields='ts_code,symbol,name,area,industry,list_date,fullname,enname,market,exchange,curr_type,list_status,delist_date,is_hs')
        if data.empty:
            return None
        data.to_csv(filePath)
        print('STORE:', filePath)
    else:
        data = pd.read_csv(filePath)
    return make_index(data)


def call_stock_info(ts_code):
    data = call_all_stocks()
    return data.loc[ts_code]
        

def call_daily(aday):
    filePath = COMMEN_FILE_PATH + f'daily_{aday}.csv'
    if not os.path.exists(filePath):
        
        df = pro.daily(trade_date=aday)
        if df.empty:
            return None
        df.to_csv(filePath)
        print('STORE:', filePath)
    else:
        df = pd.read_csv(filePath)
    return make_index(df)


def call_stock(ts_code, start_date, end_date):
    filePath = COMMEN_FILE_PATH + f'stock_{ts_code}_{start_date}_{end_date}.csv'
    if not os.path.exists(filePath):
        
        df = pro.daily(ts_code=ts_code, start_date=start_date, end_date=end_date)
        if df.empty:
            return None
        df.to_csv(filePath)
        print('STORE:', filePath)
    else:
        df = pd.read_csv(filePath)
    return make(df)


def call_stock_qfq(ts_code, start_date, end_date):
    filePath = COMMEN_FILE_PATH + f'stock_qfq_{ts_code}_{start_date}_{end_date}.csv'
    if not os.path.exists(filePath):
        
        df = ts.pro_bar(ts_code=ts_code, adj='qfq', start_date=start_date, end_date=end_date)
        if df.empty:
            return None
        df.to_csv(filePath)
        print('STORE:', filePath)
    else:
        df = pd.read_csv(filePath)
    return make(df)


def call_stock_v1(ts_code, start_date, end_date):
    if not ts_code.isdigit():
        ts_code = ts_code[:-3]
    filePath = COMMEN_FILE_PATH + f'v1_stock_qfq_{ts_code}_{start_date}_{end_date}.csv'
    if not os.path.exists(filePath):
        # code:股票代码，个股主要使用代码，如‘600000’
        # ktype:'D':日数据；‘m’：月数据，‘Y’:年数据
        # autype:复权选择，默认‘qfq’前复权
        # start：起始时间
        # end：默认当前时间
        df = ts.get_k_data(code=ts_code, ktype='m', autype='qfq', start=start_date, end=end_date)
        if df.empty:
            return None
        df.to_csv(filePath)
        print('STORE:', filePath)
    else:
        df = pd.read_csv(filePath)
    return make_v1(df)


if __name__ == '__main__':
    print(call_stock_info(test_ts_code_1))
