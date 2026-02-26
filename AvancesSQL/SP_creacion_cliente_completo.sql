-- transaccion para registrar un cliente con domicilio y telefonos

drop procedure if exists SP_crear_registro_cliente_completo;

delimiter $$

create procedure SP_crear_registro_cliente_completo(

	-- Usuario
	IN u_nombre varchar(70), 
	IN u_contraseña varchar(60), 
	IN u_edad int, 
	IN u_nombres varchar(70), 
	IN u_apellidoP varchar(40), 
	IN u_apellidoM varchar(40),
    -- Domicilio
	IN d_calle varchar(70),	
	IN d_numero varchar(30), 
    IN d_colonia varchar(100), 
    IN d_cp varchar(40),
    -- Cliente
	IN c_fecha_nacimiento datetime, 
    IN c_correo varchar(100),
    -- Telefono
	IN tc_telefono varchar(10), 
    IN tc_etiqueta varchar(100),
    -- salida
    out o_id_usuario int
)
begin

	declare v_id_usuario int;
    declare v_id_domicilio int;
    
    declare exit handler for SQLException
	begin
        rollback;
		set o_id_usuario = null;
    end;
    
    -- para asignar a cliente el id que se creò
    
	start transaction;
	
	-- Agregar un usuario nuevo
	insert into usuarios(nombreUsuario, contraseña, edad, tipo, nombres, apellido_paterno, apellido_materno)
	values(u_nombre, u_contraseña, u_edad, u_nombres, u_apellidoP, u_apellidoM);
	-- dar valor del nuevo registro
	set v_id_usuario = last_insert_id();

	-- crear un domicilio asignado a dicho cliente
	insert into domicilios_clientes(calle, numero, colonia, codigo_postal)
	values(d_calle, d_numero, d_colonia, d_cp);
	-- dar valor del nuevo registro
	set v_id_domicilio = last_insert_id();

	-- agregar un cliente nuevo asociado a ese usuario
	insert into cliente (correo, fecha_nacimiento, id_domicilio)
	values (c_correo, c_fecha_nacimiento, v_id_domicilio);

	-- agregar telefono
	insert into telefonos_clientes(id_usuario, telefono, etiqueta)
	values(v_id_usuario, tc_telefono, tc_etiqueta);

	commit ;
    
    set o_id_usuario = v_id_usuario;
    
end$$
    
    delimiter ;
