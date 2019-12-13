用树莓派打造NAS及下载机及DNS服务
################################
:date: 2019-03-08 12:10
:author: rainasmoon
:category: 好物
:slug: raspiberry-pi-nas
:status: published

.. raw:: html

   <figure class="wp-block-image">

| |Netgear enhance your home life|

.. raw:: html

   <figcaption>

Netgear enhance your home life

.. raw:: html

   </figcaption>
   </figure>

原来一时好玩买了树莓派。新鲜一段时间后放在角落里吃灰。前段时间，终于把它拿 出来折腾，总算让我的rasspiberrypi派上了用场。总体感觉，还不错。建了网络存储，建了离线下载，安装了个人DNS，安装了去广告，还安装了Kodi，外接一个显示器，淘宝上买到的一个Kodi专用遥控器。几乎满足了日常的各种需求：如下载，网络存储，电视盒子，广告屏蔽。各种软件都有成熟的方案。当然爱学习的你也可以安装个AI来体验一下。

树莓派家庭多媒体系统安装指南
============================

| 
|  
|  

爱折腾也许是程序员的一个通病。树莓派做为一个小型的开源硬件及系统，在各种玩家的使用下，越来越显现他的优势。不管是出于学习的目的，还是家庭应用的目的，还是想通过他来DIY各种新奇的硬件，培养孩子的好奇心？或者做简单的家庭上网控制。

树莓派都以他低廉的价格和完整的计算机系统，以及极低的功耗，可以24小时开机；丰富的硬件周边，丰富的软件项目及开源项目，很好的可定制开发性和可玩性，让树莓派在硬件创意上发挥着承载功能机和实验场的作用。

回归正题：家用树莓派要如何去打造？
----------------------------------

装了NAS，用于网络存储；装了kodi，连客厅的电视看大片；装了aria2，海盗湾上下各种片；装了pi－hole，全家去广告。

总算有些成就感了，后来又升级到了网件网关，家里的电信宽带用起来都是那么的完美。

这里把整个过程整理出来，希望能让你少走弯路。如果你想要现成的镜像请留言。

.. code:: wp-block-preformatted

    树莓派就是用来折腾的。希望你喜欢自己控制的感觉。

-  硬件：树莓派＋移动硬盘＋高速宽带＋SD卡；
-  软件：官方树莓派系统＋openmediavault.org+Nginx+aria2+Aria2Webui；
-  其它好玩的软件：kodi（媒体播放器），pi-hole（去广告），SS（不解释），OpenVPN（不解释）;
-  其它强烈推荐的硬件：netgear路由器，U盘；
-  其它好玩的开源框架：openWRT，Tail系统；
-  加分项：VPS；
-  其它好玩的但是放弃了的软件：unbound, dnscrypt-proxy

树莓派系统安装
--------------

树莓派是优秀的小型linux系统硬件。小巧，定制性强，可编程，耗电低。

树莓派系统下载： https://www.raspberrypi.org/ , 下载官方的版本即可。用dd写到SD卡里。写入命令：

.. code:: wp-block-code

    dd if=./2019-09-26-raspbian-buster-lite.img of=/dev/sdb bs=2048 && sync

.. code:: wp-block-preformatted

    记住，dd写完成功后，直接启动树莓派，千万不要加载SD卡。否则启动会失败。

广告过滤pi-hole安装
-------------------

pi－hole是通过DNS来过滤广告的，所以，此步骤即是给树莓派安装本地域名服务器: `pi－hole官网地址 <https://pi-hole.net/>`__ 但似乎过滤不了爱奇异的广告，是不是爱奇异的技术更胜? 笑。pi－hole为一键安装，（PS：据说爱奇异的广告可以用油猴＋角本的方式，我只想说，你们真会玩，且行且珍惜吧。)

.. code:: wp-block-code

    curl -sSL https://install.pi-hole.net | bash 

.. code:: wp-block-preformatted

    安装过程的最后要记住号和密码，用于登录管理后台，虽然你也可以不安装管理后台。
    最后记得要修改路由器的DNS分配为手动，并把地址改为树莓派的地址。

aria2 下载神器的安装
--------------------

aria2是linux下优秀的下载命令工具。webUI是它的界面管理工具。配合nginx使用。

接下来的命令包括安装和配置以下软件：aria2: + Aria2 WebUI + nginx

.. code:: wp-block-code

    apt install aria2 nginx
    apt purge lighttpd #这个是pi－hole安装的，我们用nginx代替
    cd ~/
    git clone https://github.com/ziahamza/webui-aria2.git
    cp -r ./webui-aria2/docs /var/www/html/ 

修改nginx配置：

.. code:: wp-block-code

    location /jsonrpc {
        proxy_pass http://localhost:6800/jsonrpc;
        proxy_redirect off;
        proxy_set_header        X-Real-IP       $remote_addr;
        proxy_set_header        X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header Host $host;
        #以下代码使支持WebSocket
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
    }

下载服务的地址为：

.. code:: wp-block-code

    http://pi-address/docs/ 

安装开源NAS ： openmediavault
-----------------------------

OMV是开源的NAS（网络存储）系统。

OMV官网: `openmediavault <http://www.openmediavault.org/>`__ 因为官网只提供了镜像安装教程。网上的手动安装教程大部分都是旧版的，所以请参考以下安装步骤。

.. code:: wp-block-code

    echo "deb http://packages.openmediavault.org/public arrakis main" | sudo tee -a /etc/apt/sources.list.d/openmediavault.list
    apt-get install openmediavault-keyring
    apt-get install php-apc openmediavault
    sudo omv-initsystem

.. code:: wp-block-preformatted

    最新的版本是arrakis，而不是erasmus。

使用OMV注意事项
---------------

-  神奇的权限系统，因为linux的严格权限制度和用户制度，请用openmediavault从头开始管理整个移动硬盘吧，从分区开始，使用ext4格式，这样会少很多麻烦。
-  记住移动硬盘变成网络存储后就不要再把它挂载到其它系统上了。还是因为权限和用户的问题，我在这里吃了不少亏。除非你是程序员，并且你知道自己在干什么。
-  在关联任何文件夹到具体服务之前，请先规划并创建所有的文件夹吧，否则你要想添加新的文件夹要每次都把所有的关联都取消之后才能再次添加了。很是麻烦。建议的共享文件夹包括：documents, movies, downloads, tools, pictures, musics, temps，差不多够了吧?
-  最后再强调下：请用openmediavault管理整个硬盘，千万别用windows或linux做改动，你会觉得很幸福的

安装多媒体kodi系统
------------------

kodi可以把树莓派改造成电视盒子。

问题的关键在于，你要知道如何找到正确的插件，安装很简单：

.. code:: wp-block-code

    apt install kodi

因为树莓派是共享1G内存，为了看高清，修改下树莓派的启动配置：

.. code:: wp-block-code

    vim /boot/config.txt
    gpu_mem=256

.. code:: wp-block-preformatted

    可以到淘宝上买个神奇的摇控器： kodi 媒体中心遥控器 

然后告诉你一个神奇的网站： `thepiratebay <http://%20https://thepiratebay.org%20>`__

然后用前面的aria2下载电影吧，你会发现，只有你想不到的，没有你找不到的，然后每天的问题都变成了，我要看哪部？

购买网件路由器，及刷 openWRT
----------------------------

openWRT是开源的可定制有插件的路由固件系统。

Netgear: 网件路由器，虽然很贵，但你值得拥有。看着国内的路由器，从来没有把硬件的配置列出来，内存只有2M，8M。那简直是深度的精减了用料，愿不得那么便宜。看看人家网件，动不动就128M，业界良心。现在觉得，再也不用过一段时间就去重启器由器是多么的幸福。值了。 刷 `openWRT <https://openwrt.org/>`__

福利：
------

VPS是网上云虚拟机。相当于工作在国外的一台电脑。

`Tail <https://tails.boum.org/>`__\ 是专注于个人隐私的U盘系统。

unbound是个人不错的DNS解析系统。

DNScrypt说实话我感觉不好用，速度太慢了。除非自己在VPS上搭建服务端。

刷了openWRT之后，就可以安装SS，安装openVPN，在VPS上安装好服务端。再用dd安装U盘版Tail。然后目标达成。

你可以为所欲为了。

至于unbound和dnscrypt-proxy，只是觉得好玩，但目前看还不实用。

.. code:: wp-block-preformatted

    Welcome to the real WORLD!

使用定时任务：
--------------

其实很多有意思的服务，只要用定时任务就能达到很不错的效果。比如：每天的报时和天气预报。

曾经看到有一网友用定时任务限制自家女儿的上网上瘾问题。真是太聪明了。他做的也只是用定时任务cronjob把http://youku.com解析到127.0.0.1，只有规定的时间可以看优酷。

怎么样？简单吧？和孩子的斗智 斗勇：

升级版的电视儿童锁，Youku被定时屏蔽，可是她摸索了后，转而去看本地下载过的动画片，于是我把电视接在小米智能插座上，定时给电视断电，结果被她发现断电后，再去重启插座就可以了（按那个白色按钮，她的原话）。所以再追加了一个脚本，定时把下载过的动画片的目录的execute权限去掉，这样小米盒子就无法读取了。

以上产品的链接
--------------

树莓派：

.. raw:: html

   <figure class="wp-block-image">

| |树莓派|

.. raw:: html

   <figcaption>

树莓派

.. raw:: html

   </figcaption>
   </figure>

对于树莓派可以买外売，也可以不买。

除非非常在意占用的空间，一般不建议买pi zero。

3B型：

-  1G内存
-  USB2.0
-  WIFI2.4G
-  HDMI\*1个：1080P
-  百兆网卡

3B+型：

-  1G内存
-  USB2.0
-  WIFI2.4G/5G
-  HDMI\*1个：1080P
-  千兆网卡

`树莓派3 <https://union-click.jd.com/jdc?e=&p=AyIGZRtaEwcQBVAbXhMyEgZXHlwXCxQFVB1rUV1KWQorAlBHU0VeBUVNR0ZbSkAOClBMW0sbWhcHFQVcHVkUBA1eEEcGJUtXT1FDKWB4cnUreAlMZEh7DWAjaXIeC2UbXRYLEg5WHlgUMhIGVBteFgMbDlMraxUDIkY7G10WAhsBZRprFQYWAVATUxwEEABWE2sVChY3FksDSlJQWwtFBCUyIgRlK2sVMhI3Cl8GSDIQBlQZWQ%3D%3D&t=W1dCFFlQCxxKQgFHRE5XDVULR0UVAxACUhlSEwATAUpCHklf>`__

4B型：

-  提供了1G，2G，4G内存三种类型可选。
-  USB3.0接口。
-  WIFI2.4G/5G。
-  miniHDMI接口2个。4K。
-  使用type-c接口供电。
-  千兆网卡。

`树莓派4B <https://union-click.jd.com/jdc?e=&p=AyIGZRtSFQcbBFUSWBAyFgdXHVoXBxMBVBJrUV1KWQorAlBHU0VeBUVNR0ZbSkdETlcNVQtHRVNSUVNLXANBRA1XB14DS10cQQVYD21XHgNVGV0UABcGUxpSJQAXcSpQU1Z7cmczeiJGfmR5EVANVXIeC2UaaxUDEwdQGFocCxQ3ZRtcJUN8B1QbWBAKEw5lGmsVBhUAUxpYFAcSAVQcaxICGzcWSwNKUlBbC0UEJTIiBGUraxUyETcXdQ4XBEdQXR1YRgdFBFAYWxQKQlIATFMRVRNTUkteRQcWN1caWhEL>`__

网件：

.. raw:: html

   <figure class="wp-block-image">

| |NetGear|

.. raw:: html

   <figcaption>

NetGear

.. raw:: html

   </figcaption>
   </figure>

每个家庭都应该拥有一部，你会懂的。

`NETGEAR 路由器 R7800 <https://union-click.jd.com/jdc?e=&p=AyIGZRprEwAXA1YTWyVGTV8LRGtMR1dGFxBFC1pXUwkEAEAdQFkJBV0XBxYEXRtETEdOWmVSWwtGRA4UUzhyfGADNV8uc0BMWBN7VxkyEgFWElscARcEVCtbFAMSAlYaUhwEIjdVGmtDbBIGVBpaFAMbBFMrWiUCFgNTHlMdCxQOUhJYJQIaA2VYC01dQkUJRQVKMiI3VitrJQIiB2VEH0hfIgVUGlkX&t=W1dCFFlQCxxKQgFHRE5XDVULR0UTABcDVhNbCltXWwg%3D>`__

京东上的网件官方再售版：

.. raw:: html

   <figure class="wp-block-image">

| |NetGear|

.. raw:: html

   <figcaption>

NetGear

.. raw:: html

   </figcaption>
   </figure>

二手的网件，入门首选。

`199块网件的官方二手 <https://union-click.jd.com/jdc?e=&p=AyIGZRprEQUUAV0TXyVGTV8LRGtMR1dGFxBFC1pXUwkEAEAdQFkJBV8SBBQPXR9ETEdOWmV%2BB2JDZXoKTz5OVmx8Nh4MVnoRZg97VxkyEgFWElscARcEVCtbFAMSAlYaUhwEIjdVGmtebBM3VCtbEQYUAl0TUhwAEAVUK1sdBiJEBUMERUBOWQtEayUyETdlK1slAiJYEUYGJQATBlcZ&t=W1dCFFlQCxxKQgFHRE5XDVULR0URBRQBXRNfCltXWwg%3D>`__

SD卡：

.. raw:: html

   <figure class="wp-block-image">

| |SanDisk sd|

.. raw:: html

   <figcaption>

SanDisk sd

.. raw:: html

   </figcaption>
   </figure>

树莓派的性能好坏，靠它了。

`CLASS10 SD卡 <https://union-click.jd.com/jdc?e=&p=AyIGZRJdEgIXBVYbXiUCFwBTE1kdBhQPUisfSlpMWGVCHlBDUAxLBQNQVk4YDk5ER1xOGVUeXBMKEA9RHVMSHUtCCUZrUnRpAhUYCG1hb1MVbg5xeBVmPEE5Uw4eN1UdWBwCGwRQGFolAhMGVR5YFAsbAWUrWxQyU2lSGV8RBBs3VCtbEQYUAl0TUh0DEgdXK1sdBiJEBUMERUBOWQtEayUyETdlK1slAiJYEUYGJQATBlcZ&t=W1dCFFlQCxxKQgFHRE5XDVULR0UVBxUBXRlTEQQaAEpCHklf>`__

U盘：

.. raw:: html

   <figure class="wp-block-image">

| |Samsung USB|

.. raw:: html

   <figcaption>

Samsung USB

.. raw:: html

   </figcaption>
   </figure>

有Ｕ盘方便。

`三星3.1U盘 <https://union-click.jd.com/jdc?e=&p=AyIGZRNYEQUSAlcYXyUEEA5SH1kVMlZYDUUEJVtXQhRZUAscSkIBR0ROVw1VC0dFEwAbAFEZWwpbV1sIKwtrZE99VUc%2BdXFkAyYBGxZ1ZnUSBQ0ZDiIHUxhSFQsRAlYaaxUDEwdQGFocCxQ3ZRtaJVR8B1QaWhQCEQJcGGsUMhIDUR1eHQobD1waXBYyEg9RKxhFWk1XF0cFS10iN2UYayUyEjdVKwRRX083VxpaFwA%3D&t=W1dCFFlQCxxKQgFHRE5XDVULR0UTABsAURlbCltXWwg%3D>`__

硬盘：

.. raw:: html

   <figure class="wp-block-image">

| |WD driver|

.. raw:: html

   <figcaption>

WD driver

.. raw:: html

   </figcaption>
   </figure>

大硬盘，下片必备。家庭云存储哪里少得了它。

`西部数据2.0T <https://union-click.jd.com/jdc?e=&p=AyIGZRNeEQUSBVAcWSUFFAFWHl4TMlZYDUUEJVtXQhRZUAscSkIBR0ROVw1VC0dFEgQUBFAeXQpbV1sIKwNVWmRGNx1Td3ERBCZmEmEAUkYXHisZDiIHUxhSFQsRAlYaaxUDEwdQGFocCxQ3ZRtaJVR8B1QaWhQDEwJdH2sUMhIDUR1eHQoaBlQdWh0yEg9RKxhFWk1XF0cFS10iN2UYayUyEjdVKwRRX083VxpaFwA%3D&t=W1dCFFlQCxxKQgFHRE5XDVULR0USBBQEUB5dCltXWwg%3D>`__

一些学习的书籍：
----------------

-  `Python树莓派编程 <https://union-click.jd.com/jdc?e=&p=AyIGZRtYFAcXBFIZWR0yEgRUHFgUBxE3EUQDS10iXhBeGlcJDBkNXg9JHU4YDk5ER1xOGRNLGEEcVV8BXURFUFdfC0RVU1JRUy1OVxUBEwBWGl4WMmJjU18EYmlgZBxlBWNWCFwxEhB3f3ILWStaJQITBlUeWBQLGwFlK1sSMkBpja3tzaejG4Gx1MCKhTdUK1sRBRUBVBtfFAoaAVMrXBULIkQFQwRFQE5ZC0RrJTIRN2UrWyUBIkU7TlkTV0UPUxgIEFURAlYbWh1SR1ICE19CA0YABR4LEAYiBVQaXxw%3D>`__
-  `树莓派开始，玩转Linux <https://union-click.jd.com/jdc?e=&p=AyIGZRtYFAcXBFIZWR0yEgRXElkQBxY3EUQDS10iXhBeGlcJDBkNXg9JHU4YDk5ER1xOGRNLGEEcVV8BXURFUFdfC0RVU1JRUy1OVxUBEA5XHl4RMlJ%2FJ0kjE1RSZxx5U3NJZFpTGhJudnILWStaJQITBlUeWBQLGwFlK1sSMkBpja3tzaejG4Gx1MCKhTdUK1sRBRUBVBtfEAsXA1UrXBULIkQFQwRFQE5ZC0RrJTIRN2UrWyUBIkU7TlkTV0UPUxgIEFURAlYbWh1SR1ICE19CA0YABR4LEAYiBVQaXxw%3D>`__
-  `树莓派渗透测试实战 <https://union-click.jd.com/jdc?e=&p=AyIGZRtYFAcXBFIZWR0yEgRVHV0QBRE3EUQDS10iXhBeGlcJDBkNXg9JHU4YDk5ER1xOGRNLGEEcVV8BXURFUFdfC0RVU1JRUy1OVxUBEgFTHlwWMmt5UFwMYVFGZTBPGnRnUF82QAgLSVQLWStaJQITBlUeWBQLGwFlK1sSMkBpja3tzaejG4Gx1MCKhTdUK1sRBRUBVBtfHQcQAlArXBULIkQFQwRFQE5ZC0RrJTIRN2UrWyUBIkU7TlkTV0UPUxgIEFURAlYbWh1SR1ICE19CA0YABR4LEAYiBVQaXxw%3D>`__
-  `树莓派可以做哪些项目？ <http://shumeipai.nxez.com/what-raspi-used-for>`__

FAQ:
----

-  问：安装了OMV（openmediavault）后再安装Nginx失败？答：要先卸载httpd。
-  问：kodi播放视频卡或直接死掉跳出？答：要调整共享内存的大小。
-  问：树莓派老是显示电压低？答：请用有独立供电的移动硬盘；或者选用2A以上输出的USB电源。

推荐阅读：
----------

`阿里云可以用来做什么？ <https://www.rainasmoon.com/business/aliyun-make-small-business-smart/>`__

.. |Netgear enhance your home life| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/smart-3720021_960_720-1.jpg
   :target: https://amazon.cn/gp/product/B077WC4WBF/ref=as_li_tl?ie=UTF8&camp=536&creative=3200&creativeASIN=B077WC4WBF&linkCode=as2&tag=rainasmoon042-23&linkId=338fccfbd6f0f72e9f078be7af74abb2
.. |树莓派| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/rpi-rpi.jpg
.. |NetGear| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/rpi-netgear.jpg
.. |NetGear| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/rpi-netgear-2ndhand.jpg
.. |SanDisk sd| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/rpi-sd.jpg
.. |Samsung USB| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/rpi-samsung-usb.jpg
.. |WD driver| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2019/03/rpi-hard-driver.jpg
