#!/bin/bash

set -e

mongoimport -d DB2_promo -c accident --type=csv --headerline --file /csv/US_Accidents_Dec19.csv