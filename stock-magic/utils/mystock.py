# -*- coding: utf-8 -*

from datetime import date

from pylab import mpl

import matplotlib.pyplot as plt
from utils import ts_utils

# 正常显示画图时出现的中文
# 这里使用微软雅黑字体
mpl.rcParams['font.sans-serif'] = ['SimHei']
# 画图时显示负号
mpl.rcParams['axes.unicode_minus'] = False

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
stock_info = '{0}-{1}-{2}'.format(astock['name'].iloc[0], astock['industry'].iloc[0], astock['list_date'].iloc[0])
print('STOCKNAME:', stock_info)

df = ts_utils.call_stock_qfq(stock_code, ipo_date, today)
print('ALL TRADE:\n', df)

main_info = df.describe().round(2)
print('MAIN INFO:\n', main_info)

df.index = ts_utils.to_date(df.trade_date)
stock_close = df['close']
stock_close.plot()
plt.title('STOCK' + stock_info)
plt.xlabel('日期')
plt.show()

