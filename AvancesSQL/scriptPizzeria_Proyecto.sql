-- Creación de base de datos
-- creadores: los chiquibases
drop database if exists pizzeria;
create database pizzeria;
use pizzeria;

-- creacion de tablas 
create table domicilios_clientes (
	id_domicilio int primary key auto_increment,
    calle varchar(100) not null,
    numero varchar(30) not null,
    colonia varchar(150) not null,
    codigo_postal varchar(40) not null
);

create table clientes(
	id_cliente int primary key,
    nombres varchar(80) not null,
    apellido_paterno varchar(60) not null,
    apellido_materno varchar(60) null,
    fecha_nacimiento datetime not null,
    id_domicilio int not null, -- Llave foranea de domicilios
    foreign key (id_domicilio) references domicilios_clientes (id_domicilio)
    on delete cascade
    on update cascade
);

create table pedidos(
	id_pedido int primary key auto_increment,
    pin varchar(255) not null, 
    tipo varchar(60) not null,
    estado enum("Listo","No reclamado", "Entregado", "Cancelado", "En preparacion")  not null,
    folio varchar(36),
    fechaHora_entrega datetime null,
    fechaHora_elaboracion datetime null,
    fechaHora_descarte datetime null,
    id_cliente int not null,
    foreign key (id_cliente) references clientes(id_cliente)
    on delete cascade
    on update cascade
);

create table pizzas_catalogo(
	id_pizza_catalogo int primary key auto_increment,
    nombre varchar(100) not null,
    tamaño enum("Chica","Grande","Mediana") not null,
    descripcion varchar(250) not null,
    precio int not null,
    estado enum("Disponible", "No disponible") not null default "Disponible"
);

create table pizzas(
	id_pizza int primary key auto_increment,
    costo int not null,
	notas varchar(500) not null,
    id_pizza_catalogo int not null,
    foreign key (id_pizza_catalogo) references pizzas_catalogo(id_pizza_catalogo)
    on delete cascade
    on update cascade
);

create table ingredientes(
	id_ingrediente int primary key auto_increment,
    descripcion varchar(200),
    nombre varchar(200)
);
create table ingrediente_pizzaCatalog(
	id int primary key auto_increment,
    id_pizza_catalogo int not null,
    id_ingrediente int not null,
    foreign key (id_pizza_catalogo) references pizzas_catalogo(id_pizza_catalogo)
    on delete cascade
    on update cascade,
    foreign key (id_ingrediente) references ingredientes(id_ingrediente)
    on delete cascade
    on update cascade
);

create table cupones(
	id_cupon int primary key auto_increment,
	fecha_emision datetime not null,
    usos int not null,
    fecha_fin datetime not null,
    fecha_emision datetime null -- a la mejor en promocion el cupon pero está guardado
);

create table cupones_pedidos(
	id_cuponePed int primary key auto_increment,
    id_cupon int not null,
    id_pedido int not null,
    foreign key (id_cupon) references cupones(id_cupon)
    on delete cascade
    on update cascade,
    foreign key (id_pedido) references pedidos(id_pedido)
    on delete cascade
    on update cascade
);