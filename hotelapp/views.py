from django.shortcuts import render
# Create your views here.
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from .serializer import GuestSerializer, RoomSerializer,ReservationSerializer
from rest_framework.decorators import api_view
from .models import Guest,Room,Reservation

from django.core.mail import send_mail

class GuestList(APIView):
    
    def get(self,request,format=None):
        
        guest=Guest.objects.all()
        serializer = GuestSerializer(guest,many=True)
        return Response(serializer.data)
    def post(self,request,format=None) :
            

            serializer = GuestSerializer(data=request.data)
            if serializer.is_valid():
                serializer.save()
                send_mail( 'cofirmation message', 'Kindly Ignore','omar2018.dev@gmail.com',[serializer.data['email']],
                   fail_silently = False,
                   )
                return Response(serializer.data, status=status.HTTP_201_CREATED)
                
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class RoomList(APIView):
    def get(self,request,format=None):
        
        room=Room.objects.all()
        serializer = RoomSerializer(room,many=True)
        return Response(serializer.data)
    def post(self,request,format=None) :
            

            serializer = RoomSerializer(data=request.data)
            if serializer.is_valid():
                serializer.save()
                return Response(serializer.data, status=status.HTTP_201_CREATED)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

class ReservationList(APIView):
    def get(self,request,format=None):
        
        reserve=Reservation.objects.all()
        serializer = ReservationSerializer(reserve,many=True)
        return Response(serializer.data)
    def post(self,request,format=None) :
            

            serializer = ReservationSerializer(data=request.data)
            if serializer.is_valid():
                serializer.save()
                return Response(serializer.data, status=status.HTTP_201_CREATED)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

#Sending mails individualy
