from django.shortcuts import render
# Create your views here.
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from .serializer import GuestSerializer, RoomSerializer,ReservationSerializer
from rest_framework.decorators import api_view
from .models import Guest,Room,Reservation
import logging

from django.core.mail import send_mail

emmaill = ""
unit = []

class GuestList(APIView):
    
    def get(self,request,format=None):
        
        guest=Guest.objects.all()
        serializer = GuestSerializer(guest,many=True)
        return Response(serializer.data)
    
    def post(self,request,format=None) :
            

            serializer = GuestSerializer(data=request.data)
            if serializer.is_valid():
                serializer.save()
                emmaill = serializer.data['email']+"asdas"
                print(emmaill)
                send_mail( 'cofirmation message', 'room_id is {},& cost is  ','omar2018.dev@gmail.com',[serializer.data['email']],
                   fail_silently = False,
                   )
                return Response([serializer.data,emmaill], status=status.HTTP_201_CREATED)
                
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
print(emmaill+"xx")

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
        #emmaill = self.query_params["email"]
        reserve=Reservation.objects.all()
        print(emmaill+"hi")

        serializer = ReservationSerializer(reserve,many=True)
        return Response(serializer.data)
    def post(self,request,format=None) :


            serializer = ReservationSerializer(data=request.data)
            if serializer.is_valid():
                serializer.save()
                
                print(emmaill+"hi")
                
                logging.basicConfig(level=logging.INFO)
                logger = logging.getLogger('myapp')
                logger.info(emmaill)
                print(emmaill+"hi")

                return Response(serializer.data, status=status.HTTP_201_CREATED)
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

#Sending mails individualy
