如何做Wordpress的双服务器备份？
###############################
:date: 2019-10-07 16:35
:author: rainasmoon
:category: 做生意
:slug: backup-wordpress
:status: published

互联网上似乎有同步两台wordpress的插件。但插件似乎并不是免费的。也有一种方式是使用JS在一台服务器上发布文章，使用wordpress接口API同时发布文章到另一台wordpress上。但是，做为一个程序员，这件事情我打算自己来实现。

| 
|  
|  

前两天不知道什么原因，架设在日本亚马逊上的wordpress突然变慢，无法访问。于是就趁着阿里云做活动买了阿里云的标准VPS服务器。

做了个wordpress阿里云，亚马逊aws互相备份。

整体思路是：两台服务器分别独立安装mysql，wordpress，及nginx。两台mysql搭建双主互备。wordpress使用rsync定时同步。

效果基本达到。以后再也不怕一台服务器突然不能访问了。

具体过程如下：

在新服务器上安装nginx，php，mysql。
===================================

拷贝原服务器wordpress目录到新服务器。安装wordpress。

.. code:: wp-block-preformatted

    tar -czvf wordpress.tar.gz wordpress

scp -r wordpress.tar.gz root@server\_new\_ip:/var/www/html/

tar -xzvf wordpress.tar.gz

在新的服务器上删除wp-config.php。并运行重新安装wordpress。

搭建mysql的双主互备
===================

mysql可以实现主主互备。这样可以做到无论联结到哪台mysql，都可以把数据同步到另一台上。

mysql的字符集

mysql

mariadb

搭建ssh的免密登录
=================

生成公钥和私钥

.. code:: wp-block-preformatted

    ssh-keygen -t rsa 

把公钥拷贝到另一台服务器

.. code:: wp-block-preformatted

    ssh-copy-id userb@serverb

会把公钥拷贝到：~/.ssh/authorized\_keys

开通防火墙数据库端口
====================

开通3306端口。使另一台服务器的IP可以访问这台服务器。

使用定时任务同步两台服务器
==========================

我是在aws上开通的定时任务：

.. code:: wp-block-preformatted

    sudo rsync -rave "ssh -i /home/ec2-user/.ssh/id_rsa"  /var/www/html/wordpress/ root@vpsip.aliyun:/var/www/html/wordpress

aws的官方镜像并不是使用crontab。而是使用/etc/crontab的配置文件:

.. code:: wp-block-preformatted

    0 0 * * * root /home/ec2-user/sync-wordpress.sh

每天0点执行一次。

设置DNS解析规则
===============

设置域名如：www.rainasmoon.com指向到aliyun\_ip，设置使用规则国外解析到aws\_ip。

阿里云地址：
============

`阿里云 <https://promotion.aliyun.com/ntms/yunparter/invite.html?userCode=bk5k6azv>`__

常用命令：

查看本机外网IP：

.. code:: wp-block-preformatted

     curl ifconfig.co

参考：

-  `mysql双主互备 <https://blog.csdn.net/u012728971/article/details/82946824>`__
-  `ssh免密登录 <https://www.cnblogs.com/wenxingxu/p/9597307.html>`__


