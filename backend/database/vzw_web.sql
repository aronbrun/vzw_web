
DROP DATABASE vzw_test;
CREATE DATABASE vzw_test;


USE vzw_test;
-- -----------------------------------------------------
-- Table `vzw_test`.`City`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`City` (
  `idCity` INT(11) NOT NULL AUTO_INCREMENT,
  `postCode` VARCHAR(20) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idCity`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Address` (
  `idAddress` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(100) NOT NULL,
  `fk_City` INT(11) NOT NULL,
  PRIMARY KEY (`idAddress`),
  INDEX `fk_Address_City_idx` (`fk_City` ASC),
  CONSTRAINT `fk_Address_City`
    FOREIGN KEY (`fk_City`)
    REFERENCES `vzw_test`.`City` (`idCity`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `vzw_test` ;

-- -----------------------------------------------------
-- Table `vzw_test`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`User` (
  `idUser` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `birthDate` DATE NOT NULL,
  `gender` VARCHAR(1) NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `fk_Address` INT NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_User_Address1_idx` (`fk_Address` ASC),
  CONSTRAINT `fk_User_Address1`
    FOREIGN KEY (`fk_Address`)
    REFERENCES `vzw_test`.`Address` (`idAddress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Client` (
  `idClient` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_User` INT(11) NOT NULL,
  PRIMARY KEY (`idClient`),
  INDEX `fk_kunde_user1_idx` (`fk_User` ASC),
  CONSTRAINT `fk_Client_User`
    FOREIGN KEY (`fk_User`)
    REFERENCES `vzw_test`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Category` (
  `idCategory` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `minAge` INT(11) NOT NULL,
  `maxAge` INT(11) NOT NULL,
  PRIMARY KEY (`idCategory`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Course` (
  `idCourse` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `fk_Category` INT(11) NOT NULL,
  `weekday` VARCHAR(45) NOT NULL,
  `startate` DATE NOT NULL,
  `enddate` DATE NOT NULL,
  `starttime` TIME NOT NULL,
  `endtime` TIME NOT NULL,
  `cancellationDates` VARCHAR(100) NOT NULL,
  `lessonNumber` INT(11) NOT NULL,
  `costs` INT(11) NOT NULL,
  `maxRegistration` INT(11) NOT NULL,
  PRIMARY KEY (`idCourse`),
  INDEX `fk_kurs_kategorie1_idx` (`fk_Category` ASC),
  CONSTRAINT `fk_Course_Category`
    FOREIGN KEY (`fk_Category`)
    REFERENCES `vzw_test`.`Category` (`idCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Cancellation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Cancellation` (
  `idCancellation` INT(11) NOT NULL AUTO_INCREMENT,
  `Client_idClient` INT(11) NOT NULL,
  `Course_idCourse` INT(11) NOT NULL,
  PRIMARY KEY (`idCancellation`),
  INDEX `fk_Cancellation_Client1_idx` (`Client_idClient` ASC),
  INDEX `fk_Cancellation_Course1_idx` (`Course_idCourse` ASC),
  CONSTRAINT `fk_Cancellation_Client`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `vzw_test`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cancellation_Course`
    FOREIGN KEY (`Course_idCourse`)
    REFERENCES `vzw_test`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`EventInformation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`EventInformation` (
  `idEventInformation` INT(11) NOT NULL AUTO_INCREMENT,
  `startdate` DATE NOT NULL,
  `enddate` DATE NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `links` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`idEventInformation`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Competition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Competition` (
  `idCompetition` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_EventInformation` INT(11) NOT NULL,
  `category` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idCompetition`),
  INDEX `fk_Competition_EventInformation1_idx` (`fk_EventInformation` ASC),
  CONSTRAINT `fk_Competition_EventInformation1`
    FOREIGN KEY (`fk_EventInformation`)
    REFERENCES `vzw_test`.`EventInformation` (`idEventInformation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Event` (
  `idEvent` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_EventInformation` INT(11) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idEvent`),
  INDEX `fk_Event_EventInformation1_idx` (`fk_EventInformation` ASC),
  CONSTRAINT `fk_Event_EventInformation1`
    FOREIGN KEY (`fk_EventInformation`)
    REFERENCES `vzw_test`.`EventInformation` (`idEventInformation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Member` (
  `idMember` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_User` INT(11) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idMember`),
  INDEX `fk_mitglied_user1_idx` (`fk_User` ASC),
  CONSTRAINT `fk_Member_User`
    FOREIGN KEY (`fk_User`)
    REFERENCES `vzw_test`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `vzw_test`.`Registration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vzw_test`.`Registration` (
  `idRegistration` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_Client` INT(11) NOT NULL,
  `fk_Course` INT(11) NOT NULL,
  `status` INT(11) NOT NULL,
  PRIMARY KEY (`idRegistration`),
  INDEX `fk_Registration_Client1_idx` (`fk_Client` ASC),
  INDEX `fk_Registration_Course1_idx` (`fk_Course` ASC),
  CONSTRAINT `fk_Registration_Client`
    FOREIGN KEY (`fk_Client`)
    REFERENCES `vzw_test`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Registration_Course`
    FOREIGN KEY (`fk_Course`)
    REFERENCES `vzw_test`.`Course` (`idCourse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
