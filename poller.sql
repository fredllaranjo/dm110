CREATE DATABASE "dm110-poller"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE TABLE device_status (
	ip varchar(11) NOT NULL,
    status varchar(8) NOT NULL,
    CONSTRAINT pk_device_status PRIMARY KEY (ip)
);