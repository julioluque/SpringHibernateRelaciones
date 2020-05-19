Instrucciones MYSQL

create table DETALLES_CLIENTE (
DET_ID int (11) not null auto_increment,
DET_WEB varchar(128) default null,
DET_TELEFONO varchar(128) default null, 
DET_COMENTARIOS varchar(128) default null,
primary key (DET_ID)) ENGINE = INNODB

create table CLIENTE (
CLI_ID int (11) not null auto_increment,
CLI_NOMBRE varchar(128) default null,
CLI_APELLIDO varchar(128) default null, 
CLI_DIRECCION varchar(128) default null,
primary key (CLI_ID)) ENGINE = INNODB

alter table CLIENTE 
add constraint fk_detalles 
foreign key (CLI_ID) 
references DETALLES_CLIENTE(DET_ID) 
on delete no action 
on update no action