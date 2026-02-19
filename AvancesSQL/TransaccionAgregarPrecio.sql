-- La transaccion para aumentar el precio al agregar productos

start transaction;

--
update detallespizzas as dp
inner join pizzas as pz 
on dp.id_pizza = pz.id_pizza and pz.estado = "disponible"
set dp.costo = dp.costo + pz.precio;
	
commit;