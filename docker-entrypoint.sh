#!/bin/sh

CMD="java -Dfile.encoding=UTF-8 -Duser.timezone=UTC -XX:+UseG1GC"

if [ -n "$MARIADB_URI" ] ;      then CMD="$CMD -Dspring.datasource.url=$MARIADB_URI" ;           fi
if [ -n "$MARIADB_USERNAME" ] ; then CMD="$CMD -Dspring.datasource.username=$MARIADB_USERNAME" ; fi
if [ -n "$MARIADB_PASSWORD" ] ; then CMD="$CMD -Dspring.datasource.password=$MARIADB_PASSWORD" ; fi

CMD="$CMD -jar /cv/cv.jar"

exec $CMD
