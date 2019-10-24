from django.http import Http404
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import get_object_or_404, render
from django.shortcuts import render
from django.template import loader
from django.urls import reverse
from django.utils import timezone
from django.views import generic

from .models import Product


# Create your views here.
class IndexView(generic.ListView):
    template_name = 'products/index.html'
    context_object_name = 'latest_product_list'

    def get_queryset(self):
        return Product.objects.order_by('-p_scores')[:20]


def compare(request, aproduct_id, bproduct_id):
    aproduct = Product.objects.get(pk=1)
    bproduct = Product.objects.get(pk=2)
    context = {'aproduct': aproduct, 'bproduct': bproduct}
    return render(request, 'products/compare.html', context)


class ResultsView(generic.ListView):
    template_name = 'products/results.html'
    context_object_name = 'product_list'
    
    def get_queryset(self):
        return Product.objects.order_by('-pub_date')


def vote(request, aproduct_id, bproduct_id):
    aproduct = Product.objects.get(pk=1)
    bproduct = Product.objects.get(pk=2)
    try:
        request.POST['choice']
        bproduct.p_scores += 10
        aproduct.p_scores -= 10        
    except (KeyError, Product.DoesNotExist) :
        return render(request, 'products/compare.html', {
                'aproduct': aproduct,
                'bproduct': bproduct,
                'error_message': "you didn't select a product.",
        })
    else:
        aproduct.save()
        bproduct.save()
        return HttpResponseRedirect(reverse('products:results'))
