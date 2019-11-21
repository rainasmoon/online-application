

def a_stock(stock_code):
    print('A STOCK:', stock_code)
    astock = ts_utils.call_stock_info(stock_code)
#     print('BASIC:\n', astock)
    
    ipo_date = str(astock['list_date'].iloc[0])
    stock_info = '{0}-{1}-{2}'.format(astock['name'].iloc[0], astock['industry'].iloc[0], astock['symbol'].iloc[0])
    print('STOCKNAME:', stock_info)
    
    df = ts_utils.call_stock_qfq(stock_code, ipo_date, today)
    
#     print('ALL TRADE:\n', df)
#     print('All Columns:\n', df.dtypes)
    
    main_info = df.describe().round(2)
#    print('MAIN INFO:\n', main_info)
    
    price_max = main_info.loc['max', 'high']
    price_min = main_info.loc['min', 'low']
    vol_max = main_info.loc['max', 'vol']
    vol_min = main_info.loc['min', 'vol']
    return f'BIGPIC:[{price_max}:{price_min}:{vol_max}:{vol_min}]'
    
    # plt_utils.show_k(df, stock_info)
    # plt_utils.show_vol(df, stock_info)
    # plt_utils.show_ma(df, stock_info)
    
    # df = ts_utils.call_stock_v1(stock_code, ipo_date, today)
    # 
    # print('MONTH DATA:\n', df)
    # 
    # main_info = df.describe().round(2)
    # print('MAIN INFO:\n', main_info)
    
    # plt_utils.show_mon_k_v1(df, stock_info)
