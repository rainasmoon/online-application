from utils import crawler_jd
from utils import export_jd_db

crawler_jd.call_jd_search('电视机')
export_jd_db.make_jd_data()
