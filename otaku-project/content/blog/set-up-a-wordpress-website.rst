Set up a wordpress website from zero
####################################
:date: 2017-09-26 13:24
:author: rainasmoon
:category: 国外
:slug: set-up-a-wordpress-website
:status: published

.. raw:: html

   <figure class="wp-block-image">

| |image0|

.. raw:: html

   <figcaption>

Build a website

.. raw:: html

   </figcaption>
   </figure>

Do you want to create your own wordpress? This is the guideline and it will cover every prospect you need. Start your on-line life is not that difficult. I hope you find it helpful.

Guidelines to setup a Wordpress step by step.
=============================================

| 
|  
|  

**1 Apply for AWS.**
--------------------

| First you need to choose VPS to store your blogs. AWS is a good choice. Because it gives you 1 free year usage. Please choose the ec2 tier. And you need to prepare a creditcard and a cellphone. Choose the aws linux image is referred.
| And you can choose Bluehost too.

-  `AWS <https://aws.amazon.com/>`__
-  `Bluehost <https://www.bluehost.com/track/pay1all/%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20>`__

Following the guidelines AWS gives. until you can login via ssh. Then apply the following command:

.. code:: wp-block-code

    apt update && apt upgrade

.. code:: wp-block-preformatted

    Please update your system regularly, it will keep a lot of dangerous things out of your system.

**2 Install Nginx.**
--------------------

This is a great software and can do a lot of magic things and it will give you a great ability to do things flexibly.

.. code:: wp-block-code

    apt install nginx

.. code:: wp-block-preformatted

    You can choose Apache service instead, But I really suggest you to use Nginx.

**3 Install Mysql.**
` <https://corpocrat.com/2016/01/05/howto-setup-nginx-php-mysql-wordpress-in-amazon-ec2/>`__
--------------------------------------------------------------------------------------------

The database, the wordpress will need it.

.. code:: wp-block-code

    apt install mysql

**4 Install wordpress.﻿**
-------------------------

Pls refer to the following url:

`setup a wordpress env <https://corpocrat.com/2016/01/05/howto-setup-nginx-php-mysql-wordpress-in-amazon-ec2/>`__

**5 Install wordpress plugins.**
--------------------------------

The following plugins will make your life happy and simple when you become a blogger.

+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| **Plugins**                 | **Description**                                                                                                                                                               |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Yoast SEO                   | The SEO plugin which is very useful.                                                                                                                                          |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Disbale Emojis              | I hate the new Emoji feature of wordpress, Because it causes the browser creates a lot of traffic.                                                                            |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Disable Google Fonts        | You can't download it if you locate in China.                                                                                                                                 |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| EWWW Image Optimizer        | This can compress images.                                                                                                                                                     |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| JS & CSS Script Optimizer   | This is a amazing plugin can compress all your css & js files separately, and it can speed up your website.                                                                   |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Redirection                 | This is a plugin that can help you collect all 404 pages accessed by others and you can decide if you want to redirect them. But i only use the 404 pages collect function.   |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Smartideo                   | You can put ``QQ, bilibili, Youku``, video in your blog and this will enrich your contents.                                                                                   |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| UpdraftPlus                 | Can backup your wordpress. if you have dropbox, you can store it there.                                                                                                       |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Wordfence Security          | A Must-have one.                                                                                                                                                              |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| WP Original Media Path      | You can change your img & css & js in a different domain, so that you can use your CDN(such as baidu's) wisely.                                                               |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| WP Statistics               | Give you a view of your webstie: you can focus on the visitors(UV?), hits(PV?), search engine referrals(we will get traffic there some day).                                  |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| WP Super Cache              | It can give you a static html website. but it needs you to do specific configuration to tell nginx to do it. pls refer to another blog:                                       |
|                             | `wp supercache with nginx <https://myatus.com/p/faster-wp-super-cache-with-nginx/>`__                                                                                         |
+-----------------------------+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+

**7 Daily running.﻿**
---------------------

Watch your daily visitors of your website and continue creating great original blogs. Try to introduce your own experiences of doing something and share them with others, that will save others' time someday.

.. code:: wp-block-preformatted

    Please just do the search & copy paste things.  I hate it so much, you know what I mean when you want to find something useful from search engining but you have  already looked up them to more than 10 pages.

**8 Jorgee which is a malware.﻿**
---------------------------------

You may get a huge amount of traffic. And if you check the traffic header and a lot of them from a user agent called "Jorgee". All of them try to access a illegal url. You can ban them through your Wordfence Security plugin.

**9 SEO things.﻿**
------------------

Add your website to searching engines. Polish your blog. Use social networks and blogs to let people know you website. Pls refer to my another blog, and a lot of other things mentioned here: `Seo things <http://www.rainasmoon.com/business/free-resource-for-small-business-in-china/>`__

.. code:: wp-block-preformatted

    Build outside reference is a great way to link your blog and create values to the Internet.

**10 The most important security check.﻿**
------------------------------------------

Use AWS security group restrict. Especially the Inbound Rules. Only open 80 to all the Internet. And 22 to your own IP. That will help you a lot to defect the dangerous Internet.

Create Some AWS Alarm. So that you can get some email when the traffic is not normal.

.. code:: wp-block-preformatted

    Don't use simple password for your admin page. And DO Change all software default user's password. Include: Mysql, Tomcat.

If you get a extremely high hits(PV) than visitors(UV), there may be some illegal IP try to break your website. Check the log & Add some 404 page to your banned rules through your firewall.

.. code:: wp-block-preformatted

    Visit the safe website regularly: FreeBuf.com

**11 The other things you can do before you begin.**
----------------------------------------------------

-  Buy a domain: `from aliyun <https://mi.aliyun.com/>`__
-  Use `su.baidu.com <https://su.baidu.com/>`__ to resolve your domain to your AWS ip.
-  Register your web information in Chinese Authority. `beian aliyun <https://beian.aliyun.com/>`__

**12 What kind of env On the Internet?**
----------------------------------------

| The are a huge a mount of malware located all around the world. Spam posters try to post advertisement on your blog. There are crawlers there too, they are good.
| And `ce.baidu.com <http://ce.baidu.com/>`__ will routinely check your website's health if you register your website on it.

.. code:: wp-block-preformatted

    Internet is full of malware and hackers and bots which will try to get into your on-line's home. you need to be very careful and you must do the right thing.

**﻿13 Enable SSL?**
-------------------

The wordpress said at end of this year(2017) the new version will force the users to use https. And the Chrome & Firefox are prefer SSL website. The google will give SSL website a higher score too. But the question is: SSL certification will cost a amount of money. Anyway, you can start from the following 3 ways:

-  `startssl <https://www.startcomca.com/>`__
-  `let's encrypt <https://letsencrypt.org/>`__
-  `aws certificate manager <https://aws.amazon.com/cn/certificate-manager/>`__

.. code:: wp-block-preformatted

    I prefer let's encrypt. Because it's totally free. you only need to renew it every 3 month.

Ok, that's all. Hope you have a lot fun when create a wordpress website.

Related articles:

-  `The free resource you and use in china <https://www.rainasmoon.com/business/free-resource-for-small-business-in-china>`__

|image1|

.. |image0| image:: https://img.rainasmoon.com/wordpress/wp-content/uploads/2017/09/build-3965373_640.jpg
.. |image1| image:: //ir-na.amazon-adsystem.com/e/ir?t=rainasmoon0b-20&l=am2&o=1&a=B07HK4JNV1
