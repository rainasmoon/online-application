from utils import crawler_jd
from utils import db_utils
from utils import db_utils_online
from utils import export_jd_db


def do_job():
    if (db_utils.get_lock()):
        db_utils.lock()
        print("get locked.")
        search_list = db_utils_online.select_search()
        for asearch in search_list:
            # first colmon is id , second is context
            search_id = asearch[0]
            search_context = asearch[1]
            print(search_id, search_context)        
            crawler_jd.call_jd_search(search_context)
            export_jd_db.make_jd_data()
            db_utils_online.search_done(search_id)
        db_utils.unlock()
        print("unlocked.")

        
for i in range(10):
    do_job()

