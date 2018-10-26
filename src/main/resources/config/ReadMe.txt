log collections by logstash and store into elastic 5.4.1

ways:

     1. application logs
     2. firewall logs
     3. components logs, such as edas, rdas, oss etc.

log overall solutions:

     1. kafka + zookeeper           collecting application logs to save local
     2. logstash or filebeat        collecting firewall logs
     3. kafka + logstash + elastic  collecting application logs and compenent logs: edas, rdas, oss
     4. spring data elastic + springboot + spring cloud   functions as kibana

log type:

log index strategy:


