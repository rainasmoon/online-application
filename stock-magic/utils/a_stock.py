# -*- coding: utf-8 -*-
from utils import common_utils
from utils import plt_utils
from utils import ts_utils

test_ts_code_1 = '000001.SZ'


def show_a_stock(stock_code, end_date):
    print('A STOCK:', stock_code)
    astock = ts_utils.call_stock_info(stock_code)
    print('BASIC:\n', astock)
    
    ipo_date = str(astock['list_date'])
    stock_info = '{0}-{1}-{2}'.format(astock['name'], astock['industry'], astock['symbol'])
    print('STOCKNAME:', stock_info)
    
    df = ts_utils.call_stock_qfq(stock_code, ipo_date, end_date)
    
    print('ALL TRADE:\n', df)
    print('All Columns:\n', df.dtypes)
    
    main_info = df.describe().round(2)
    print('MAIN INFO:\n', main_info)
    
    price_max = main_info.loc['max', 'high']
    price_min = main_info.loc['min', 'low']
    vol_max = main_info.loc['max', 'vol']
    vol_min = main_info.loc['min', 'vol']
    return f'BIGPIC:[{price_max}:{price_min}:{vol_max}:{vol_min}]'
    
    plt_utils.show_k(df, stock_info)
    plt_utils.show_vol(df, stock_info)
    plt_utils.show_ma(df, stock_info)
    
    df = ts_utils.call_stock_v1(stock_code, ipo_date, end_date)
     
    print('MONTH DATA:\n', df)
     
    main_info = df.describe().round(2)
    print('MAIN INFO:\n', main_info)
     
    plt_utils.show_mon_k_v1(df, stock_info)


def a_stock(stock_code, aday):
    astock = ts_utils.call_stock_info(stock_code)
    if astock.empty :
        return 'nan, nan, nan, nan, "已退市,已退市,N"'
    ipo_date = str(astock['list_date'])
    stock_info = '{0},{1},{2}'.format(astock['name'].ljust(5, chr(12288)), astock['industry'].ljust(5, chr(12288)), astock['is_hs'])
    
    df = ts_utils.call_stock_qfq(stock_code, ipo_date, aday)
    
    main_info = df.describe().round(2)
    
    price_max = main_info.loc['max', 'high']
    price_min = main_info.loc['min', 'low']
    vol_max = main_info.loc['max', 'vol']
    vol_min = main_info.loc['min', 'vol']
    return f'{price_max}, {price_min}, {vol_max}, {vol_min}, {stock_info}'


if __name__ == '__main__':
    print(a_stock(test_ts_code_1, common_utils.yesterday()))
    
    show_a_stock(test_ts_code_1, common_utils.yesterday())
