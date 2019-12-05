FROM maven:3.5.4-jdk-9 as build
WORKDIR /tesla
ADD pom.xml .
ADD tesla-common tesla-common
ADD tesla-powerplant-registry tesla-powerplant-registry
RUN mvn package -DskipTests
RUN echo "Maven package done!"

FROM oraseemeaceeadriatics/hep-tesla:latest
WORKDIR /tesla
ENV TNS_ADMIN="/wallet"
ENV JAVAX_SQL_DATASOURCE_TESLA_dash_POWERPLANT_dash_REGISTRY_dash_ORCL_dash_DS_DATASOURCE_USER=""
ENV JAVAX_SQL_DATASOURCE_TESLA_dash_POWERPLANT_dash_REGISTRY_dash_ORCL_dash_DS_DATASOURCE_PASSWORD=""
COPY --from=build /tesla/tesla-powerplant-registry/target/tesla-powerplant-registry.jar ./
COPY --from=build /tesla/tesla-powerplant-registry/target/libs ./libs
CMD ["java", "-jar", "tesla-powerplant-registry.jar"]
EXPOSE 8080
