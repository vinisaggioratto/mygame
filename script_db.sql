-- create database mygame_db;
use mygame_db;

create table category(
id int not null primary key auto_increment, -- id da categoria
name_category varchar(256) not null -- nome da categoria
);

create table platform(
id int not null primary key auto_increment, -- id da plataforma
name_platform varchar(256) not null -- nome da plataforma
);

create table game (
id int not null primary key auto_increment, -- id do jogo
name_game varchar(256) not null, -- nome do jogo
acquisition_date date not null, -- data de aquisição
buy_price double not null, -- preço de compra
media_type varchar(32) not null, -- tipo de midia
platform_id int not null, -- i da plataforma
category_id int not null, -- id da categoria
sold varchar(3) not null, -- vendido
borrowed varchar(3) not null, -- emprestado
observation varchar(256), -- observações
foreign key(category_id) references category(id),
foreign key(platform_id) references platform(id)
);