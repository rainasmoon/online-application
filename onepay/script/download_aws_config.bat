call cd /cygdrive/c/Users/wlcic-glen/git/online-application/onepay/script
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:/etc/nginx/nginx.conf ./aws/nginx.conf
scp -i "/cygdrive/c/redhat.pem"  ec2-user@aws.rainasmoon.com:/etc/fstab ./aws/fstab

