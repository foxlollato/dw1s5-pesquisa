create table usuario(
nome varchar(40),
email varchar(40) primary key,
senha varchar(40)
);

--Inserindo Admin ativo. email: admin1 senha: 123
insert into usuario values('admin', 'admin1', '202CB962AC59075B964B07152D234B70');

create table candidato(
nome varchar(40),
cpf varchar(40) primary key,
foto varchar(256),
cv varchar(256)
);

commit;
