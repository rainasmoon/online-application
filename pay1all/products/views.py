from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from .models import Product
from django.template import loader
from django.http import Http404
from django.shortcuts import get_object_or_404, render
from django.urls import reverse
from django.views import generic
from django.utils import timezone

# Create your views here.

class IndexView(generic.ListView):
    template_name = 'products/index.html'
    context_object_name = 'latest_product_list'

    def get_queryset(self):
        return Product.objects.order_by('-pub_date')[:20]

class DetailView(generic.DetailView):
    model= Product
    template_name = 'products/detail.html'

class ResultsView(generic.ListView):
    template_name = 'products/results.html'
    context_object_name = 'product_list'
    
    def get_queryset(self):
        return Product.objects.order_by('-pub_date')

def vote(request):
    product = get_object_or_404(Product, pk=1)
    try:
        selected_product= get_object_or_404(Product, pk=request.POST['choice'])
    except (KeyError, Product.DoesNotExist) :
        return render(request, 'products/vote.html', {
                'product': product,
                'error_message': "you didn't select a product.",
        })
    else:
        selected_product.p_scores += 1
        selected_product.save()
        return HttpResponseRedirect(reverse('products:results'))
