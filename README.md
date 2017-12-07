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

## MyBatis Druid Multiple Data Sources

	CREATE SCHEMA `test2` ;
	CREATE TABLE `test2`.`user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC));
    
    INSERT INTO `test2`.`user` (`user_name`, `description`) VALUES ('sgh', 'shiguohuang');

使用@Configuration进行自动配置，且需要设置其中一个Data Source为Primary
	config1 -- ds1 -- mapper1
	config2 -- ds2 -- mapper2

http://localhost:9092/api/user?id=1
http://localhost:9092/api/city?cityName=Guangzhou
    