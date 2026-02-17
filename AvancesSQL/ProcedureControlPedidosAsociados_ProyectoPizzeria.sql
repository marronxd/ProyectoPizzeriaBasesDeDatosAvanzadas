-- Procedure que controla que la cantidad de pedidos asociados a un cliente no sea mayor a 3 en simultaneo
delimiter //

-- controla que los pedidos por cliente no sean mayores a 3
create procedure SP_ControlarPedidosSimultaneos(in id_cliente int)
begin
	select count(*) as total, id_cliente from pedidos
    where estado in ("","","")
	group by id_cliente
	having total >=3;
		

end //

delimiter ;

