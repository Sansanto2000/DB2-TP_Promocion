#!/bin/bash
echo "############################ init-mongo-1.sh ############################"
set -e
mongoimport -d DB2_promo -c accident --type=csv --headerline --file /csv/US_Accidents_Dec19.csv
echo "#########################################################################"