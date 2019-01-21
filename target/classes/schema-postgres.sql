drop table if exists produtos;
create table produtos(id serial primary key, nome_produto varchar(100), valor_produto double(10,2), qntd_produto integer);