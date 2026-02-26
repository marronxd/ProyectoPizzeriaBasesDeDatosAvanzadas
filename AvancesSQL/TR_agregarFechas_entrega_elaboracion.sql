-- trigger encargado de agregarFEcha entrega y  elaboracion en pedido

drop trigger if exists TR_agregarFechas_entrega_elaboracion;
delimiter ))

create trigger TR_agregarFechas_entrega_elaboracion
before update on pedidos
for each row
begin 
    -- solo ejecutar logica si el pedido encaja con el estado "Entregado", "Listo"
	if old.estado <> new.estado then
		if new.estado = "Listo" then
			set new.fechaHora_elaboracion = now();
		end if;
        if new.estado = "Entregado" then
			set new.fechaHora_entrega = now();
		end if;
	end if;

end ))

delimiter ;