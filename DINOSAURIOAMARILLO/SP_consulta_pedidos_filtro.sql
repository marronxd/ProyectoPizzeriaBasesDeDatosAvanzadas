-- procedure para filtrar por usuario, por estado o por ambos
DELIMITER $$

CREATE PROCEDURE sp_consultar_pedidos_filtros(
    IN p_id_usuario INT,
    IN p_estado enum('Listo','Entregado','Cancelado','Pendiente','No entregado')
)
BEGIN
    SELECT id_pedido, metodo_pago, total, totalDCTO, tipo, estado, fechaHora_entrega, fechaHora_elaboracion, id_usuario FROM pedidos
    WHERE (p_id_usuario IS NULL OR id_usuario = p_id_usuario)
      AND (p_estado IS NULL OR estado = p_estado)
    ORDER BY id_pedido DESC; -- Para ver los más recientes primero
END $$

DELIMITER ;