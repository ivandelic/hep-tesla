FROM maven:3.5.4-jdk-9 as build
WORKDIR /tesla-powerplant-registry
ADD pom.xml .
ADD src src
RUN mvn package -DskipTests
RUN echo "Maven package done!"

FROM oracle/graalvm-ce:latest
WORKDIR /tesla-powerplant-registry
COPY --from=build /tesla-powerplant-registry/target/tesla-powerplant-registry.jar ./
COPY --from=build /tesla-powerplant-registry/target/libs ./libs
CMD ["java", "-jar", "tesla-powerplant-registry.jar"]
EXPOSE 8080