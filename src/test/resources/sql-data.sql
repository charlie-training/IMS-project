INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');

INSERT INTO `items` (`variety`, `origin`, `price`, `calories_per_100g`, `vibe`) VALUES ('dwarf cavendish', 'Canary Islands', '1.20', '99', 'banone');

INSERT INTO `orderlines` (`item_id`, `amount`, `line_total`) VALUES ('1', '2', '2.40f');

INSERT INTO `orders` (`orderline_id`, `total`) VALUES ('1', '2.40');