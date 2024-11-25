FROM eclipse-temurin:21-alpine AS builder

ADD ./gradle gradle/
ADD ./gradlew gradlew
ADD ./settings.gradle.kts settings.gradle.kts
ADD ./build.gradle.kts build.gradle.kts
ADD ./src src/

RUN ./gradlew --version

RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:21-alpine
WORKDIR /usr/src/app
COPY --from=builder build/libs/book-management.jar /usr/src/app/b-book-management.jar

ENV JAVA_OPTS=""

CMD java $JAVA_OPTS -jar book-management.jar
