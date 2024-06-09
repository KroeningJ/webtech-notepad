#
# Build stage
#
FROM gradle:jdk21-jammy AS build

# Copy the project files to the build directory
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Ensure the gradlew script is executable
RUN chmod +x gradlew

# Run the build using the Gradle wrapper
RUN ./gradlew clean build --no-daemon --stacktrace

LABEL org.name="KroeningJ"

#
# Package stage
#
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
