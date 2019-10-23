import datetime

from django.db import models
from django.utils import timezone;


# Create your models here.
class Product(models.Model):
    product_jd_skuid = models.CharField(max_length=200, default='0')
    product_name = models.CharField(max_length=200, default='0')
    product_price = models.CharField(max_length=200, default=0)
    product_big_pic = models.CharField(max_length=200 , default='0')
    product_promotion_url = models.CharField(max_length=400, default='0')
    p_scores = models.IntegerField(default=0)
    pub_date = models.DateTimeField('date published')
    
    def __str__(self):
        return self.product_name

