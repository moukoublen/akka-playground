FROM openjdk:11-jdk-slim-buster as sbt
RUN apt-get update && apt-get install -y wget
RUN mkdir -p /opt/sbt
RUN wget -q https://piccolo.link/sbt-1.3.10.tgz -O /opt/sbt/sbt.tgz
RUN tar xf /opt/sbt/sbt.tgz --strip-components=1 -C /opt/sbt
RUN opt/sbt/bin/sbt sbtVersion

FROM sbt as builder
COPY . /usr/src/akka-playground
WORKDIR /usr/src/akka-playground
RUN /opt/sbt/bin/sbt universal:packageZipTarball
RUN ls ./target/universal

FROM openjdk:11-jre-buster
RUN mkdir -p /opt/akka-playground
WORKDIR /opt/akka-playground
COPY --from=builder /usr/src/akka-playground/target/universal/mainapp-0.1.0-SNAPSHOT.tgz .
RUN tar xf mainapp-0.1.0-SNAPSHOT.tgz --strip-components=1 -C /opt/akka-playground
CMD ["/opt/akka-playground/bin/mainapp"]