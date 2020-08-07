FROM openjdk:11.0.8-jdk-slim-buster as sbt
RUN apt-get update && apt-get install -y wget && \
    mkdir -p /opt/sbt && \
    wget -q https://piccolo.link/sbt-1.3.13.tgz -O /opt/sbt/sbt.tgz && \
    tar xf /opt/sbt/sbt.tgz --strip-components=1 -C /opt/sbt && \
    /opt/sbt/bin/sbt sbtVersion

FROM sbt as builder
COPY . /usr/src/akka-playground
WORKDIR /usr/src/akka-playground
RUN /opt/sbt/bin/sbt universal:packageZipTarball

FROM openjdk:11.0.8-jre-slim-buster
COPY --from=builder /usr/src/akka-playground/target/universal/mainapp-0.1.0-SNAPSHOT.tgz /opt/akka-playground/mainapp-0.1.0-SNAPSHOT.tgz
RUN tar xf /opt/akka-playground/mainapp-0.1.0-SNAPSHOT.tgz --strip-components=1 -C /opt/akka-playground
WORKDIR /opt/akka-playground/
CMD ["bin/mainapp"]
