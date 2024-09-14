FROM grafana/grafana:main

COPY grafana.ini /etc/grafana/grafana.ini
COPY provisioning /etc/grafana/provisioning
COPY dashboards /var/lib/grafana/dashboards


RUN ls -la /var/lib/grafana/dashboards*