春江水暖鸭先知
##############
:date: 2019-11-22 21:19
:author: rainasmoon
:category: 做生意
:slug: python101
:status: published

终于忍不住，想学习Python了。从开始的一点点摸索，到现在刚刚进了Python的神奇世界。对比原来使用的Java，编程真的是有一种幸福感啊。想想Python的理念，不要重复的发明轮子，可以这么说，日常的操作，都可以找到相应的库。从科学计算，到网站建设，从网络爬虫，到神经网络，从图象处理，到程序学习。真的是无所不包。

| 
|  
|  

本来原来的题目叫做：Python入门的，但是写着写着，发现收不住了。所幸，起一个风花学月的名字，挂个科技的外衣，想到哪写到哪。大概围绕着三件事性：Python学习，进化算法网站，大数据这三件事的。以上全做引子，正文如下：

但是，在进入Python的大门前，我们还是要做一些准备。这样才能愉快的玩耍，体味Python的方便（入坑）。如果您已经有了python的经验，那么您是我的老师。本文只是写给那些对Python一无所知的人。

Python是一门语法非常灵活的语言，如果做一件事情，C语言关注的是效率，如果程序需要2000行代码；那么用Java编写就只需要200行；而用Python？20行就可以了。但是Python的简洁灵活却并没有降低学习他的难度。

Python是一门十分遵循面向对象理念的解释型语言。它的理念除了不要重复发明轮子，还有： 显式的比隐式的更好；代码的可读性，格式更重要；只用一种正确的方式来完成一件事。解释型语言的核心要意是，你按照你的想象力写上一段话，然后Python就会照自己的想像力（？）试着去解释你的这段话，（哈哈）解释得通？OK。解释不通？报错。

Python是用空格的代码缩进来标识代码块的。不可以使用Tab来分割代码。使用对齐方式来区分代码块，这跟java和c都有很大的不同。

编写Python的开发环境：
======================

| Windows：强烈不推荐。后面各种坑。尤其是要引入各种第三方包时。最好的方式是在Windows下装虚拟机。
| 树莓派：很有意思，但是，说起来速度还是慢，尤其是在科学计算时。
| 阿里云：很理想的环境，上面可以24小时运行很多有意思的程序，实现想法。

学习Python从一个点先入手很重要。想一下子学习Python的方方面面？太旁杂了。了解一些重要的基础知识，就可以让Python为我们做很多事情。边使用边学习。

而我的目的是建一个网站。即进化算法网站。那么首先就要：

购买阿里云服务。
================

| install python3
|  install python3-pip
|  install uwsgi (yum & pip)
|  install Django

| 发布正式的网站应用使用：
|  Nginx+uwsgi+django的形式。

`阿里云 <https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=bk5k6azv>`__

安装环境
========

| apt install openssl-devel
|  apt install python3-tk
|  apt install libblas-dev liblapack-dev
|  apt install python3-spicy
|  apt install libxml2-dev libxslt1-dev
|  apt install -y python-lxml
|  pip install C:\\path\\to\\downloaded\\file\\lxml-3.6.1-cp27-cp27m-win32.whl
|  apt install libxml2-dev libxslt1-dev

更换国内pypi

开发工具
========

-  eclipse + PyDev
-  pycharm
-  vim

Python有意思的语法
==================

-  list，set，dict，tuple。[] {} {} ()
-  json，re，urllib，
-  格式化字符串：f，r
-  日期类型
-  访问json
-  True， False， None
-  list() set() str() int() len() type()
-  对运算符的重载
-  在py文件开头加入文件编码:
-  -*- coding: utf-8 -*-
-  parse.quote
-  .zfill
-  .isdigit

第三方库
========

制作词云

-  pillow
-  numpy
-  request
-  使用MySQL的lib
-  matplotlib
-  wordcloud
-  jieba
-  pymysql
-  mysqlclient
-  scikit-learn
-  scipy
-  pandas
-  seaborn
-  tushare
-  lxml
-  bs4

三个工具的介绍：
================

| jupter
|  Anaconda
|  MobaXterm: linux的X11 Fowarding

`Python树莓派编程 <https://union-click.jd.com/jdc?e=&p=AyIGZRtSFQcbBFUSWBAyFgdXHVoXBxMBVRhrUV1KWQorAlBHU0VeBUVNR0ZbSkdETlcNVQtHRVNSUVNLXANBRA1XB14DS10cQQVYD21XHgNVGV0UABcGUxtYJVFwYiVdLmdLd1gzTS58AkYPKGZYT2IeC2UaaxUDEwdQGFocCxQ3ZRtcJUN8B1QbWBAKEw5lGmsVBhQCUBhSEAQQAlcfaxICGzcWSwNKUlBbC0UEJTIiBGUraxUyETcXdV4QABoHVRwMHAsSAFAbUhNSF1MCGAhGARoGVksJQAAUN1caWhEL>`__

我要做的网站：
==============

商品排行榜，这是我要利用Python完成的第一件事情。

功能
====

#. 商品对比
#. 商品总排行。
#. 使用百度统计。
#. 后台，搜索商品。

DAY2的功能
==========

#. 类目排行，活越度排行。
#. 防刷，点击记录。
#. 商品排行静态化。（按天，按每小时刷新一次。）
#. 网上数据收集。
#. 推荐算法学习，21个问题树算法。

在网上购物时，遇到的问题是？
============================

| 人们关心什么？：价格，可靠，好用，幸福指数
|  人们会购买什么？通过什么渠道 ，在哪里，什么时候 ，

使用指标的方法来指导行动：指标原则：简单，计算可靠，而指标的解读由人去解读。

指标体系：采用值，百分比的两种方式。现在假设设置的指标：

-  评价集中度
-  置信空间
-  性价比指数
-  热度

`商品进化网站 <https://www.rainasmoon.com/products/>`__

白话大数据与机器学习
====================

这是Python引出的第二件事，看一本大数据的书。

数学的思维
----------

大数据和机器学习里有很多的数学，但是也只是把高中的很多数学知识综合运用一下罢了。这里面，函数，矩阵，方程，向量，极值，距离，概率，排列组合，变量代换，平面，三角函数等知识糅合在一起了。

平面，方程，函数的关系
----------------------

假设我有一个四维的平面： ax+by+cz+du+e=0

也可记作 f(x, y, z, u)=0

而这个函数的系数，即是一个四维向量：[a, b, c, d]

定义距离的概念及距离概念的扩展
------------------------------

在数轴上有两个点之间的距离；在平面上有两个点之间的距离；由此，扩展到n维空间的距离。

定义平面的概念及平面概念的扩展
------------------------------

平面，我向即可求点到平面的距离；平面可以把点分到两侧去；

向量
----

有大小，有方向，这是一个向量；由此，扩展到n维空间，即是得到一个n维的向量。假设一个四维空间的向量，我们可以把它记作：[a, b, c, d]

函数的概念
----------

函数的概念太重要了。他决定了某种可以对应，映射的变化，我们记作 y=f(x)。

.. code:: wp-block-preformatted

     y=f(x)

系数
----

对模型进行训练？其实是为了找到一个合适的方程的系数。

矩阵的运算
----------

对整个矩阵进行加减乘，的运算。由此，我们可以把多个向量组成矩阵。用离散数学对矩阵进行整体运算。

求导
----

求导即是求曲线的切线的斜率。

向量建模
--------

假设我们认为用户作决策跟用户的很多属性标签相关，那么即把用户的所有标签当作向量的一个维度进行建模：

[年龄，性别，学历，收入，家庭成员]

我们可以从这本书中学到的知识：
------------------------------

比如如何做天气预报，如何做一个推荐算法，怎样对用户进行画象，简单的图像识别，文本识别等。

这本书的启示：
==============

| 切莫纠结于学术方面的推导困难而不去实践
|  用离散来解决连续
|  用有穷来解决无穷
|  升维的方法
|  成本和精度的对立
|  映射是数学的重要思维
|  高斯分布，即是二八法则

`白话大数据与机器学习 <https://union-click.jd.com/jdc?e=&p=AyIGZRtYFAcXBFIZWR0yEgddGVgdARo3EUQDS10iXhBeGlcJDBkNXg9JHU4YDk5ER1xOGRNLGEEcVV8BXURFUFdfC0RVU1JRUy1OVxUCGgVWE1gdMkFdMG8cbwV1ZQkBJmhUSm4ME1pRS2ILWStaJQITBlUeWBQLGwFlK1sSMkBpja3tzaejG4Gx1MCKhTdUK1sRBBcCVh1cEAcVAlQrXBULIkQFQwRFQE5ZC0RrJTIRN2UrWyUBIkU7GAgRBEACXRoMHAERAlxOXR0HFwFdGFkdCxtSAh9YQVEiBVQaXxw%3D>`__

接着说第三方库
==============

numpy
-----

| np.arange( 1, 150, 10 ).reshape(3, 5)
|  np.linspace(1, 100, 1000)

pandas
------

pandas有两个重要的数据结构Series DataFrame

-  s = Series(np.random.randint(1,10,4), index=['a','b','c','d'])
-  df = DataFrame(np.random.randint(1,10,24).reshape(6,4), index=dates, columns=list('ABCD'))

常用方法：

-  .head()
-  .tail()
-  .plot()
-  .sum()
-  .index
-  .value

seaborn
-------

| .jointplot
|  .pairplot

量化投资
========

这是Python引起的第三件事。也是正在尝试的一件事。欢迎有兴趣的同学一块来探讨。

VN.PY
-----

重要的概念
----------

sharp率： （收益-无风险利率）/波动率；

胜率是指出手赚钱次数与总出手次数之比；

赔率是指平均每次出手赚到的钱除以平均每次出手赔的钱，也叫做盈亏比。

投资策略，有的是高胜率低赔率，有的是低胜率高赔率，两样都高的，基本是不存在的。一般来说，胜率在40%左右，盈亏比在2以上的，就算不错的策略了。

程序化CTA
---------

这是一种低胜率，高赔率的方法。

程序化交易由入场条件、出场条件，品种选择、时机选择，资金管理，一起组成。

我们追求的策略是：达到40%左右胜率，盈亏比在2以上，夏普率在1.5以上，最大回撤比一手保证金要少，最大回撤越小越好。这里面，最终看的指标是夏普率，但也并不是越高越高，太高的话，很可能是你的策略过拟合了。

注册获得开源股票数据API
-----------------------

`注册Tushare <https://tushare.pro/register?reg=324197>`__

FAQ：
=====

-  1 centos，windows，aws的linux，
-  2 两个版本的uwsgi
-  3 nginx+uwsgi+django
-  4 两个网站的双备份
-  5 两个python版本，两个pip
-  6 更换国内pypi
-  7 urllib的三个版本
-  8 值得谈的/usr/local/src目录
-  9 md5的签名算法
-  10 URL对空格等的处理
-  11 虚拟机开启swap分区
-  12 nginx的端口和socket文件
-  13 版本问题
-  14 注意操做系统的版本，firefox的版本，Geckodriver的版本，selenium的版本，python3的版本，pip的版本，setuptools的版本，数据库的版本，sqlite，mysql，mariadb的版本
-  15 mariadb&mysql
-  16 windows被卡在了vc++14.0的动态库上。
-  17 cento: yum install python-devel mysql-devel
-  18 字符集utf8 与 utf8mb4 异同，utf8mb4\_unicode\_ci 与 utf8mb4\_general\_ci
-  19 自己编译sqlite，python3。启用ssl
-  20 问题的可能的解决思路

   -  使用apt安装dev依赖
   -  安装repository版
   -  安装python3-xxx版
   -  使用pip安装
   -  安装预编译版
   -  下载源码，用源码安装
   -  检查是否是安装的版本太旧，文档已经过期、
   -  多使用官网，

-  21 问题的依赖链条

   -  python3 xxx.py
   -  python3 -m pip install tushare
   -  python3 -m pip install lxml
   -  apt apt-get install libxml2-dev libxslt1-dev
   -  apt update
   -  apt upgrade


