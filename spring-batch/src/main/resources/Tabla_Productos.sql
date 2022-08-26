use employee_directory;

CREATE TABLE `producto_informacion` (
  `producto_id` int NOT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `fecha_de_recibido` varchar(255) DEFAULT NULL,
  `fecha_de_salida` varchar(255) DEFAULT NULL,
   `correo_de_vendedor` varchar(255) DEFAULT NULL,
  `nombre_de_producto` varchar(255) DEFAULT NULL,
  `tipo_de_producto`varchar(255) DEFAULT NULL,
  PRIMARY KEY (`producto_id`)
);

