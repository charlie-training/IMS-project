drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `variety` VARCHAR(40) NOT NULL,
    `price` DEC(4,2) NOT NULL,
    `origin` VARCHAR(40) NOT NULL,
    `calories_per_100g` DEC(5,2),
    `vibe` VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orderlines` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_id` INT(11),
    `amount` INT(2),
    `line_total` DEC(6,2),
    PRIMARY KEY(`id`),
    FOREIGN KEY(`item_id`) REFERENCES items(`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `orderline_id` INT(11),
    `total` DEC(6,2),
    PRIMARY KEY(`id`),
    FOREIGN KEY(`orderline_id`) REFERENCES orderlines(`id`) ON DELETE CASCADE
);
    