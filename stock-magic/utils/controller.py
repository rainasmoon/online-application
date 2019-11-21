# -*- coding: utf-8 -*

from utils import plt_utils
from utils import ts_utils

today = '20191121'
print('TODAY:', today)

df = ts_utils.call_daily(today)
today_focus = df[(df.pct_chg > 4.5) & (df.pct_chg < 5.5)].copy()
print('MGAIC STOCKS:\n', today_focus)


def a_stock(stock_code):
    astock = ts_utils.call_stock_info(stock_code)
    
    ipo_date = str(astock['list_date'].iloc[0])
    stock_info = '{0}-{1}-{2}'.format(astock['name'].iloc[0], astock['industry'].iloc[0], astock['symbol'].iloc[0])
    
    df = ts_utils.call_stock_qfq(stock_code, ipo_date, today)
    
    main_info = df.describe().round(2)
    
    price_max = main_info.loc['max', 'high']
    price_min = main_info.loc['min', 'low']
    vol_max = main_info.loc['max', 'vol']
    vol_min = main_info.loc['min', 'vol']
    return f'{price_max}, {price_min}, {vol_max}, {vol_min}'


temp_r = today_focus.loc[:, 'ts_code'].map(a_stock)
df2 = temp_r.str.split(',', expand=True)
today_focus[['price_max', 'price_min', 'vol_max', 'vol_min']] = df2.applymap(float)
print(today_focus.dtypes)
t = today_focus
t['P_'] = round((t['close'] - t['price_min']) / (t['price_max'] - t['price_min']) * 100, 2)
t['V_'] = round((t['vol'] - t['vol_min']) / (t['vol_max'] - t['vol_min']) * 100, 2)
print(t)
print(t.describe())
print(t.loc[t.P_ < 10, ['price_max', 'price_min', 'close', 'P_']])
