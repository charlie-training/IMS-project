INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `ims`.`items` (`variety`, `origin`, `price`, `calories_per_100g`, `vibe`) VALUES ('dwarf cavendish', 'Canary Islands', '1.20', '99', 'banone');
INSERT INTO `ims`.`items` (`variety`, `origin`, `price`, `calories_per_100g`, `vibe`) VALUES ('lady finger', 'SE Asia', '1.00', '127', 'funky');
INSERT INTO `ims`.`items` (`variety`, `origin`, `price`, `calories_per_100g`, `vibe`) VALUES ('east african highland', 'Uganda', '0.90', '280', 'apple');

INSERT INTO `ims`.`orderlines` (`item_id`, `amount`, `line_total`) VALUES ('1', '2', '2.40');

INSERT INTO `ims`.`orders` (`orderline_id`, `total`) VALUES ('1', '2.40');