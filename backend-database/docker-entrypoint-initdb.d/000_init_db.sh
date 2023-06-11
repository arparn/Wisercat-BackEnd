#!/usr/bin/env bash

psql postgres -c "CREATE USER backend WITH PASSWORD 'backend';"
psql postgres -c "CREATE DATABASE backend OWNER backend;"
