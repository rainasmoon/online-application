# -*- coding: utf-8 -*-

import datetime
import pandas as pd

from utils import a_strategy


def backward_test():
    begin = datetime.date(2019, 1, 1)
    end = datetime.date(2019, 10, 1)
    
    for i in range((end - begin).days + 1):
            day = begin + datetime.timedelta(days=i)
            aday = day.strftime("%Y%m%d")
            a_strategy.trick(aday)

            
def backward_test_permonth():
    
    begin = datetime.date(2010, 1, 1)
    
    r_final_report = []
    
    for i in range(120):
        day = begin + datetime.timedelta(days=i * 30)
        aday = day.strftime("%Y%m%d")
        print(aday)
        r_final_report.append(a_strategy.trick(aday))
    df = pd.DataFrame(r_final_report, columns=['aday', 'rounds', 'win_ratio', 'win_lose_ratio', 'max_lose', 'sharpe_ratio'])   
    print('FINAL SUMMURY:\n', df.dropna())
    print(df.describe())
    print('END.')


backward_test_permonth()

