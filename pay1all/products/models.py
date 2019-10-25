import datetime

from django.db import models
from django.template.defaultfilters import default
from django.utils import timezone;


# Create your models here.
class Product(models.Model):
    product_jd_skuid = models.IntegerField(default='0')
    product_name = models.CharField(max_length=200, default='no name')
    product_price = models.IntegerField(default=0)
    product_big_pic = models.CharField(max_length=200 , default='no pic')
    product_promotion_url = models.CharField(max_length=400, default='no url')
    p_scores = models.IntegerField(default=0)
    
    # the following a jd cid
    cid = models.IntegerField(default=0)
    cid2 = models.IntegerField(default=0)
    cid3 = models.IntegerField(default=0)
    cidName = models.CharField(max_length=100 , default='no name')
    cid2Name = models.CharField(max_length=100 , default='no name')
    cid3Name = models.CharField(max_length=100 , default='no name')
    
    pub_date = models.DateTimeField('date published')
    
    def __str__(self):
        return self.product_name


class Search(models.Model):
    search_context = models.TextField()
    as_done = models.BooleanField(default=False)
    cid = models.IntegerField(default=0)
    pub_date = models.DateTimeField('date published')
    
    def __str__(self):
        return self.search_context


class Menu(models.Model):
    menu_name = models.CharField(max_length=100, default='no menu')  # trim cidName to 100
    cid = models.IntegerField(default=0)
    m_scores = models.IntegerField(default=0)
    
    def __str__(self):
        return self.menu_name


class Cid(models.Model):
    cid = models.IntegerField(default=0)
    cidName = models.CharField(max_length=200, default='no name')

    def __str__(self):
        return self.cidName
