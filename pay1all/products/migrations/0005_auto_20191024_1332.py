# Generated by Django 2.2.6 on 2019-10-24 05:32

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('products', '0004_auto_20191023_1542'),
    ]

    operations = [
        migrations.AlterField(
            model_name='product',
            name='product_jd_skuid',
            field=models.IntegerField(default='0'),
        ),
        migrations.AlterField(
            model_name='product',
            name='product_price',
            field=models.IntegerField(default=0),
        ),
    ]
