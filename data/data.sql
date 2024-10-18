use test;

INSERT INTO `test`.`Franchise` (`name`) VALUES ('Franchise A');
INSERT INTO `test`.`Franchise` (`name`) VALUES ('Franchise B');
INSERT INTO `test`.`Franchise` (`name`) VALUES ('Franchise C');

INSERT INTO `test`.`Branch` (`name`, `Franchise_id`) VALUES ('Branch A1', 1);
INSERT INTO `test`.`Branch` (`name`, `Franchise_id`) VALUES ('Branch B1', 2);
INSERT INTO `test`.`Branch` (`name`, `Franchise_id`) VALUES ('Branch C1', 3);
INSERT INTO `test`.`Branch` (`name`, `Franchise_id`) VALUES ('Branch A2', 1);

INSERT INTO `test`.`Product` (`name`, `stock`, `Branch_id`) VALUES ('Product A1', 100, 1);
INSERT INTO `test`.`Product` (`name`, `stock`, `Branch_id`) VALUES ('Product B1', 150, 2);
INSERT INTO `test`.`Product` (`name`, `stock`, `Branch_id`) VALUES ('Product C1', 200, 3);
INSERT INTO `test`.`Product` (`name`, `stock`, `Branch_id`) VALUES ('Product A2', 300, 4);
