FROM jboss/wildfly:9.0.0.Final
COPY POC_PI_AWS-ear.ear /opt/jboss/wildfly/standalone/deployments/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]


