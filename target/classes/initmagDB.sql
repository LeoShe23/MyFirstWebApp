-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mag
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mag
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mag` DEFAULT CHARACTER SET utf8 ;
USE `mag` ;

-- -----------------------------------------------------
-- Table `mag`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mag`.`roles` ;

CREATE TABLE IF NOT EXISTS `mag`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '\n';


-- -----------------------------------------------------
-- Table `mag`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mag`.`users` ;

CREATE TABLE IF NOT EXISTS `mag`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `type` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `type_idx` (`type` ASC) VISIBLE,
  CONSTRAINT `type`
    FOREIGN KEY (`type`)
    REFERENCES `mag`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mag`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `mag`;
INSERT INTO `mag`.`roles` (`id`, `type`) VALUES (1, 'admin');
INSERT INTO `mag`.`roles` (`id`, `type`) VALUES (2, 'moderator');
INSERT INTO `mag`.`roles` (`id`, `type`) VALUES (3, 'user');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mag`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `mag`;
INSERT INTO `mag`.`users` (`id`, `name`, `pass`, `type`) VALUES (1, 'Leo', '123', 1);
INSERT INTO `mag`.`users` (`id`, `name`, `pass`, `type`) VALUES (2, 'She', '321', 2);
INSERT INTO `mag`.`users` (`id`, `name`, `pass`, `type`) VALUES (3, 'Qwe', 'qwe', 3);
INSERT INTO `mag`.`users` (`id`, `name`, `pass`, `type`) VALUES (4, 'Ewq', 'ewq', 3);
INSERT INTO `mag`.`users` (`id`, `name`, `pass`, `type`) VALUES (5, 'Asd', 'asd', 3);

COMMIT;

