# -*- coding: utf-8 -*-

from utils import a_stock
from utils import common_utils
from utils import ts_utils

'''
600:主板
000:深市
002:中小板
300:创业板
688:科创板
ST:
*ST:
'''

yesterday = common_utils.yesterday()
print('YESTERDAY:', yesterday)

df = ts_utils.call_daily(yesterday)
# ##
# 1 选出每日涨副在4.5 -5.5之间的
# ##
today_focus = df[(df.pct_chg > 4.5) & (df.pct_chg < 5.5)].copy()
print('MGAIC STOCKS:\n', today_focus)

# 根据ts_code查询股票信息
today_focus['ts_code_orginal'] = today_focus.index.to_numpy()
ext_info = today_focus.loc[:, 'ts_code_orginal'].map(a_stock.a_stock)
# 把返回的结果扩展拆分成列
df_ext = ext_info.str.split(',', expand=True)
today_focus[['price_max', 'price_min', 'vol_max', 'vol_min', 'stock_name', 'stock_industry', 'stock_hs']] = df_ext
today_focus[['price_max', 'price_min', 'vol_max', 'vol_min']] = today_focus[['price_max', 'price_min', 'vol_max', 'vol_min']].applymap(float)

# 计算价格和成交量的位置
t = today_focus
t['P_position'] = round((t['close'] - t['price_min']) / (t['price_max'] - t['price_min']) * 100, 2)
t['V_position'] = round((t['vol'] - t['vol_min']) / (t['vol_max'] - t['vol_min']) * 100, 2)

print(t.describe())

r = t[[ 'close', 'P_position', 'V_position', 'stock_name', 'stock_industry', 'stock_hs']]
print(r)
