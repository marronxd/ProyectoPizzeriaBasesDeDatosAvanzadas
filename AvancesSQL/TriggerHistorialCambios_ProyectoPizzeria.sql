-- Trigger modificador de los estados de los pedidos
-- modifica el registro del historial
delimiter //

create trigger registros_cambios_estados
after update on pedidos
for each row -- recorre cada fila para verificar los cambios
begin -- empieza
	if OLD.estado <> NEW.estado then -- el old es palabra re
		insert into historial_cambios_estado_pedidos( -- new guarda el nuevo
			id_pedido,
			estado_anterior,
			estado_actual,
			fechaHora_actualizacion
		) values(
			OLD.id_pedido,
			OLD.estado,
			NEW.estado,
			now()
		);
    end if; -- simplemente es el cierre del comando
end //

delimiter ;