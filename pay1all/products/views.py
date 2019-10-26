import random

from django.http import Http404
from django.http import HttpResponse, HttpResponseRedirect
from django.shortcuts import get_object_or_404, render
from django.shortcuts import render
from django.template import loader
from django.urls import reverse
from django.utils import timezone
from django.views import generic

from utils import elo

from .models import Product, Search, Menu

# Create your views here.

CLICK_WEIGHT = 1
MENU_MAX = 5
FIRST_PAGE_MAX = 20
LONG_LIST_MAX = 2000


def index(request, cid=0):
    if cid == 0 :
        latest_product_list = Product.objects.order_by('-p_scores')[:FIRST_PAGE_MAX]
    else:
        latest_product_list = Product.objects.filter(cid3=cid).order_by('-p_scores')[:FIRST_PAGE_MAX]
        amenu = Menu.objects.get(cid=cid)
        amenu.m_score += CLICK_WEIGHT
        amenu.save()
    menu_list = Menu.objects.order_by('-m_scores')[:MENU_MAX]
    context = {'latest_product_list': latest_product_list, 'menu_list':menu_list, 'cid': cid}
    return render(request, 'products/index.html', context)


def menus(request):
    menu_list = Menu.objects.order_by('-m_scores')[:LONG_LIST_MAX]
    context = {'menu_list':menu_list}
    return render(request, 'products/menus.html', context)


def compare(request, aproduct_id, bproduct_id, cid=0):
    if aproduct_id == 0 :
        random_product_list = Product.objects.all()
        size = len(random_product_list)
        id0 = random.randint(1, size)
        id1 = random.randint(1, size)
        aproduct = random_product_list[id0]
        bproduct = random_product_list[id1]
    elif aproduct_id != 0 and bproduct_id == 0:
        random_product_list = Product.objects.all()
        size = len(random_product_list)
        id0 = random.randint(1, size)
        aproduct = Product.objects.get(pk=aproduct_id)
        bproduct = random_product_list[id0]    
    else:
        aproduct = Product.objects.get(pk=aproduct_id)
        bproduct = Product.objects.get(pk=bproduct_id)
   
    context = {'aproduct': aproduct, 'bproduct': bproduct, 'cid': cid}
    return render(request, 'products/compare.html', context)


class DetailsView(generic.DetailView):
    model = Product
    template_name = 'products/details.html'


class ResultsView(generic.ListView):
    template_name = 'products/results.html'
    context_object_name = 'product_list'
    
    def get_queryset(self):
        return Product.objects.order_by('-pub_date')[:LONG_LIST_MAX]


def vote(request, aproduct_id, bproduct_id):
    aproduct = Product.objects.get(pk=aproduct_id)
    bproduct = Product.objects.get(pk=bproduct_id)
    try:
        choice_id = request.POST['choice']
        
        e = elo.Elorating(ascores=aproduct.p_scores, bscores=bproduct.p_scores)
        if (choice_id == aproduct_id):            
            e.win()
        else:
            e.lose()
        aproduct.p_scores = e.ascores
        bproduct.p_scores = e.bscores
        aproduct.save()
        bproduct.save()
            
    except (KeyError, Product.DoesNotExist) :
        return render(request, 'products/compare.html', {
                'aproduct': aproduct,
                'bproduct': bproduct,
                'error_message': "you didn't select a product.",
        })
    else:        
        return HttpResponseRedirect(reverse('products:details', args=(choice_id,)))


def search(request):
    search_input = request.POST['search_input']
    if search_input == '':
        context = {'message': '输入为空。。。'}
        return render(request, 'products/search.html', context)
    asearch = Search.objects.create(search_context=search_input, pub_date=timezone.now())
    asearch.save()
    context = {'message': '查询结果生成中。。。'}
    return render(request, 'products/search.html', context)
