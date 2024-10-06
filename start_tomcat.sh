#!/bin/bash

# 기존 클래스 파일 삭제
rm -rf /workspace/servletStudy/WEB-INF/classes/*

mkdir -p /workspace/servletStudy/WEB-INF/classes && \
javac -encoding UTF-8 -cp "$(find /workspace/servletStudy/WEB-INF/lib/ -name *.jar -printf %p:)" \
-d /workspace/servletStudy/WEB-INF/classes -g $(find /workspace/servletStudy/WEB-INF/src -name *.java)

docBase=$(sed 's/\//\\\//g' <<< /workspace/servletStudy)

# Context 태그가 이미 존재하는지 확인
if grep -q "<Context.*" $CATALINA_HOME/conf/server.xml; then
    sed -i "s/docBase=\".*\"/docBase=\"$docBase\" reloadable=\"true\"/g" $CATALINA_HOME/conf/server.xml
else
    sed -i "s/<\/Host>/<Context path=\"\" docBase=\"$docBase\" reloadable=\"true\" \/><\/Host>/g" $CATALINA_HOME/conf/server.xml
fi

# Tomcat 시작
java -classpath "$(find /workspace/servletStudy/WEB-INF/lib/ -name *.jar -printf %p:)$CATALINA_HOME/bin/bootstrap.jar:$CATALINA_HOME/bin/tomcat-juli.jar" \
-Dcatalina.base=$CATALINA_HOME -Dcatalina.home=$CATALINA_HOME -Djava.io.tmpdir=$CATALINA_HOME/temp \
org.apache.catalina.startup.Bootstrap start
