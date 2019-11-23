# -*- coding: utf-8 -*-

from utils import a_stock
from utils import common_utils
from utils import ts_utils

'''
600:主板
603:
000:深市
002:中小板
300:创业板
688:科创板
ST:
*ST:
'''

'''
1 选出每日涨副在4.5 -5.5之间的
2 去除ST
3 去除价格为30%之上的
4 

TODO:
5 大盘
6 资金管理
7 模拟复盘
6 板块

7 已经退市的股票

NOW:
一定时间之前的股票于今天的对比。

sharp率： （收益-无风险利率）/波动率
胜率是指出手赚钱次数与总出手次数之比；
赔率是指平均每次出手赚到的钱除以平均每次出手赔的钱，也叫做盈亏比。
'''

aday = '20191022'
print('ADAY:', aday)

df = ts_utils.call_daily(aday)
# ##
# 1 选出每日涨副在4.5 -5.5之间的
# ##
today_focus = df[(df.pct_chg > 4.5) & (df.pct_chg < 5.5)].copy()
print('MGAIC STOCKS:\n', today_focus)

# 根据ts_code查询股票信息
today_focus['ts_code_orginal'] = today_focus.index.to_numpy()
ext_info = today_focus.loc[:, 'ts_code_orginal'].apply(a_stock.a_stock, args=(aday,))
# 把返回的结果扩展拆分成列
df_ext = ext_info.str.split(',', expand=True)
today_focus[['price_max', 'price_min', 'vol_max', 'vol_min', 'stock_name', 'stock_industry', 'stock_hs']] = df_ext
today_focus[['price_max', 'price_min', 'vol_max', 'vol_min']] = today_focus[['price_max', 'price_min', 'vol_max', 'vol_min']].applymap(float)

# 计算价格和成交量的位置
t = today_focus
t['P_position'] = round((t['close'] - t['price_min']) / (t['price_max'] - t['price_min']) * 100, 2)
t['V_position'] = round((t['vol'] - t['vol_min']) / (t['vol_max'] - t['vol_min']) * 100, 2)

# 去掉ST
t = t[~(t.stock_name.str.contains(r'ST'))].copy()

# 去掉P_position在30%以上的
t = t[t.P_position < 40].copy()

print(t.describe())

r = t[[ 'close', 'P_position', 'V_position', 'stock_name', 'stock_industry', 'stock_hs']]

yesterday = common_utils.yesterday()
print('YESTERDAY:', yesterday)

yesterday_df = ts_utils.call_daily(yesterday)

r = r.join(yesterday_df, lsuffix="_L", rsuffix="_R")
r['RESULT'] = round((r['close_R'] - r['close_L']) / r['close_L'] * 100, 2)

r = r[[ 'close_L', 'close_R', 'P_position', 'V_position', 'stock_name', 'stock_industry', 'RESULT']]
print(r)
