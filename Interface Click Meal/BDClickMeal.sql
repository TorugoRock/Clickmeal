
create database bancoDados;
use bancoDados;

create table Receita (
      idReceita int auto_increment Primary key,
      nomeReceita varchar(45),
      modoPrepraro varchar (2000),
      compatibilidade int,
      cont_ingred int
     
);
create table Ingrediente (
	idIngrediente int auto_increment Primary key,
	nomeIngrediente varchar(45) 
       
   
);

create table Composicao (
	codReceita int ,
	codIngrediente int ,
	quant varchar (45),
	Primary key (codReceita,codIngrediente),
        foreign key (codReceita) references receita(idReceita),
	foreign key (codIngrediente) references Ingrediente (idIngrediente)
    
);