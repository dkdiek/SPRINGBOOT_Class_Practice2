FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#  docker build --build-arg JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar -t demo . 도커 이미지 만들기 명령어
#  docker run -p 8080:8080 demo 도커 실행, 앞에 포트는 도커 외부에서 뒤에 8080은 내부 jar파일의 포트 번호