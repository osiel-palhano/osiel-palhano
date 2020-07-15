-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema locadora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema locadora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `locadora` DEFAULT CHARACTER SET utf8 ;
USE `locadora` ;

-- -----------------------------------------------------
-- Table `locadora`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `endereco` VARCHAR(100) NULL,
  `e_mail` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`filme` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locadora`.`locacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locadora`.`locacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_emprestimo` DATE NOT NULL,
  `data_devolucao` DATE NOT NULL,
  `observacao` VARCHAR(200) NULL,
  `cliente_id` INT NOT NULL,
  `filme_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_locacao_cliente_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_locacao_filme1_idx` (`filme_id` ASC) VISIBLE,
  CONSTRAINT `fk_locacao_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `locadora`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_locacao_filme1`
    FOREIGN KEY (`filme_id`)
    REFERENCES `locadora`.`filme` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
