#!/bin/bash
cd /mnt/b/backup/
mysqldump -uroot -pbsnpb6p onepayapp >/mnt/b/backup/onepayapp`date +%Y-%m-%d`.sql

