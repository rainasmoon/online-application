#rm ./report/*
cp -f /var/log/nginx/access.* ./report
cd report
gzip -df ./*.gz
goaccess -f access.log-`date -d"1 day ago" +"%Y%m%d"` -d -p ~/.goaccessrc -a > report-`date -d"1 day ago" +"%Y%m%d"`.html
echo "pay1all daily access log report: `date -d"1 day ago" +"%Y%m%d"` " | mutt -s "[pay1all daily report]:`date -d"1 day ago" +"%Y%m%d"`" rainasmoon@126.com -a report-`date -d"1 day ago" +"%Y%m%d"`.html

