# dump-velobike-ru
Dump data about Moscow's public velostations from velobike.ru

First, edu project on java.

Depends on gson and sqlite-jdbc.
Way to launch:
cd $dir && java -jar velodump-1.0.jar -classpath ".:sqlite-jdbc-3.8.11.2.jar:gson-2.6.2.jar"

Result saves to file velo.db
