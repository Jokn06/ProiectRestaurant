CREATE TABLE `chefs`
(
    `id`           int NOT NULL AUTO_INCREMENT,
    `first_name`   varchar(255) DEFAULT NULL,
    `last_name`    varchar(255) DEFAULT NULL,
    `hire_date`    date         DEFAULT NULL,
    `phone_number` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `person`
(
    `id`    int NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) DEFAULT NULL,
    `table` int NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `products`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `product`     varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `price`       int NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `order`
(
    `id`                 int NOT NULL AUTO_INCREMENT,
    `persons_number`     int NOT NULL,
    `number_of_products` int NOT NULL,
    `products`           varchar(255) DEFAULT NULL,
    `total_price`        int NOT NULL,
    PRIMARY KEY (`id`)
);

-- CREATE TABLE `order_aud`
-- (
--     `id`  int NOT NULL AUTO_INCREMENT,
--     `rev` int NOT NULL ,
--     `revtype` tinyint NOT NULL ,
--     `persons_number`     int NOT NULL,
--     PRIMARY KEY (`id`)
-- );

