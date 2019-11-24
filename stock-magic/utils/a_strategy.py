# -*- coding: utf-8 -*-

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
最大回撤
'''

from utils import a_stock
from utils import common_utils
from utils import ts_utils

DEBUG = False


def trick(aday):
    
    print('\n\n******************************************')
    print('A DAY:', aday)
    
    df = ts_utils.call_daily(aday)
    if df.empty:
        print('NO TRADE')
        return [aday, 'NO TRADE']
    # ##
    # 1 选出每日涨副在4.5 -5.5之间的
    # ##
    today_focus = df[(df.pct_chg > 4.5) & (df.pct_chg < 5.5)].copy()
    if DEBUG:
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
    
    if DEBUG:
        print('价格和成交量的位置:\n', t)
    
    # 去掉ST
    t = t[~(t.stock_name.str.contains(r'ST'))].copy()
    
    # 去掉P_position在30%以上的
    t = t[t.P_position < 40].copy()
    
    r = t[[ 'close', 'P_position', 'V_position', 'stock_name', 'stock_industry', 'stock_hs']]
    
    if r.empty:
        print('无合适股票')
        return [aday, '无合适股票']
    
    if DEBUG:
        print('去掉ST，位置在40以下:\n', t)
    
    yesterday = ts_utils.call_last_trade_day(common_utils.yesterday_v1())
    
    yesterday_df = ts_utils.call_daily(yesterday)
    
    r = r.join(yesterday_df, lsuffix="_L", rsuffix="_R")
    print(r)
    r['RESULT'] = round((r['close_R'] - r['close_L']) / r['close_L'] * 100, 2)
    
    r = r[[ 'close_L', 'close_R', 'P_position', 'V_position', 'stock_name', 'stock_industry', 'RESULT']]
    print('最后结果：\n', r)
    
    r_desc = r.describe()
    v_std = r_desc.loc['std', 'RESULT']
    if DEBUG:
        print('统计：\n', r_desc)
    
    rounds = len(r)
    win_df = r[r.RESULT > 0]
    lose_df = r[r.RESULT < 0]
    wins = len(win_df)
    # 胜率是指出手赚钱次数与总出手次数之比；
    win_ratio = round(wins / rounds * 100, 2)
    # 赔率是指平均每次出手赚到的钱除以平均每次出手赔的钱，也叫做盈亏比。
    if wins != 0:
        win_lose_ratio = (win_df['RESULT'].sum() / wins) / (lose_df['RESULT'].sum() / len(lose_df)) 
        win_lose_ratio = round(abs(win_lose_ratio), 2)
    else:
        win_lose_ratio = 0
    # 每日報酬(%)=(今天資產淨值-昨天資產淨值)/昨天資產淨值
    # 夏普率= [(每日報酬率平均值- 無風險利率) / (每日報酬的標準差)]x (252平方根)
    # 其中252平方根是因為一年大約有252天交易日，意思是將波動數值從每日調整成年
    # 當然如果資料上無法取得日資料，那用週資料或月資料也是可以。
    # 年化報酬率(%) = (總報酬率+1)^(1/年數) -1
    y_roi = 3
    sharpe_ratio = round((r_desc.loc['mean', 'RESULT'] - y_roi) / r_desc.loc['std', 'RESULT'], 2)
    max_lose = r.loc[r['RESULT'].idxmin(), 'RESULT']
    print('胜率：', win_ratio)
    print('赔率：', win_lose_ratio)
    print('最大回撤：', max_lose)
    print('夏普率：', sharpe_ratio)
    return [aday, rounds, win_ratio, win_lose_ratio, max_lose, sharpe_ratio]

    
if __name__ == '__main__':
    trick('20190613')
