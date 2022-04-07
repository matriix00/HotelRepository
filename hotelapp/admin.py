from django.contrib import admin
from .models import Guest,Room,Reservation
# Register your models here.
admin.site.register(Guest)
admin.site.register(Room)
admin.site.register(Reservation)

