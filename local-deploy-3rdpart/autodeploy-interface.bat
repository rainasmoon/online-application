set JAVA_HOME=D:/jdk1.8.0_66
set MAVEN_HOME=D:/apache-maven-3.0.3
export PATH=.:/cygdrive/d/apache-maven-3.0.3/bin:`printenv PATH`
cd D:/workspace/platform/core/trunk/mc/mc-user-interface
call mvn clean deploy -f pom-3rd.xml
cd D:/workspace/platform/util/trunk/utility/utility-exception
call mvn clean deploy -f pom-3rd.xml