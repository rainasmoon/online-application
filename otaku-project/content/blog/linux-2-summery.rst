linux操作系统概述（提纲）
#########################
:date: 2018-03-04 18:18
:author: rainasmoon
:category: 做生意
:slug: linux-2-summery
:status: published

.. raw:: html

   <figure class="wp-block-image">

| |linux version|

.. raw:: html

   <figcaption>

linux change your life

.. raw:: html

   </figcaption>
   </figure>

还是每个话题一句话，为linux系画像，带您进入linux这个更多可以自己控制的世界。当您了解得越多，您越会发出linux的美和合理。希望你能找到真正属于自己的系统的感觉。

linux核心介绍
=============

| 
|  
|  

linux的其它的东西

/etc/default

/lib/systemd/system：

/etc/systemd/system/mutil-user-targets-wanted

/var/run/：运行时的文件及配置。

linux 的网络管理
================

network

NetworkManager
--------------

NetworkManager可以内置dnsmasq。这里就可以有两种方式，一种是把dnsmasq交给NetworkManager来管理。另一种是让NetworkManager来放弃对DNS的管理 。

NetworkManger可以管理有线网卡，WIFI，VPN，PPPOE(播号)。还可以实现热点功能。可以说是一个集大成者。

NetworkManager有自己的DHCP client。当然也可以使用外部的DHCP client。

.. code:: wp-block-preformatted

    /etc/NetworkManager/conf.d/dns-servers.conf

可以在上层设置自定义的DNS。也可以在底层/etc/resolv.conf定义自定义的DNS。可以使用第三方的openresolv（这是一个抽象的第三层。定义了一个软链接到/etc/resolv.conf）。也可以使用系统服务systemd-resoved。

NetworkManager如何和dnsmasq， dhclient， openresolve，systemd-resolved共同工作。

设置dns=none让NetworkManager不去管理/etc/resolv.conf

ipv6.method=shared

ipv6.method=auto

Wpa-supplant
------------

wpa-supplant只管理wifi

dhclient
--------

一系列的dhcp的配置命令。在系统启动时执行。另一个起到同样功能的是dhcpcd。NetworkManager内部的dhcp client使用的是systemd-networkd提供的功能。

/etc/resolv.conf
----------------

systemd-resolved

``resolvconf``
--------------

dnsmasq
-------

dnsmasq is a stub resolver not a recursive resolver。所以dnsmasq的上游把/etc/resolv.conf定义的所有DNS请求截获，下游交给其它域名解析服务器。

/etc/network/interface -> /etc/resolv.conf -> dnsmasq -> resolvconf -> NetworkManager

最终的解决方案是：

不要在/etc/network/interface里做配置。卸载resolvconf的功能。让NetworkManager放弃DNS的管理 ，只做dhcp的管理。dnsmasq放弃dhcp的管理。从/etc/resolv.conf截获所有的DNS请求，把他们转发给unbound。

hook
----

一种机制，可以在设备的启动和停止时执行角本。

软链接
------

软链接和文件夹的配合实现了一种很好的文件管理结构。而这种特点同时表现在命令和alias里。

如果能同时理解软链接，文件夹，命令和alias。就可以实现很复杂的功能了。

DNS的列表
---------

使用这种列表的机制，可以保证DNS能被安全的解析。

命令
----

-  networkctl
-  nmcli
-  nmtui
-  wpa\_cli
-  ip
-  dhclient -v -6 -P -D LL wlan0

linux 的服务管理
================

linux 的systemd
---------------

/etc/systemd/system

/lib/systemd/system

@传递配置文件的参数

linux 的启动grub
================

linux 的磁盘
============

| fat
| ntfs
| ext系列
| lvm的概念：用这个玩意可以对硬盘加密喽。
| raid的概念：所谓的备份，普通人用不到吧？

linux 的字体管理
================

| 字体，字符集，编码。
| 刚刚装完系统，浏览器遇到中文乱码，或者成了一个个小方框，这都是字体，字符集惹的祸。
| GBK
| GB2312
| ISO8859
| UTF-8：是对unicode的编码。
| GB18230
| UNICODE
| ASCII

时间管理，时区
==============

桌面 的启动
===========

/proc
=====

| 查看各种各样的信息
| /proc/version：linux的版本信息。
| /proc/cpuinfo：cpu的信息。
| /proc/meminfo：内存的信息。

/dev
====

| 一切的设备都在这个下面，
| /dev/sda: 磁盘
| /dev/shm: 内存设备 , tmpfs,
| /dev/stdin & /dev/stdout
| /dev/tty

有神奇的设备
============

| /dev/null: 输出设备，称做黑洞，给这个设备的所有东西都被抛弃了。
| /dev/zero：输入设备，能够提供无数个0。

/media
======

U盘和移动硬盘的自动挂载都放到了这个里面，并且fedora是按用户来分文件夹了，u盘分以一个奇怪的数字串开头。在没有这些自动挂载之前，都是要手动安装的到/mnt下的。估计将来/mnt的作用会被/media取代。

usb管理
=======

bluetooth管理
=============

linux 防火墙
============

linux iptable即为linux下的防火墙，天生自带，内核支持 ，但如果想用界面型式的？另安装软件。

host文件
========

太喜欢的文件了，能用他来实现很多神奇的功能。

无线网卡的配置: driver -> wpa supplicant(deamon) -> cli \| gui

ifconfig vs iwconfig

NAT
===

把私有IP，转化成外部共公IP. 有三种方式: 静态, 动态, 多路端口复用。是一种为了解决有限的ip地址而使用的技术。中国移动据说做事用的是动态ip。

网络协议的层次:
===============

| 7层 vs tcp/ip四层
| 应用层: HTTP, telnet, NFS、RCP，SMTP
| IP
| TCP：3次握手建立了一连接，如telnet， FTP，smtp
| UDP：广播的形式。一些查询都是UDP 式的响应。
| IMCP：ping 即是IMCP。

有意思的命令
============

| uname -a 查看linux的版本信息
| /etc/grub.conf 存放的是系统启动的信息
| /boot 存放启动镜像
| iptables -L 查看当前iptables名细

linux的进程调用

linux 下的链接
==============

ln 可以建立一个连接 ，有点像linux的快捷方式，不过，你平时可以像操做一个正常文件夹一个去操做这个链接。以前在lvm没有出来之前，可以用这种方式来扩展一个磁盘，编译linux内核时，或者安状java时，都可以用链接的方式，或者linux启动内核时，都可以方面的去切换版本。

linux 的权限
============

| 用户管理，owner:group:other的概念。
| 读，写，执行的概念

/etc/fstab
==========

管理磁盘

/etc/profile
============

各用户的.bashrc 及.bashrc\_profile

神奇好用的 alias
================

管道符的概念
============

可以把好多命令串联起来使用。还有&& 及 \|\| 这两个。

tail；touch；cat; locale; awk; grep; head; more; less;

wget; curl
==========

神奇的下载工具。当然还有aria2

crontab
=======

linux计划任务

.sh
===

shell角本编程

tmux &vim
=========

-  ``tmux new -s asession``
-  ``Ctrl-b d``
-  ``tmux attach -t asession``
-  ``Ctrl-b %``
-  ``Ctrl-b "``

一定不能错过的一本Linux学习的好书：

`鸟哥的Linux私房菜 基础学习篇 <https://union-click.jd.com/jdc?e=&p=AyIGZRtYFAcXBFIZWR0yEgRQHlkcChM3EUQDS10iXhBeGlcJDBkNXg9JHU4YDk5ER1xOGRNLGEEcVV8BXURFUFdfC0RVU1JRUy1OVxUBFwJXElMUMnJyUWAnY18UYiVbIEdhZX4UeSETZ3ILWStaJQITBlUeWBQLGwFlK1sSMkBpja3tzaejG4Gx1MCKhTdUK1sRBBcPVhpTHQASD1crXBULIkQFQwRFQE5ZC0RrJTIRN2UrWyUBIkU7TA5FCxoCB05SEFcaAlRPWRwARw9TGw8dUUADBRxeE1IiBVQaXxw%3D>`__

.. |linux version| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/operating-system-1995434_1280-1024x633.png
