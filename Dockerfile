FROM maven

COPY smacrobs_web /smacrobs_web
WORKDIR /smacrobs_web

CMD ["mvn", "clean", "install", "tomcat7:run"]
