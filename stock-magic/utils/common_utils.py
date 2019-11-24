# -*- coding: utf-8 -*

import datetime


def today():
    today = datetime.date.today()
    return today.strftime('%Y%m%d')


def yesterday_v1():
    yesterday = datetime.date.today() - datetime.timedelta(days=1)
    return yesterday.strftime("%Y%m%d")


if __name__ == '__main__':
    print(today())
    print(yesterday_v1())
