#!/bin/bash

set -e

while ! curl -sSL "http://localhost:4444/wd/hub/status" 2>&1 \
        | jq -r '.value.ready' 2>&1 | grep "true"; do
    echo 'Waiting for the Grid'
    sleep 1
done


>&2 echo "Selenium Grid is up - executing test"

exec /bin/sh ./runGradle.sh