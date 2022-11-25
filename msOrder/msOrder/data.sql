INSERT INTO tb_client (name_client, cpf) VALUES('Alex', '32421')
INSERT INTO tb_orders (number, client,total_value, status, item)
VALUES('123', '1', '200', 'PEDIDO_CRIADO', 'celular');
INSERT INTO tb_item (name_items , price, quantity )
VALUES('celular', 1000, 1);