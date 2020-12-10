USE practicaRicoh;


INSERT INTO catalogos (nombre) VALUES ("Catálogo básico");
INSERT INTO catalogos (nombre) VALUES ("Cátalogo vacaciones");
INSERT INTO catalogos (nombre) VALUES ("Cátalogo promociones");


INSERT INTO articulos (nombre,descripcion,precio,id_catalogo) VALUES ( "Articulo 1","Descripción 1",5,1);
INSERT INTO articulos (nombre,descripcion,precio,id_catalogo) VALUES ( "Articulo 2","Descripción 2",4,1);
INSERT INTO articulos (nombre,descripcion,precio,id_catalogo) VALUES ( "Articulo 3","Descripción 3",7,2);
INSERT INTO articulos (nombre,descripcion,precio,id_catalogo) VALUES ( "Articulo 4","Descripción 4",8,2);
INSERT INTO articulos (nombre,descripcion,precio,id_catalogo) VALUES ( "Articulo 5","Descripción 5",6,2);
INSERT INTO articulos (nombre,descripcion,precio,id_catalogo) VALUES ( "Articulo 6","Descripción 6",7,3);


INSERT INTO pedidos (nombre,total) VALUES ("Inicial",50);

INSERT INTO articulos_pedidos (cantidad,articulo_id,pedido_id) VALUES (1,1,1);
INSERT INTO articulos_pedidos (cantidad,articulo_id,pedido_id) VALUES (3,2,1);
INSERT INTO articulos_pedidos (cantidad,articulo_id,pedido_id) VALUES (5,3,1);

INSERT INTO usuarios (apellidos,nombre,password,role,token,usuario) VALUES ('test','test','password','user','token','user');
