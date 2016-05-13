cd git/online-application/
git pull
cd onepay
mvn clean install
export DATE=$(date +"%Y%m%d-%H_%M_%S")
cp /usr/share/tomcat8/webapps/onepay.war /mnt/b/war/onepay.war-$DATE
cp ./target/onepay.war /usr/share/tomcat8/webapps/
cp -rf ./html/* /usr/share/tomcat8/webapps/ROOT/

