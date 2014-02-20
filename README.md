https://github.com/shekhargulati/day22-spring-angularjs-demo-app.git

##LoadTimeWeaver 

La siguiente linea se debe agregar como parametro de la maquina virtual
	
	-javaagent:C:\EntornoSimon\apache-tomcat-7.0.47\webapps\oms\WEB-INF\lib\spring-instrument-4.0.1.RELEASE.jar

## Install oracle driver
	mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar



