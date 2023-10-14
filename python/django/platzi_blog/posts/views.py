from django.shortcuts import render, get_object_or_404, redirect
from django.http import HttpResponse, HttpResponseRedirect
from .models import User, Post, Comment
from django.views import generic

# Create your views here.


class IndexView(generic.ListView):
    template_name = 'posts/index.html'
    context_object_name = 'latest_post_list'

    def get_queryset(self):
        """Return the last five published posts."""
        return Post.objects.order_by('-pub_date')[:5]


class UserView(generic.ListView):
    template_name = 'posts/user.html'
    context_object_name = 'user_list'

    def get_queryset(self):
        return User.objects.all()
