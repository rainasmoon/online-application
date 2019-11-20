import datetime 

print(datetime.date(2019, 1, 1))
print(datetime.datetime.strptime(str(20191111), '%Y%m%d'))

ts_code = '300000.sz'
print(ts_code)
print(ts_code.isdigit())
print(ts_code[:-3])

