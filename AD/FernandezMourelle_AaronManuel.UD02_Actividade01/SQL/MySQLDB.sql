-- Generación de la base de datos
DROP SCHEMA IF EXISTS `unidade2`;
CREATE SCHEMA IF NOT EXISTS `unidade2` ;

-- Generación de la tabla productos.
DROP TABLE IF EXISTS `unidade2`.`PRODUCTOS`;
CREATE TABLE `unidade2`.`PRODUCTOS` (
    `ID` INT NOT NULL,
    `DESCRIPCION` VARCHAR(50) NOT NULL,
    `STOCKACTUAL` INT NULL,
    `STOCKMINIMO` INT NULL,
    `PVP` INT NULL,
    PRIMARY KEY (`ID`)
);
  
-- Generación de la tabla clientes.
DROP TABLE IF EXISTS `unidade2`.`CLIENTES`;
CREATE TABLE `unidade2`.`CLIENTES` (
    `ID` INT NOT NULL,
    `NIF` VARCHAR(10) NOT NULL,
    `NOMBRE` VARCHAR(50) NOT NULL,
    `DIRECCION` VARCHAR(50) NULL,
    `POBLACION` VARCHAR(50) NULL,
    `TELEFONO` VARCHAR(20) NULL,
    PRIMARY KEY (`ID`),
    UNIQUE INDEX `NIF_UNIQUE` (`NIF` ASC) VISIBLE
);

-- Generación de la tabla ventas.
DROP TABLE IF EXISTS `unidade2`.`VENTAS`;
CREATE TABLE `unidade2`.`VENTAS` (
    `IDVENTA` INT NOT NULL,
    `DATAVENTA` DATE NOT NULL,
    `IDCLIENTE` INT NULL,
    `IDPRODUCTO` INT NULL,
    `CANTIDAD` INT NULL,
    PRIMARY KEY (`IDVENTA`),
    INDEX `fk_idCliente_idx` (`IDCLIENTE` ASC) VISIBLE,
    INDEX `fk_idProducto_idx` (`IDPRODUCTO` ASC) VISIBLE,
    CONSTRAINT `fk_idCliente`
        FOREIGN KEY (`IDCLIENTE`) REFERENCES `unidade2`.`CLIENTES` (`ID`)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT `fk_idProducto`
        FOREIGN KEY (`IDPRODUCTO`) REFERENCES `unidade2`.`PRODUCTOS` (`ID`)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);