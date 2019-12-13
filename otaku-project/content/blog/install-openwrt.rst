安装openwrt
###########
:date: 2019-10-12 00:31
:author: rainasmoon
:category: 做生意
:slug: install-openwrt
:status: published

.. raw:: html

   <figure class="wp-block-image">

| |install openwrt|

.. raw:: html

   <figcaption>

Install openwrt

.. raw:: html

   </figcaption>
   </figure>

openwrt以其类似linux的系统格式，可更新的系统，给路由器带来了更多的可定制化玩法。但同时，也要求我们对路由的原理有更多的理解，对我们学习和使用网络也更有帮助。

| 
|  
|  

openwrt为cisco开源后的一个代码分支。拥有丰富的功能包和插件。几乎你能想像到的功能都可以在这里找到支持。比如同时播号移动和电信网络。甚至同时使用手机流量。丰富的流量控制策略。

0 路由器
========

不推荐是普通的TP-Link，迅捷，腾达等大众路由器。

推荐使用华硕路由器，网件路由器，Linksys路由器 。选择要点是内存，存储越大越好。因为内存越大越有利于openwrt的运行。存储越大可以安装更多的软件。

1 刷固件
========

最新稳定版本为：18.06.4

分为stable版， snapshot版（此版本无网页版的管理界面luci）。

请选择带有sysupgrade的tar压缩包或img镜像文件。此文件为完整安装包。登录路由器原始后台管理界面。上传固件。刷机。

刷机结束后，用电脑网线连接路由器。路由器会默认设置成IP：192.168.1.1。使用浏览器访问此地址打开管理后台。

2 登录
======

由于openwrt为linux系统。所以管理路由器即是管理linux系统。使用ssh登录路由器。

``ssh root@192.168.1.1``

设置密码

``passwd``

换源
====

opkg为openwrt的包管理工具。以下命令最为常用：

-  opkg update
-  opkg install package-name
-  opkg remove package-name
-  opkg search package-name

官方源下载速度奇慢。所以改用其它源。 但在这之前，必须安装https支持。

``opkg install libustream-mbedtls``

有清华大学的源和中国科技大学的源。登录ssh，修改/etc/opkg/distfeeds.conf使其指向中国科技大学源https://mirrors.ustc.edu.cn/lede/

``opkg update``

安装必要的准备软件：

``opkg install wget ca-certificates``

``opkg install iptables-mod-nat-extra ipset iptables-mod-tproxy``

3 管理界面
==========

开发版需要手动安装后台界面：

``opkg install luci``

uci命令为管理后台的命令行形式。

/etc/config/下的配置文件对应管理后台里的设置。/etc/config和/etc/下的配置同时起作用。

访问：http://192.168.1.1/ 打开管理界面。

4 开启WIFI
==========

登录管理后台： http://openwrt/或者 http://192.168.1.1/在Network》Wireless下。分别有radio0和radio1，分别代表2.5G和5G。分别在他们下面编辑或设置相应的无线网络。并设置密码。密码采用WPA2PSK格式。

设置国家代码：设置国家代码为AU。

5 adblock
=========

安装去广告插件：

``opkg install adblock``

``opkg install luci-app-adblock``

在管理界面打开reg\_cn列表源。

更新广告列表。全局去广告。

6 unbound
=========

 unbound是本地的域名解释软件。dnsmasq只能起到DNS解析转发作用。而unbound可以实现完整的DNS功能。

``opkg install unbound``

``opkg install luci-app-unbound``

``opkg install ca-bundle``

ca-bundle可以实现DNS over TLS功能。即DNS的解析加密传输。而普通的DNS解析，都是明文传输的。

openwrt中dhcp，dnsmasq，unbound三者的关系。
===========================================

dhcp起到局域网的IP分配，DNS分配的功能。在最前端。dnsmasq可以实现hosts文件的功能，并可实现广告拦截。unbound可以实现安全的DNS解析功能。dnscrypt-proxy可以让我们不使用公共的DNS。这四者的关系如下：

dhcp》dnsmasq》unbound》dnscrypt-proxy

为了使用去广告的功能。需要使用完整版的dnsmasq。运行以下命令：

``opkg remove dnsmasq && opkg install dnsmasq-full``

firewall
========

ipset是一个IP列表，可以 iptables配合使用。

使指向这些IP的路由全部都转发到11100端口。一些特殊的路由功能。可以用ipset实现。如在dnsmasq里做如下配置：

/etc/dnsmasq.d/custom\_ipset.conf

.. code:: wp-block-preformatted

    server=/abc.com/127.0.0.1#5353
    ipset=/abc.com/aiplist

以下这样设置即可实现以上解析的DNS的IP全部都转发到11100的链路上去。

``ipset -N aiplist iphashiptables -t nat -A PREROUTING -p tcp -m set --match-set `` ``aiplist dst -j REDIRECT --to-port 11100iptables -t nat -A OUTPUT -p tcp -m set --match-set aiplist dst -j REDIRECT --to-port 11100``

dnsmasq工作在53端口，监听DNS请求。unbound工作在5353端口。dnscrypt-proxy工作在10053端口。

ss-local工作在11080端口， ss-redir工作在11100端口。 ss-tunel工作在5300端口，在本例中使用unbound代替。

firewall，iptable，route三者的关系
==================================

route 管理的是多个网卡。如果把路由器看做是多网卡计算机，那么每个网口，如4个千兆LAN口加2个wifi口 （2.4G和5G） 和一个WAN口（外网接口）即代表有7个网卡每个网卡都有可能联接着一个网络或设备。而路由表则即代表着各个网卡之间的路由规则。

firewall是使用iptable实现的。而iptable不仅仅能实现防火墙的功能，还能实现如端口转发，映射等功能。

三种模式
========

交换机：把更多的设备连接到现有的网络中。把WIFI连接的设备连接到现有网络中。都可以工作在交换机模式下。把NAS接入到现有网络，也可以工作在交换机模式下。

路由器：LAN口连接局域网，WAN口连接外网（通常是猫）。猫即起到网关的作用。

网关：有些路由器自己具备有光纤的功能，或者WAN口外接的光猫。或者有时也指播号上网用的协议。

lede和openwrt的关系。
=====================

lede和openwrt合并后，现在指的是同一个开源项目。

其它的开源项目有：freedombox，DD-wrt，Tomato。和大名鼎鼎的梅林。

梅林
====

openwrt的安装和刷机是一个烧脑的技术活，得明白很多软件硬件知识和路由原理。想轻松些？用梅林。

梅林是openwrt的一个深度定制版，集成了很多插件。主要针对华硕路由器。

当然也可以刷到其它设备上。

常用命令
========

-  tcpdump
-  ipset
-  nslookup
-  netstat -tulp
-  logread
-  ping6

路由器
======

`美国网件（NETGEAR） R7000 <https://union-click.jd.com/jdc?e=&p=AyIGZRtSEAYaBlwaXRAyEgdXGFgUBCJDCkMFSjJLQhBaGR4cDF8QTwcKXg1cAAQJS14MQQVYDwtFSlMTBAtHR0pZChUdRUFGfwAXWxUAEQRUHWtFYm59U0FaUGFUHSVkKW8HYGMvTV5lDh43VCtbFAMSAlYaUhwEIjdVHGtXbElSSc3RkNWAmIy6z82nozdUK1sRBBMBXRJcEgQTAlwrXBULIkQFQwRFQE5ZC0RrJTIRN2UrWyUBIkU7E1NHAUIBUx5bQVIQAgEdXEUGRVUBHw4WAxMFAR1TEQoiBVQaXxw%3D>`__

`华硕（ASUS）RT-AC68U <https://union-click.jd.com/jdc?e=&p=AyIGZRtSEwMXA1AYWxEyEgZXH10XACJDCkMFSjJLQhBaGR4cDF8QTwcKXg1cAAQJS14MQQVYDwtFSlMTBAtHR0pZChUdRUFGfwAXWxQAFgFXGWtvVUkFAn07bmBFWyNsOHBiWW8XSxhTDh43VCtbFAMSAlYaUhwEIjdVHGtGbEJFEVmCk5zEotXP84wyEzdVH10UBBoPVB5THQAXN1IbUiVBQl8KSxlJXExYZStrFjIiN1UrWCVAfAZcT1McBRtVBUtcRwcUD1FIXxBXRQIGTwxCChsEXB1ZJQATBlES>`__

`领势 LINKSYS MR8300-AC2200M <https://union-click.jd.com/jdc?e=&p=AyIGZRtfEAYUBlcbWxEyEgZUGloXCxcAXBhbJUZNXwtEa0xHV0YXEEULWldTCQQHCllHGAdFBwtEQkQBBRxNVlQYBUkeTVxNCRNLGEF6RwtVGloUAxAOUBxSFgIiewFsHxdDUlQ2WyEXWhJePX4tYFhZQVkXaxQyEgZUG14WAxsOUytrFQUiRTtGA0pYUE8XHFwSMhM3VR9dFAsTD1EYXRwLETdSG1IlQUJfCksZSVxMWGUraxYyIjdVK1glQHxVVhJYEwcRVFZLXUEHGwEAE10UBhVTUB9SFQcUVVRMXSUAEwZREg%3D%3D>`__

参考：
======

NAT：网络地址转换。由于IPV4地址个数的有限性，而使用的技术。IPV6则没有这个问题。

Double NAT：光猫做了一次地址转换，路由器又做了一次地址转换。普通上网时不会出现问题，但如果想使内网向外提供服务。或点对点传输则会有问题。IPV6没有这个问题。解决方式有：ISP modem采用桥接的方式；ISPmodem只工作在光猫状态；路由器不使用NAT，而使用route规则；路由器工作在交换机状态。

ISP：网络服务提供商。中国电信，中国移动，中国联通，长城宽带等。

NAS：网络存储。

Access Point（AP）：只使用路由器的WIFI功能和交换机功能，接入到现有网络。

Wifi Reapter：也叫做 wireless range extender。只使用WIFI功能扩大现有WIFI信号范围。

桥接：连接两个不同的网络，使他们在逻辑上成为一个网络。

VLAN

子网

-  https://openwrt.org/docs/guide-quick-start/start
-  https://www.asuswrt-merlin.net/download

.. |install openwrt| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/10/linksys-2202250_640.jpg
