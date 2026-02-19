-- cambia el estado del pedido de en espera a en preparacion

delimiter //

create procedure SP_CambiarEstadoPedido(in idPedido int)
begin
	update pedidos set estado = "En preparacion"
    where id_pedido = idPedido and estado = "En espera";
	
end //

delimiter ;

call SP_CambiarEstadoPedido(3);

use pizzeria;
-- preguntar pq despues de insertar me cambia a preparacion
select * from pedidos;
select * from historial_cambios_estado_pedidos;
-- Tambien hacer un procedure para cambiar de en preparacion a cancelado
