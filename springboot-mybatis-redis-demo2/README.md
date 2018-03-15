CREATE TABLE `test1`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

INSERT INTO `test1`.`products` (`id`, `name`, `price`) VALUES ('1', 'TV', '5000');


http://localhost:9191/product/1