-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema comp353_assignment1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema comp353_assignment1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `comp353_assignment1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `comp353_assignment1` ;

-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Department` (
  `department_name` VARCHAR(100) NOT NULL,
  `location` VARCHAR(100) NULL,
  PRIMARY KEY (`department_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Employee` (
  `Employee_ID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `social_security_number` INT(9) NOT NULL,
  `title` VARCHAR(45) NULL,
  `salary` INT NULL,
  `email_address` VARCHAR(45) NOT NULL,
  `department_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  UNIQUE INDEX `social_security_number_UNIQUE` (`social_security_number` ASC) VISIBLE,
  UNIQUE INDEX `email_address_UNIQUE` (`email_address` ASC) VISIBLE,
  INDEX `fk_Employee_Department1_idx` (`department_name` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Department1`
    FOREIGN KEY (`department_name`)
    REFERENCES `comp353_assignment1`.`Department` (`department_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Faculty Member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Faculty Member` (
  `Employee_ID` INT NOT NULL,
  `department_name` VARCHAR(100) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `social_security_number` INT(9) NOT NULL,
  `title` VARCHAR(45) NULL,
  `salary` INT NULL,
  `email_address` VARCHAR(45) NOT NULL,
  `specialization` VARCHAR(45) NULL,
  `research_area` VARCHAR(45) NULL,
  `research_grant` INT NULL,
  PRIMARY KEY (`Employee_ID`),
  UNIQUE INDEX `social_security_number_UNIQUE` (`social_security_number` ASC) VISIBLE,
  UNIQUE INDEX `ID_UNIQUE` (`Employee_ID` ASC) VISIBLE,
  UNIQUE INDEX `email_address_UNIQUE` (`email_address` ASC) VISIBLE,
  INDEX `fk_Faculty Member_Department1_idx` (`department_name` ASC) VISIBLE,
  CONSTRAINT `fk_Faculty Member_Department1`
    FOREIGN KEY (`department_name`)
    REFERENCES `comp353_assignment1`.`Department` (`department_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Administrative personnel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Administrative personnel` (
  `Employee_ID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `social_security_number` INT(9) NOT NULL,
  `title` VARCHAR(45) NULL,
  `salary` INT NULL,
  `email_address` VARCHAR(45) NOT NULL,
  `qualification` VARCHAR(45) NULL,
  `special_skills` VARCHAR(45) NULL,
  `department_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  UNIQUE INDEX `social_security_number_UNIQUE` (`social_security_number` ASC) VISIBLE,
  UNIQUE INDEX `ID_UNIQUE` (`Employee_ID` ASC) VISIBLE,
  UNIQUE INDEX `email_address_UNIQUE` (`email_address` ASC) VISIBLE,
  INDEX `fk_Administrative personnel_Department1_idx` (`department_name` ASC) VISIBLE,
  CONSTRAINT `fk_Administrative personnel_Department1`
    FOREIGN KEY (`department_name`)
    REFERENCES `comp353_assignment1`.`Department` (`department_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Program` (
  `program_name` VARCHAR(45) NOT NULL,
  `department_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`program_name`),
  INDEX `fk_Program_Department1_idx` (`department_name` ASC) VISIBLE,
  CONSTRAINT `fk_Program_Department1`
    FOREIGN KEY (`department_name`)
    REFERENCES `comp353_assignment1`.`Department` (`department_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Student` (
  `student_ID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `grade(gpa)` FLOAT NULL,
  `department_name` VARCHAR(100) NOT NULL,
  `program_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`student_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`student_ID` ASC) VISIBLE,
  INDEX `fk_Student_Department1_idx` (`department_name` ASC) VISIBLE,
  INDEX `fk_Student_Program1_idx` (`program_name` ASC) VISIBLE,
  CONSTRAINT `fk_Student_Department1`
    FOREIGN KEY (`department_name`)
    REFERENCES `comp353_assignment1`.`Department` (`department_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student_Program1`
    FOREIGN KEY (`program_name`)
    REFERENCES `comp353_assignment1`.`Program` (`program_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Graduate Student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Graduate Student` (
  `student_ID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `grade(gpa)` FLOAT NULL,
  `research_topic` VARCHAR(45) NULL,
  `research_fellowship` FLOAT NULL,
  `department_name` VARCHAR(100) NOT NULL,
  `supervisor_id` INT NOT NULL,
  `program_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`student_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`student_ID` ASC) VISIBLE,
  INDEX `fk_Graduate Student_Department1_idx` (`department_name` ASC) VISIBLE,
  INDEX `fk_Graduate Student_Faculty Member1_idx` (`supervisor_id` ASC) VISIBLE,
  INDEX `fk_Graduate Student_Program1_idx` (`program_name` ASC) VISIBLE,
  CONSTRAINT `fk_Graduate Student_Department1`
    FOREIGN KEY (`department_name`)
    REFERENCES `comp353_assignment1`.`Department` (`department_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Graduate Student_Faculty Member1`
    FOREIGN KEY (`supervisor_id`)
    REFERENCES `comp353_assignment1`.`Faculty Member` (`Employee_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Graduate Student_Program1`
    FOREIGN KEY (`program_name`)
    REFERENCES `comp353_assignment1`.`Program` (`program_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Course` (
  `course_number` INT NOT NULL,
  `description` TEXT NULL,
  `credit_hours` FLOAT NULL,
  `department_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`course_number`),
  INDEX `fk_Course_Department_idx` (`department_name` ASC) VISIBLE,
  CONSTRAINT `fk_Course_Department`
    FOREIGN KEY (`department_name`)
    REFERENCES `comp353_assignment1`.`Department` (`department_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comp353_assignment1`.`Student Course History`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comp353_assignment1`.`Student Course History` (
  `history_id` INT NOT NULL AUTO_INCREMENT,
  `grade` VARCHAR(2) NULL,
  `status` VARCHAR(45) NULL,
  `student_ID` INT NULL,
  `graduate_student_ID` INT NULL,
  `course_number` INT NOT NULL,
  `facaulty_member_ID` INT NOT NULL,
  PRIMARY KEY (`history_id`),
  INDEX `fk_Student Course History_Student1_idx` (`student_ID` ASC) VISIBLE,
  INDEX `fk_Student Course History_Graduate Student1_idx` (`graduate_student_ID` ASC) VISIBLE,
  INDEX `course_number_idx` (`course_number` ASC) VISIBLE,
  INDEX `fk_Student Course History_Faculty Member1_idx` (`facaulty_member_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Student Course History_Student1`
    FOREIGN KEY (`student_ID`)
    REFERENCES `comp353_assignment1`.`Student` (`student_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student Course History_Graduate Student1`
    FOREIGN KEY (`graduate_student_ID`)
    REFERENCES `comp353_assignment1`.`Graduate Student` (`student_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `course_number`
    FOREIGN KEY (`course_number`)
    REFERENCES `comp353_assignment1`.`Course` (`course_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Student Course History_Faculty Member1`
    FOREIGN KEY (`facaulty_member_ID`)
    REFERENCES `comp353_assignment1`.`Faculty Member` (`Employee_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;