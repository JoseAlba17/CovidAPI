FROM maven:3.6.3-jdk-8

COPY . /myapp

WORKDIR /myapp

RUN mvn clean package
RUN mv myapp/target/*.jar myapp/myapp.jar

COPY --from=builder myapp/myapp.jar myapp/myapp.jar

ENTRYPOINT ["java", "-jar", "myapp/myapp.jar"]
