CREATE TABLE chef
(
    id           int          NOT NULL AUTO_INCREMENT,
    first_name   varchar(255) NOT NULL,
    last_name    varchar(255) NOT NULL,
    hire_date    timestamp         NOT NULL,
    phone_number varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_table
(
    id       int          NOT NULL AUTO_INCREMENT,
    capacity int          NOT NULL,
    name     varchar(255) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE product
(
    id          int          NOT NULL AUTO_INCREMENT,
    name        varchar(255) NOT NULL,
    description varchar(255) DEFAULT NULL,
    price       int          ,
    weight      varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_order
(
    id              int  NOT NULL AUTO_INCREMENT,
    table_id        int  NOT NULL,
    order_date      DATE NOT NULL,
    order_completed timestamp,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (table_id) REFERENCES t_table (id)
);

CREATE TABLE order_product
(
    id                       int      NOT NULL AUTO_INCREMENT,
    product_id               int      NOT NULL,
    order_id                 int      NOT NULL,
    start_date timestamp NOT NULL,
    delivered_date  timestamp,
    canceled_date   timestamp,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT FOREIGN KEY (order_id) REFERENCES t_order (id)
);





