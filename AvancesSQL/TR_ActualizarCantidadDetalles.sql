-- trigger para modificar precios en automatico
-- está pendiente las validaciones de si en estado pendiente puede modificarse 

drop trigger if exists TR_AumentarCantidadPizza;


delimiter ==

create trigger TR_AumentarCantidadPizza
after update on detallesPizzas 
for each row -- recorre cada fila
begin

-- Obtenemos el estado actual del pedido relacionado
    SELECT estado INTO v_estado 
    FROM pedidos  
    WHERE id_pedido = NEW.id_pedido; -- Esta linea me la dio chat gpt porque yo no sabia como ejecutarlo

    -- Solo ejecutamos la lógica si el pedido es 'Pendiente'
    -- (O si el estado es NULL, dependiendo de tu diseño)
    IF (v_estado = 'Pendiente' OR v_estado IS NULL) THEN
    
		if old.cantidad <> new.cantidad then 
			update pedidos set total = total - (old.cantidad * old.costo) + (new.costo * new.cantidad)
			where id_pedido = new.id_pedido;
		end if;
        
	ELSE
	-- Opcional: Lanzar un error si intentan modificar un pedido cerrado
	SIGNAL SQLSTATE '45000' 
	SET MESSAGE_TEXT = 'No se puede modificar el detalle: El pedido ya no está pendiente.';
    end if;
end ==

delimiter ;

delimiter == 
create trigger TR_EliminarCantidadPizza
after update on detallesPizzas
for each row
begin 

-- Obtenemos el estado actual del pedido relacionado
    SELECT estado INTO v_estado 
    FROM pedidos  
    WHERE id_pedido = NEW.id_pedido; -- Esta linea me la dio chat gpt porque yo no sabia como ejecutarlo

    -- Solo ejecutamos la lógica si el pedido es 'Pendiente'
    -- (O si el estado es NULL, dependiendo de tu diseño)
    IF (v_estado = 'Pendiente' OR v_estado IS NULL) THEN
    
		if old.cantidad <> new.cantidad then
			update pedidos set total = total - (old.cantidad * old.costo)
			where id_pedido = new.id_pedido;
		end if;
        
	ELSE
	-- Opcional: Lanzar un error si intentan modificar un pedido cerrado
	SIGNAL SQLSTATE '45000' 
	SET MESSAGE_TEXT = 'No se puede modificar el detalle: El pedido ya no está pendiente.';
    end if;
end ==

delimiter ;


