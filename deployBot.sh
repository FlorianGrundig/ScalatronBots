./sbt.sh package
cp target/scala-2.9.0-1/ScalatronBot.jar ../Scalatron/bots/bot1/
java -jar ../Scalatron/bin/Scalatron.jar -browser no -verbose no