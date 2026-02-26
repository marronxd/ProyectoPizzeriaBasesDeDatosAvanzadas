delimiter $$

create procedure SP_crear_registro_cliente_completo(
    -- Usuario
    IN u_nombres varchar(100), 
    IN u_apellidoP varchar(100), 
    IN u_apellidoM varchar(100),
    IN u_nombreUsuario varchar(100), 
    IN u_contraseña varchar(100), 
    -- Cliente
    IN c_correo varchar(100),
    IN c_fecha_nacimiento date, 
    -- Domicilio
    IN d_calle varchar(100),    
    IN d_numero varchar(100), 
    IN d_colonia varchar(100), 
    IN d_cp varchar(100),
    -- Telefono
    IN tc_numero varchar(10), 
    IN tc_etiqueta varchar(100),
    -- salida
    out o_id_usuario int
)
begin
    declare v_id_usuario int;
    
    -- Manejador de errores
    declare exit handler for sqlexception
    begin
        rollback;
        set o_id_usuario = null;
    end;
    
    start transaction;

    -- 1. Insertar en la tabla base 'usuarios'
    -- Nota: Usamos 'cliente' (minúscula) porque así está definido en tu ENUM de la tabla usuarios
    insert into usuarios (nombreUsuario, contraseña, tipo, nombres, apellido_paterno, apellido_materno)
    values (u_nombreUsuario, u_contraseña, 'cliente', u_nombres, u_apellidoP, u_apellidoM);
    
    set v_id_usuario = last_insert_id();

    -- 2. Insertar en 'clientes' (Usando el mismo ID de usuario como PK)
    insert into clientes (id_usuario, estado, correo, fecha_nacimiento)
    values (v_id_usuario, 'Activo', c_correo, c_fecha_nacimiento);

    -- 3. Insertar en 'domicilios_clientes' (La FK apunta a clientes)
    insert into domicilios_clientes (calle, numero, colonia, codigo_postal, id_usuario)
    values (d_calle, d_numero, d_colonia, d_cp, v_id_usuario);

    -- 4. Insertar en 'telefonos_clientes'
    insert into telefonos_clientes (id_usuario, numero, etiqueta)
    values (v_id_usuario, tc_numero, tc_etiqueta);

    commit;
    
    set o_id_usuario = v_id_usuario;
end$$

delimiter ;