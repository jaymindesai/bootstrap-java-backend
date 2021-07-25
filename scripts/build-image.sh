#!/bin/bash

echo

if [ "$#" -ne 2 ]; then
  echo "USAGE: ./build-docker.sh IMAGE_NAME IMAGE_VERSION"
  exit 1
fi

IMAGE_NAME=${1}
IMAGE_VERSION="${2}"
TAG_NAME="${IMAGE_NAME}:${IMAGE_VERSION}"
DOCKERFILE="src/main/docker/Dockerfile"

WORKING_DIR="./working-dir"

rm -rf ${WORKING_DIR}
mkdir ${WORKING_DIR}

cp build/libs/*-all.jar ${WORKING_DIR}

docker build -t "${TAG_NAME}" --build-arg image_version="${IMAGE_VERSION}" -f "${DOCKERFILE}" "${WORKING_DIR}"

rm -rf ${WORKING_DIR}