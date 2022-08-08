#!/bin/bash

set -e

mongoimport -d accidents -c accident --type=csv --headerline --file /tmp/US_Accidents_Dec19.csv