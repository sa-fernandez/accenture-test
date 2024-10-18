create database test;
use test;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 ;
USE `test` ;

-- -----------------------------------------------------
-- Table `test`.`Franchise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`Franchise` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`Branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`Branch` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `Franchise_id` BIGINT(10),
  PRIMARY KEY (`id`),
  INDEX `fk_Branch_Franchise1_idx` (`Franchise_id` ASC) VISIBLE,
  CONSTRAINT `fk_Branch_Franchise1`
    FOREIGN KEY (`Franchise_id`)
    REFERENCES `test`.`Franchise` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`Product` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `stock` INT NULL,
  `Branch_id` BIGINT(10),
  PRIMARY KEY (`id`),
  INDEX `fk_Product_Branch1_idx` (`Branch_id` ASC) VISIBLE,
  CONSTRAINT `fk_Product_Branch1`
    FOREIGN KEY (`Branch_id`)
    REFERENCES `test`.`Branch` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;