# MyBatis

## MyBatis Annotation

  CREATE SCHEMA `test1`;

  CREATE TABLE `test1`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `province_id` INT NOT NULL,
  `city_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `city_name_UNIQUE` (`city_name` ASC));
  
  INSERT INTO `test1`.`city` (`province_id`, `city_name`, `description`) VALUES ('1', 'Guangzhou', '广东省会');


http://localhost:9090/api/city?cityName=Guangzhou

## MyBatis XML

http://localhost:9091/api/city?cityName=Guangzhou