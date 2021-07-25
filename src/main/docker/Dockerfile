FROM carsharing/alpine-oraclejdk8-bash

ARG image_version
LABEL name="backend-api" release="${image_version}"

ENV PORT 5050
EXPOSE ${PORT}

WORKDIR /workdir

# Using Tini to avoid zombie processes
ENV TINI_VERSION v0.19.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini-static /tini
RUN chmod +x /tini

ADD *-all.jar backend-api.jar

ENTRYPOINT ["/tini", "-s", "-v", "--", "java", "-jar", "./backend-api.jar"]