#!/bin/bash

echo "Building Docker Image..."
docker build -t file-search:1 .
echo "Running Docker.."
docker run -t file-search:1
