from utils import crawler_jd
from utils import db_utils_online
from utils import export_jd_db

search_list = db_utils_online.select_search()
for asearch in search_list:
    search_id = asearch[0]
    search_context = asearch[1]
    print(search_id, search_context)        
    crawler_jd.call_jd_search(search_context)
    export_jd_db.make_jd_data()
    db_utils_online.search_done(search_id)
