
CREATE TABLE chef
(
    id           int          NOT NULL AUTO_INCREMENT,
    first_name   varchar(255) NOT NULL,
    last_name    varchar(255) NOT NULL,
    hire_date    date    NOT NULL,
    phone_number varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id           int          NOT NULL AUTO_INCREMENT,
    name         varchar(255) NOT NULL,
    address      varchar(255) NOT NULL,
    phone_number varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id     int          NOT NULL AUTO_INCREMENT,
    name   varchar(255) NOT NULL,
    price  int,
    weight varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user
(
    id       int          NOT NULL AUTO_INCREMENT,
    name     varchar(255) NOT NULL,
    password varchar(64)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_order
(
    id           int          NOT NULL AUTO_INCREMENT,
    phone_number varchar(255) NOT NULL,
    address      varchar(255) NOT NULL,
    customer_id      int          NOT NULL,
    start_date   timestamp    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (customer_id) REFERENCES user (id)
);

CREATE TABLE order_services
(
    order_id   int NOT NULL,
    product_id int NOT NULL,
    PRIMARY KEY (order_id, product_id),
    CONSTRAINT FOREIGN KEY (product_id) REFERENCES product (id),
    CONSTRAINT FOREIGN KEY (order_id) REFERENCES t_order (id)
);

