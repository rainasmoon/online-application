# -*- coding: utf-8 -*-

from utils import ts_utils


def summury_env(aday):
    y_roi = ts_utils.call_deposit_rate_v1()
    sh_index = ts_utils.call_index_v1()
    cpi = ts_utils.call_cpi()
    m = ts_utils.call_money_supply()
    
    print(f'{y_roi}, {sh_index}, {cpi}, {m}')
    return [y_roi]


if __name__ == '__main__':
    summury_env('20191122')
