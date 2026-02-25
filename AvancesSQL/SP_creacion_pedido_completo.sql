-- procedure con trigger que cree un pedido y pedido_programado
drop procedure if exists SP_CrearPedidoCompleto;
delimiter %%

create procedure SP_CrearPedidoCompleto(
	-- Pedido
    in u_metodo_pago enum("Efectivo","Tarjeta"),
    in u_total double,
    in u_totalDCTO double,
    in u_id_usuario int,
    
    -- pedido Programado
    in u_id_cupon int,
    out o_id_pedido int -- Es el id que se genera al crear el pedido
    
)
begin
	declare v_id_pedido int;
    
    declare exit handler for SQLException -- por si hay un error se detiene
    begin 
		rollback; -- deshace el primer  insert
        set o_id_pedido = null;
	end;
    
	-- para asignar al pedido que se creó
    start transaction;
    
    -- Agregar un pedido Nuevo
		insert into pedidos(metodo_pago, total, totalDCTO, id_usuario) values 
        (u_metodo_pago, u_total, u_totalDCTO, u_id_usuario);
        
        -- dar valor del nuevo registro
        set v_id_pedido = last_insert_id();
        
	-- Agregar pedidoProgramado
		insert into pedidos_programados(id_pedido, id_cupon) values
        (v_id_pedido, u_id_cupon);
        
        commit;
        set o_id_pedido = v_id_pedido;
end %%

delimiter ;

CALL SP_CrearPedidoCompleto('Tarjeta', 150.0, 50.0, 1, 10, @id_generado);