#!/bin/sh

BOT_NAME=floBot

SCALATRON_DIR=../../other/Scalatron

sbt package
rm -fr $SCALATRON_DIR/bots/$BOT_NAME
mkdir -p $SCALATRON_DIR/bots/$BOT_NAME
cp target/scala-2.9.3/ScalatronBot.jar $SCALATRON_DIR/bots/$BOT_NAME
java -jar $SCALATRON_DIR/bin/Scalatron.jar -browser no -verbose no