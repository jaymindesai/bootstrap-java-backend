#!/bin/bash

if [ -z "${DATA_DIR}" ]; then
  echo "\$DATA_DIR is NOT set"
  exit 1
fi

mkdir "${DATA_DIR}/pgdata"
docker-compose up -d