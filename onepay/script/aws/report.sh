rm ./report/*
cp /var/log/nginx/access.* ./report
cd report
gzip -d ./*.gz
