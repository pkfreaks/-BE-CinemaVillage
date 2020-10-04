#!/bin/sh

CMD="java -Dfile.encoding=UTF-8 -Duser.timezone=UTC -XX:+UseG1GC"

if [ -n "$MYSQL_URI" ] ;      then CMD="$CMD -Dspring.datasource.url=$MYSQL_URI" ;           fi
if [ -n "$MYSQL_USERNAME" ] ; then CMD="$CMD -Dspring.datasource.username=$MYSQL_USERNAME" ; fi
if [ -n "$MYSQL_PASSWORD" ] ; then CMD="$CMD -Dspring.datasource.password=$MYSQL_PASSWORD" ; fi

CMD="$CMD -jar /cv/cv.jar"

exec $CMD
