use pizzeria;

-- 1. Usuarios (3 perfiles distintos)
INSERT INTO usuarios (nombreUsuario, contraseña, edad, tipo, nombres, apellido_paterno, apellido_materno) VALUES 
('aaron_admin', 'hash_secure_123', 22, 'empleado', 'Aaron', 'García', 'López'),
('carlos_pizzas', 'hash_secure_456', 30, 'empleado', 'Carlos', 'Martínez', 'Sosa'),
('maria_cliente', 'hash_secure_789', 25, 'cliente', 'Maria', 'Hernandez', 'Perez');

-- 2. Domicilios (3 direcciones)
INSERT INTO domicilios_clientes (calle, numero, colonia, codigo_postal) VALUES 
('Av. Tecnológico', '1234', 'Centro', '85000'),
('Calle 5 de Mayo', '55', 'Norte', '85010'),
('Blvd. Las Torres', '900', 'Sur', '85100');

-- 3. Clientes (Relacionados con Usuarios 1, 3 y creamos uno nuevo para el id 4 si fuera necesario, pero usemos los existentes)
-- Nota: Solo los usuarios tipo 'cliente' deben estar aquí.
INSERT INTO clientes (id_usuario, estado, correo, fecha_nacimiento, id_domicilio) VALUES 
(1, 'activo', 'aaron@email.com', '2002-05-15', 1),
(3, 'activo', 'maria@email.com', '1998-10-20', 2);
-- (Añadimos un usuario cliente extra para cumplir con los 3 registros)
INSERT INTO usuarios (nombreUsuario, contraseña, edad, tipo, nombres, apellido_paterno, apellido_materno) VALUES ('juan_perez', 'pass1', 28, 'cliente', 'Juan', 'Perez', 'Ochoa');
INSERT INTO clientes (id_usuario, estado, correo, fecha_nacimiento, id_domicilio) VALUES (4, 'activo', 'juan@email.com', '1995-01-12', 3);

-- 4. Teléfonos Clientes (3 registros para distintos clientes)
INSERT INTO telefonos_clientes (id_telefono, id_usuario, telefono, etiqueta) VALUES 
(1, 1, '6441112233', 'Celular Personal'),
(2, 3, '6445556677', 'Casa'),
(3, 4, '6449998877', 'Trabajo');

-- 5. Empleados (El usuario id 2 es empleado)
-- Añadimos dos empleados más para cumplir los 3
INSERT INTO usuarios (nombreUsuario, contraseña, edad, tipo, nombres, apellido_paterno, apellido_materno) VALUES 
('jose_cocina', 'cocina123', 24, 'empleado', 'Jose', 'Lugo', 'Ramos'),
('ana_caja', 'caja456', 29, 'empleado', 'Ana', 'Soto', 'Vaca');

INSERT INTO empleados (id_usuario, telefono) VALUES 
(2, '6441234567'),
(5, '6448889900'),
(6, '6447771122');

-- 6. Pizzas (3 productos del menú)
INSERT INTO pizzas (nombre, descripcion, precio, estado) VALUES 
('Pepperoni Especial', 'Mucho pepperoni y queso mozzarella premium', 180.00, 'Disponible'),
('Hawaiana Royale', 'Piña caramelizada, jamón de pierna y tocino', 160.00, 'Disponible'),
('Mexicana Power', 'Chorizo, jalapeño fresco, cebolla y frijoles', 190.00, 'Disponible');

-- 7. Cupones (3 cupones)
INSERT INTO cupones (limite_usos, fecha_caducidad, fecha_emision, cantidad, codigo) VALUES 
(10, '2026-12-31 23:59:59', NOW(), 50.0, 'BIENVENIDA50'),
(5, '2026-06-01 00:00:00', NOW(), 30.0, 'CHICKI30'),
(0, '2025-01-01 00:00:00', '2024-01-01', 100.0, 'PROMO_OLD');

-- 8. Pedidos (3 pedidos principales)
INSERT INTO pedidos (metodo_pago, total, totalDCTO, tipo, estado, id_usuario) VALUES 
('Efectivo', 360.0, 50.0, 'PROGRAMADO', 'Pendiente', 1),
('Tarjeta', 160.0, 0, 'EXPRESS', 'Listo', 3),
('Tarjeta', 190.0, 0, 'EXPRESS', 'Entregado', 4);

-- 9. Detalles de Pizzas (3 registros para el Pedido 1 para que se vea robusto)
INSERT INTO detallesPizzas (id_pedido, costo, cantidad, tamaño, notas, id_pizza) VALUES 
(1, 180.0, 1, 'Grande', 'Sin orilla', 1),
(1, 180.0, 1, 'Grande', 'Bien cocida', 1),
(2, 160.0, 1, 'Mediana', 'Extra piña', 2);

-- 10. Pedidos Express (Relacionados con pedidos 2 y 3 + uno extra)
-- Nota: pin debe ser el hash si usas Encriptar.encriptar en Java, aquí pondré texto plano como ejemplo
INSERT INTO pedidos_express (id_pedido, pin, folio) VALUES 
(2, '1234', 1001),
(3, '5678', 1002);
-- Creamos un pedido 4 rápido para tener el 3er express
INSERT INTO pedidos (metodo_pago, total, tipo, estado, id_usuario) VALUES ('Efectivo', 180.0, 'EXPRESS', 'Pendiente', 1);
INSERT INTO pedidos_express (id_pedido, pin, folio) VALUES (4, '9999', 1003);

-- 11. Pedidos Programados (Relacionados con pedido 1)
INSERT INTO pedidos_programados (id_pedido, id_cupon) VALUES 
(1, 1);
-- (Insertamos dos programados más para la estadística)
INSERT INTO pedidos (metodo_pago, total, tipo, estado, id_usuario) VALUES ('Tarjeta', 200.0, 'PROGRAMADO', 'Pendiente', 3), ('Efectivo', 210.0, 'PROGRAMADO', 'Pendiente', 4);
INSERT INTO pedidos_programados (id_pedido, id_cupon) VALUES (5, 2), (6, NULL);

-- 12. Historial de Cambios (3 registros de seguimiento)
INSERT INTO historial_cambios_estado_pedidos (id_pedido, estado_anterior, estado_actual, fechaHora_actualizacion) VALUES 
(2, 'Pendiente', 'Listo', DATE_SUB(NOW(), INTERVAL 15 MINUTE)),
(3, 'Listo', 'Entregado', NOW()),
(1, 'Pendiente', 'Pendiente', NOW());