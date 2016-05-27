#rm ./report/*
cp -f /var/log/nginx/access.* ./report
cd report
gzip -df ./*.gz
