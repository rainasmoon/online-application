cd /cygdrive/c/Users/wlcic-glen/git/online-application/onepay/script
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:/etc/nginx/nginx.conf ./aws/nginx.conf
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:/etc/fstab ./aws/fstab
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:~/autodeploy.sh ./aws/autodeploy.sh
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:~/backupdb.sh ./aws/backupdb.sh
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:~/report.sh ./aws/report.sh
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:/mnt/b/backup/* ./aws/backup/

