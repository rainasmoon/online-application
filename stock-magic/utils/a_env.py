# -*- coding: utf-8 -*-

from utils import ts_utils

'''
上证指数
上证成份股
上证指数处在各区间的概率：
先计算分数，
再计算分类：60分以下，80分以上。不及格，及格，优秀，卓越
个股是否在成份股里。

'''


def summury_env(aday):
    y_roi = ts_utils.call_deposit_rate_v1()
    df_sh_index = ts_utils.call_index_v1()
    sh_index = round(df_sh_index.loc['000001', 'close'])
    sh_vol = df_sh_index.loc['000001', 'volume']
    cpi = ts_utils.call_cpi()
    m = ts_utils.call_money_supply()
    
    df = ts_utils.call_sh_index_v1()
    df = df.describe().round(2)
    low = df.loc['min', 'low']
    high = df.loc['max', 'high']
    vol_max = df.loc['max', 'volume']
    vol_min = df.loc['min', 'volume']
    index_position = round((sh_index - low) / (high - low) * 100, 2)
    sh_vol_position = round((sh_vol - vol_min) / (vol_max - vol_min) * 100, 2)
    print(f'一年存款利率：{y_roi},\n 上证指数：{sh_index},\n 位置：{index_position}%,\n 成交量：{sh_vol},\n 位置：{sh_vol_position}%,\n CPI: {cpi},\n M: {m}\n')
    return [y_roi]


if __name__ == '__main__':
    summury_env('20191122')
