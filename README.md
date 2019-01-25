# syspadara

O sistema da padaria de seu joaquim está sendo feito utilizando o JavaEE, Maven, Eclipse e seguindo o padrão de projeto MVC.

(22/01/2019) Seu joaquim está muito contente com o progresso do sistema e decidiu investir mais R$ 500.000,00 (Quinhentos Mil Reais)

DTO -> Possui as informações nescesarias de alguma entidade

@JoinColumn(name ="tabela") ->
	-OneToOne -> Criar uma coluna na propria entidade
	-OneToMany -> Cria uma coluna na entidade fraca com a chave estrangeria da entidade forte

@JoinTable(name = "") ->
	-ManyToMany -> Cria uma tabela pivot entre duas entidades

@JoinTable(name = tabela, joinColumns=@JoinColumn(name = colun1), inverseJoinColumns=@JoinColumn(name = colun2))