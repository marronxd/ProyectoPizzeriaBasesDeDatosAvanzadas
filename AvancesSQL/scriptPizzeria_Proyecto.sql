-- Creación de base de datos
-- creadores: los chiquibases
drop database if exists pizzeria;
create database pizzeria;
use pizzeria;

-- creacion de tablas 
create table usuarios(
	id_usuario int primary key auto_increment,
    nombreUsuario varchar(100) not null,
    contraseña varchar(100) not null,
    tipo enum("cliente", "empleado") not null,
    nombres varchar(80) not null,
    apellido_paterno varchar(60) not null,
    apellido_materno varchar(60) null
);

create table domicilios_clientes (
	id_domicilio int primary key auto_increment,
    calle varchar(100) not null,
    numero varchar(30) not null,
    colonia varchar(150) not null,
    codigo_postal varchar(40) not null,
	id_cliente int null,
	foreign key (id_cliente) references clientes(id_cliente)
	on delete cascade
    on update cascade
);

create table clientes(
	id_usuario int primary key,
    estado enum("activo", "inactivo") default "activo",
    correo varchar(150) not null,
    fecha_nacimiento date not null,
);

create table telefonos_clientes(
	id_telefono int primary key,
    id_usuario int not null,
    numero varchar(10) not null,
    etiqueta varchar(100) not null,
    foreign key (id_usuario) references clientes(id_usuario)
	on delete cascade
    on update cascade
);

create table empleados(
	id_usuario int primary key,
    telefono varchar(10) not null,
    foreign key (id_usuario) references usuarios(id_usuario)
    on delete cascade
    on update cascade
);

create table pedidos(
	id_pedido int primary key auto_increment,
    metodo_pago enum("Efectivo", "Tarjeta") not null,
    total double not null,
    totalDCTO double null,
    tipo varchar(60) null,
    estado enum("Listo","No reclamado", "Entregado", "Cancelado", "Pendiente", "No entregado") not null default "Pendiente",
    fechaHora_entrega date null,
    fechaHora_elaboracion date not null,
    id_usuario int null,
    foreign key (id_usuario) references clientes(id_usuario)
    on delete cascade
    on update cascade
);

create table pedidos_express(
	id_pedido int primary key,
	pin varchar(255) not null, 
	folio varchar(36) not null,
    foreign key (id_pedido) references pedidos(id_pedido)
    on update cascade
    on delete cascade
);

create table cupones(
	id_cupon int primary key auto_increment,
    limite_usos int null,
    fecha_caducidad date null,
    fecha_emision date null,
	descuento double not null,
	codigo varchar(50) unique not null
);

create table pedidos_programados(
	id_pedido int primary key,
    id_cupon int null,
    foreign key (id_pedido) references pedidos(id_pedido)
    on update cascade
    on delete cascade,
	foreign key (id_cupon) references cupones(id_cupon)
    on update cascade
    on delete cascade
);
-- Tabla que guarda el historial de esos cambios de estado de cada pedid

create table historial_cambios_estado_pedidos(
	id int primary key auto_increment,
    id_pedido int not null,
    estado_anterior enum("Listo","No reclamado", "Entregado", "Cancelado", "Pendiente", "No entregado") not null,
    estado_actual enum("Listo","No reclamado", "Entregado", "Cancelado", "Pendiente", "No entregado") null,
    fechaHora_actualizacion date null,
    foreign key (id_pedido) references pedidos(id_pedido)
    on delete cascade
    on update cascade
);

-- continua el flujo normal
create table pizzas(
	id_pizza int primary key auto_increment,
	nombre varchar(100) not null,
    descripcion varchar(250) not null,
    precio double not null,
    estado enum("Disponible", "No disponible") not null default "Disponible"
);

create table detallesPizzas(
	id int primary key auto_increment,
    costo double not null,
    cantidad int not null,
	notas varchar(500) null,
    id_pizza int not null,
	tamaño enum("Chica","Grande","Mediana") not null
    foreign key (id_pizza) references pizzas(id_pizza)
    on delete cascade
    on update cascade
);

