
DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `orderlines`;
DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `variety` VARCHAR(40) NOT NULL,
    `price` DEC(4,2) NOT NULL,
    `origin` VARCHAR(40) NOT NULL,
    `calories_per_100g` DEC(5,2) DEFAULT NULL,
    `vibe` VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY(`id`)
);

 CREATE TABLE IF NOT EXISTS `orderlines` (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `item_id` INT(11),
     `amount` INT(2),
     `line_total` DEC(6,2),
     PRIMARY KEY(`id`),
     FOREIGN KEY(`item_id`) REFERENCES items(`id`) ON DELETE CASCADE
 );

 CREATE TABLE IF NOT EXISTS `orders` (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `orderline_id` INT(11),
     `total` DEC(6,2),
     PRIMARY KEY(`id`),
     FOREIGN KEY(`orderline_id`) REFERENCES orderlines(`id`) ON DELETE CASCADE
 );
    