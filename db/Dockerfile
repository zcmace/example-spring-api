FROM mysql:latest
LABEL authors="Zach"

WORKDIR /app

COPY . /docker-entrypoint-initdb.d
RUN chmod -R 755 /docker-entrypoint-initdb.d

USER mysql

ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=admin123
ENV MYSQL_DATABASE=example_spring
ENV MYSQL_ROOT_PASSWORD=root

EXPOSE 3306