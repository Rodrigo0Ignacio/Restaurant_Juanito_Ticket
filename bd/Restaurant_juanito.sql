create database Restaurant_juanito
use Restaurant_juanito

/*TABLAS*/

create table usuario(
rut_usuario varchar(15) NOT NULL,
user_nombre varchar(100) NOT NULL,
password varchar(100) NOT NULL,
CONSTRAINT PK_usuario PRIMARY KEY (rut_usuario)
)

create table categoria(
id_cat int IDENTITY(1,1) NOT NULL,
categoria varchar(100) NOT NULL,
CONSTRAINT PK_categoria PRIMARY KEY (categoria)
)

create table comida(
id_comida int IDENTITY(1,2) NOT NULL,
categoria varchar(100) NOT NULL,
nombre varchar(100) NOT NULL,
precio decimal NOT NULL,
descripcion varchar(200) NULL,
CONSTRAINT PK_comida PRIMARY KEY (id_comida)
)

create table informe(
id_informe int IDENTITY(1,3) NOT NULL,
fecha datetime NOT NULL,
id_user varchar(15) NOT NULL,
id_venta int NOT NULL,
valor_total decimal NOT NULL,
propina_total decimal NOT NULL,
CONSTRAINT PK_informe PRIMARY KEY (id_informe)
)

create table venta(
id_venta int IDENTITY(1,11) NOT NULL,
id_usuario varchar(15) NOT NULL,
id_comida int NOT NULL,
num_mesa int NOT NULL,
fecha smalldatetime NOT NULL,
CONSTRAINT PK_ticket PRIMARY KEY (id_venta)
)

/*LLAVES FORANEAS*/
/*comida --> categoria*/
alter table comida
ADD CONSTRAINT FK_comida FOREIGN KEY (categoria) REFERENCES categoria (categoria)
ON DELETE CASCADE
ON UPDATE CASCADE



/*venta --> comida Y venta --> usuario*/
alter table venta ADD 
CONSTRAINT FK_ticket FOREIGN KEY (id_usuario) REFERENCES usuario (rut_usuario),
CONSTRAINT FK2_ticket FOREIGN KEY (id_comida) REFERENCES comida (id_comida)
ON DELETE CASCADE
ON UPDATE CASCADE

/*informe --> usuario Y informe --> comida Y informe --> tikect*/
alter table informe ADD 
CONSTRAINT FK_informe FOREIGN KEY (id_user) REFERENCES usuario (rut_usuario),
CONSTRAINT FK2_informe FOREIGN KEY (id_venta) REFERENCES venta (id_venta)
ON DELETE CASCADE
ON UPDATE CASCADE

SELECT * FROM categoria
SELECT * FROM usuario
select * from comida
select * from venta
select * from informe

/*Precedimientos Almacenados*/
alter procedure listarInforme
(
@fechaInicio datetime,
@fechaTermino datetime,
@rut_usuario varchar(15)
)
AS
BEGIN
SELECT nombre, precio, id_usuario, num_mesa, fecha FROM comida INNER JOIN venta ON comida.id_comida = venta.id_comida
WHERE venta.fecha >= @fechaInicio AND venta.fecha <= @fechaTermino AND venta.id_usuario = @rut_usuario
END
/*Ejemplo*/
EXEC listarInforme '15/10/2021 00:00:00','15/10/2021 09:00:00','19405196-4'




