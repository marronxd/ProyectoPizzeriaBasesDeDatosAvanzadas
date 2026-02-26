-- cambia el estado del pizza de disponible a no disponible
drop procedure if exists SP_CambiarEstadoPizza;
delimiter //

create procedure SP_CambiarEstadoPizza(in idPizza int)
begin
	update pizzas set estado = "No disponible"
    where id_pizza = idPizza and estado = "Disponible";
	
end //

delimiter ;

call SP_CambiarEstadoPizza(1);

use pizzeria;
-- preguntar pq despues de insertar me cambia a preparacion
select * from pizzas;
select * from pedidos;
select * from historial_cambios_estado_pedidos;
-- Tambien hacer un procedure para cambiar de en preparacion a cancelado
