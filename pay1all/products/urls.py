from django.urls import path
from . import views

app_name = 'products'
urlpatterns = [
        path('', views.IndexView.as_view(), name='index'),
        path('compare/<int:aproduct_id>/<int:bproduct_id>/', views.compare, name='compare'),
        path('vote/<int:aproduct_id>/<int:bproduct_id>/', views.vote, name='vote'),
        path('details/<int:pk>/', views.DetailsView.as_view(), name='details'),
        path('results/', views.ResultsView.as_view(), name='results'),
        
]
