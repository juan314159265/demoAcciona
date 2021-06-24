call mvn install:install-file -Dfile=lib/base.jar -DgroupId=com.sine95.base -DartifactId=api -Dversion=1.0 -Dpackaging=jar

call mvn package -Dmaven.test.skip=true