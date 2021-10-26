FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/timesheet-1.0.4-RELEASE timesheet-1.0.4-RELEASE
ENTRYPOINT ["java","-jar","/timesheet-1.0.4-RELEASE"]
