from dataclasses import field
from rest_framework import serializers
from .models import Guest,Room,Reservation
class ReservationSerializer(serializers.ModelSerializer):


     class Meta:
        model=Reservation
        fields='__all__'
        
     #guests = GuestSerializer(many=True)
     #rooms = RoomSerializer(many=True)
     
class RoomSerializer(serializers.ModelSerializer):
    
    class Meta:
        model=Room
        fields= '__all__'

class GuestSerializer(serializers.ModelSerializer):
    #guest_reserve_period= serializers.SlugRelatedField(slug_field='period',many=True,read_only=True)
    #room_reserved = serializers.SlugRelatedField(slug_field='room_id_id',many=True,read_only=True)
    #guest_reserve_period= serializers.StringRelatedField (many=True,read_only=True)
    #guest_reserve_period= serializers.SlugRelatedField(slug_field='period',many=True,read_only=True)
    #guest_reserve_period= serializers.HyperlinkedRelatedField(view_name='period',many=True,read_only=True)
    guest_reserve_period = ReservationSerializer(read_only=True, many=True)

    class Meta:
        model=Guest
        fields= ['id','name','passid','email','nationality','mobile','guest_reserve_period',]
        def create(self, validated_data):
            guests_data = validated_data.pop('guest_reserve_period')
            guest = Guest.objects.create(**validated_data)
            for guest_data in guests_data:
                Reservation.objects.create(guest=guest, **guest_data)
            return guest
        #fields='__all__'
    ##rooms = ReservationSerializer(many=True)





    
    