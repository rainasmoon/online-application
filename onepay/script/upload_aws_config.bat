call cd /cygdrive/c/Users/wlcic-glen/git/online-application/onepay/script
scp -i "/cygdrive/c/redhat.pem"  ./aws/nginx.conf ec2-user@aws.rainasmoon.com:/etc/nginx/nginx.conf 
scp -i "/cygdrive/c/redhat.pem"  ./aws/fstab ec2-user@aws.rainasmoon.com:/etc/fstab 
