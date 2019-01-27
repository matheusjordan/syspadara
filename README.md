# syspadara

O sistema da padaria de seu joaquim está sendo feito utilizando o JavaEE, Maven, Eclipse e seguindo o padrão de projeto MVC.

(22/01/2019) - ''''Atualização'''' > Dia da Recriação do sistema.

(25/01/2019) - Atualização para versão 1.0.0 -:
1- Adicionado Classe [Estoque]
2- Removido qntd_produto da Classe [Produto]
3- Renomeado nome das colunas das Classes [Categoria, Produto, Categoria e Venda]
5- Criado [Repository, Service e Controller] da Classe [Estoque]
6- Refatorado [Repository, Service e Controller das Classes [Categoria, Produto, Categoria e Venda]

(26/01/2019) - Atualização para versao 1.3.0 -:
1- Reorganização do pacote DTO, adicionado [dto.(caixa,categoria,estoque e venda)]
2- Adicionado funcionalidade findVenda à Classe [VendaService]
3- Adicionado funcionalidade addVenda à Classe [CaixaService]
4- Adicionado novo path "atualizacao/venda" para adicionar venda à um caixa
5- Eliminado atributo valor_total da Classe [Caixa]
6- Adicionado DTO [CaixaAddVendas]
7- Adicionado dependencia [swagger-jaxrs2]

OBS: Implatação do Swagger em andamento