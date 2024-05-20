#!/bin/bash

echo "1º parâmetro =>" $1
echo "2º parâmetro =>" $2

pid=`ps -fu $1 | grep "$2" | grep -v "grep" | awk '{print $2}'`

echo "pids => " $pid

kill $pid