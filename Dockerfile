#1
#FROM adoptopenjdk:11-jre-hotspot as builder
#2
#3
#WORKDIR holycraap
#4
#5
#ARG JAR_FILE=target/*.jar
#6
#7
#COPY ${JAR_FILE} holycraap.jar
#8
#9
#RUN java -Djarmode=layertools -jar holycraap.jar extract
#10
#11
#FROM adoptopenjdk:11-jre-hotspot
#12
#13
#WORKDIR holycraap
#14
#15
#COPY holycraap/dependencies/ ./
#16
#17
#COPY holycraap/spring-boot-loader/ ./
#18
#19
#COPY holycraap/snapshot-dependencies/ ./
#20
#21
##COPY application/resources/ ./
#22
#23
#COPY holycraap/holycraap/ ./
#24
#25
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]