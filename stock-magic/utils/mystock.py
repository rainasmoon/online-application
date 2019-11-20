# -*- coding: utf-8 -*

from utils import plt_utils
from utils import ts_utils

today = '20191119'
print('TODAY:', today)

df = ts_utils.call_daily(today)
today_focus = df[(df.pct_chg > 4.5) & (df.pct_chg < 5.5)]

print('MGAIC STOCKS:\n', today_focus)

stock_code = '300462.SZ'
print('A STOCK:', stock_code)
astock = ts_utils.call_stock_info(stock_code)
print('BASIC:\n', astock)

ipo_date = str(astock['list_date'].iloc[0])
stock_info = '{0}-{1}-{2}'.format(astock['name'].iloc[0], astock['industry'].iloc[0], astock['symbol'].iloc[0])
print('STOCKNAME:', stock_info)

df = ts_utils.call_stock_qfq(stock_code, ipo_date, today)

print('ALL TRADE:\n', df)
print('All Columns:\n', df.dtypes)

main_info = df.describe().round(2)
print('MAIN INFO:\n', main_info)

# plt_utils.show_k(df, stock_info)
# plt_utils.show_vol(df, stock_info)
# plt_utils.show_ma(df, stock_info)

df = ts_utils.call_stock_v1(stock_code, ipo_date, today)

print('MONTH DATA:\n', df)

main_info = df.describe().round(2)
print('MAIN INFO:\n', main_info)

# plt_utils.show_mon_k_v1(df, stock_info)
