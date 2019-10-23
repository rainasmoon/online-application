from django.db import models
from django.utils import timezone;
import datetime

# Create your models here.

class Product(models.Model):
    product_name = models.CharField(max_length=200)
    p_scores = models.IntegerField(default=0)
    pub_date = models.DateTimeField('date published')
    def __str__(self):
        return self.product_name
    def was_published_recently(self):
        return self.pub_date >= timezone.now() - datetime.timedelta(days=1)



