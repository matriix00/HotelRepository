# Generated by Django 4.0.3 on 2022-03-28 12:11

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('hotelapp', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='guest',
            name='passid',
            field=models.IntegerField(max_length=14, unique=True),
        ),
    ]
