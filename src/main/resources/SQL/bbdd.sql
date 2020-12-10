create database practicaRicoh;

use practicaRicoh;

CREATE TABLE `catalogos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `articulos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(256) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `precio` float DEFAULT NULL,
  `id_catalogo` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8r1qc7hc6cptxa9ix70bq6s9i` (`id_catalogo`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

CREATE TABLE `pedidos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `articulos_pedidos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `articulo_id` bigint(20) DEFAULT NULL,
  `pedido_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKompdlvftht1y6hrugptq64amu` (`articulo_id`),
  KEY `FK1w5fxh8hfyqcy8fmq65cf486u` (`pedido_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(256) DEFAULT NULL,
  `token` varchar(256) DEFAULT NULL,
  `usuario` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

