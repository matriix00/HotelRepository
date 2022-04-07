import re
from django.core import serializers
from django.http import HttpResponse
from django.db import models
from django.http import JsonResponse
import  json

# Create your models here.
class Guest(models.Model):
    passid=models.IntegerField(unique=True)
    name=models.CharField(max_length=120)
    email=models.EmailField(max_length=120)
    nationality=models.CharField(max_length=30)
    mobile=models.IntegerField()

    def __str__(self) -> str:
        return self.name
    
class Room(models.Model):
    type=models.CharField(max_length=20)
    room_id=models.IntegerField()
    cost=models.IntegerField()
    reserved=models.BooleanField(default=False)
    def __str__(self) -> str:
        return self.type



class Reservation(models.Model):
    guest_id=models.ForeignKey(Guest,related_name='guest_reserve_period',blank=True,on_delete=models.CASCADE)
    room_id=models.ForeignKey(Room,related_name='room_reserved',on_delete=models.CASCADE)
    period=models.IntegerField()
    def __str__(self) -> str:
        return '%r'%(self.period)
    class Meta:
        unique_together = ['guest_id', 'room_id_id','period']
        ordering = ['room_id',]
        

    

   # def __str__(self):
    #    response = {"guest_id":self.guest_id.name, "room_id":self.room_id_id, "period":self.period}
        
        
        #return json.dumps(response,)
         #return str({
          #  'guest_id': self.guest_id,
           # 'room': self.room_id_id,
            #'period': self.period
        #})
        #return ' %d %d ' % ( self.room_id_id,self.period)
        #serialized_obj = serializers.serialize('json',[self.fields])
        #return serialized_obj
