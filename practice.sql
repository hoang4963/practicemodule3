create database practicemodule3;
use practicemodule3;

CREATE TABLE `practicemodule3`.`classroom` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `practicemodule3`.`student` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(100) NULL,
  `dateofbirth` DATE NULL,
  `address` VARCHAR(255) NULL,
  `phonenumber` VARCHAR(100) NULL unique,
  `email` VARCHAR(100) NULL unique,
  `classroom_id` int NULL,
  PRIMARY KEY (`id`),
  foreign key (classroom_id) references classroom(id)
    );
    
    INSERT INTO `practicemodule3`.`classroom` (`name`) VALUES ('toan');
INSERT INTO `practicemodule3`.`classroom` (`name`) VALUES ('ly');
INSERT INTO `practicemodule3`.`classroom` (`name`) VALUES ('hoa');

INSERT INTO `practicemodule3`.`student` (`name`, `dateofbirth`, `address`, `phonenumber`, `email`, `classroom_id`) VALUES ('hoang', '1999-04-07', 'Ha Nam', '0965934963', 'hoang@gmail.com', '1');
INSERT INTO `practicemodule3`.`student` (`name`, `dateofbirth`, `address`, `phonenumber`, `email`, `classroom_id`) VALUES ('Quan', '1993-07-07', 'Hai Phong', '0123456789', 'quan@gmail.com', '2');
INSERT INTO `practicemodule3`.`student` (`name`, `dateofbirth`, `address`, `phonenumber`, `email`, `classroom_id`) VALUES ('Trung', '1993-08-08', 'Quang Ninh', '0987654321', 'trung@gmail.com', '3');
