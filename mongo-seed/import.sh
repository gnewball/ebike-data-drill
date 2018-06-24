#! /bin/bash

mongoimport --host mongodb --db datlinq --collection delivery_sites --drop -j 120 --type json --file /mongo-seed/delivery_sites.json