call cd D:/workspace/platform

set JAVA_HOME=D:/jdk1.8.0_66
set MAVEN_HOME=D:/apache-maven-3.0.3
export PATH=.:/cygdrive/d/apache-maven-3.0.3/bin:`printenv PATH`

cd D:/workspace/platform/util/trunk/project-parent
call D:/apache-maven-3.0.3/bin/mvn clean install


cd D:/workspace/platform/util/trunk/utility
call D:/apache-maven-3.0.3/bin/mvn clean install


set JAVA_HOME=D:/jdk1.6.0_10
cd D:/workspace/platform/common/trunk/message
call D:/apache-maven-3.0.3/bin/mvn clean install


cd D:/workspace/platform/common/trunk/message/message-war/target/
scp ./message-war-1.0.0.war weblogic@10.196.112.26:/weblogic/webapp/message-war

