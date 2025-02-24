Use tienda_Ropa;
-- s) Muestra toda la información del cliente cuyo nombre es Carmen, y sus apellidos "López Martínez".
SELECT * FROM cliente
Where nombre = 'Carmen' AND apellidos = 'López Martínez';

-- t) Muestra toda la información sobre los pedidos (SIN el detalle o líneas de los pedidos).
SELECT * FROM pedido;

-- u) Muestra toda la información sobre los pedidos (CON el detalle o líneas de los pedidos y la
-- descripción de los artículos). 
SELECT p.*, a.nombre AS "Nombre del articulo" , a.precio AS "Precio del articulo", a.marca AS "Marca del articulo"
FROM pedido p
INNER JOIN linea_pedido lp ON p.numero = lp.num_pedido
INNER JOIN articulo a ON lp.cod_art = a.cod_art;

-- v) Muestra la información de los pedidos del cliente con DNI = 01234567I (SIN el detalle o líneas de los
-- pedidos).
SELECT * FROM pedido
WHERE dni_cliente = '01234567I';

-- w) Muestra la información de los pedidos del cliente con DNI = 01234567I (CON el detalle o líneas de
-- los pedidos y la descripción de los artículos).
SELECT p.*, a.nombre AS "Nombre del articulo", a.precio AS "Precio del articulo"
FROM pedido p
INNER JOIN linea_pedido lp ON p.numero = lp.num_pedido
INNER JOIN articulo a ON lp.cod_art = a.cod_art
Where dni_cliente = '01234567I';

-- x) Mostrar la información del cliente que ha realizado el pedido número 8.
SELECT c.*
FROM cliente c
INNER JOIN pedido p ON c.dni = p.dni_cliente
WHERE p.numero = 8;

-- y) Calcular el número de pedidos que ha realizado cada cliente.
SELECT c.dni, c.nombre,c.apellidos, count(p.numero) AS "Número de pedidos"
FROM cliente c
LEFT JOIN pedido p ON c.dni = p.dni_cliente
GROUP BY c.dni;

-- z) Calcular el número de pedidos que se han pagado con Bizum.
SELECT count(*) AS "Pagado con bizum"
FROM pedido p
INNER JOIN metodo_pago mp ON p.m_pago = mp.codigo
WHERE mp.descripcion = 'Bizum';

-- 2.Consultas de manipulación necessarias para la implementación
-- A) 
INSERT INTO articulo (nombre, precio, marca, descripcion, activo, imagen)
VALUES ('Pantalón de chándal', 9.99, 'Decathlon', 'Pantalón de chándal punto unisex', true, 'imagen21.jpg');
select * from articulo;

-- B)

INSERT INTO EMPLEADO (DNI, nombre, apellidos, telefono, direccion, email, activo, tiene_privilegios, pass, dpto)
SELECT '33407774K', 'Jorge', 'Sanz López', '607473813', 'Calle Constitución, 66', 'jorge.sanz@example.com', true, true, '123456', codigo 
FROM DEPARTAMENTO 
WHERE nombre = 'Administración';
select * from empleado;




