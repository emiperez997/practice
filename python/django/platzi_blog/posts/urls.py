from django.urls import path
from . import views

app_name = 'posts'

urlpatterns = [
    path('', views.IndexView.as_view(), name='index'),
    path('user/', views.UserView.as_view(), name='user'),
    # path('<int:pk>/', views.DetailView.as_view(), name='detail'),
]
