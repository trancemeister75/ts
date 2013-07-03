﻿create table Catalogo_Producto (ID_Producto varchar(25) not null unique, Stock int4 not null, Area_Responsable varchar(255), ID_Proveedor varchar(12) not null);
create table Catalogo_Proveedor (ID_Proveedor varchar(12) not null unique, Tipo_Proveedor int4 not null unique, Descripcion varchar(255), primary key (ID_Proveedor, Tipo_Proveedor));
create table Servicio (ID_Servicio varchar(25) not null, Concepto varchar(40) not null, Descripcion varchar(255), EsFacturable int4 default 0 not null, primary key (ID_Servicio));
create table Nota (Fecha_Emision date not null, ID_Nota  serial not null, Importe_Total float8 not null, Tipo_Nota varchar(10) not null, Status varchar(10) not null, ClienteID_Cliente varchar(25) not null, primary key (ID_Nota));
create table T_Nota (Tipo_T varchar(10) not null, T_Char varchar(30) not null, ID_Tran int4 not null, Precio_T float8 not null, Cantidad int4, NotaID_Nota int4 not null, Char_Val_S varchar(25) not null, ProductoID_Producto varchar(25), primary key (ID_Tran));
create table Cliente (ID_Cliente varchar(25) not null, Nombre varchar(25) not null, Apellido_Paterno varchar(25) not null, Apellido_Materno varchar(25) not null, Direccion varchar(50) not null, Telefono varchar(15) not null, Email varchar(25) not null, primary key (ID_Cliente));
create table Producto (Nombre varchar(40) not null, Descripcion varchar(255) not null, ID_Marca int4 not null, ID_Producto varchar(25) not null, Categoria varchar(25), primary key (ID_Producto));
create table Proveedor (Nombre varchar(40) not null unique, RFC varchar(12) not null, "Domicilio Fiscal" varchar(255), Telefono int4, primary key (RFC));
create table Personal (IdUsuario varchar(50) not null, Nombre varchar(25) not null, Apellido_Paterno varchar(25) not null, Apellido_Materno varchar(25) not null, Direccion varchar(255) not null, Telefono varchar(25) not null, "E-Mail" varchar(25) not null, Tipo_Personal varchar(5) not null, primary key (IdUsuario));
create table Meta (IdUsuario varchar(50) not null, Ano int4 not null, Mes int4 not null, Descripcion varchar(50) not null, Meta int4 not null, Status varchar(10) not null);
create table Usuario (Username varchar(50) not null, Password varchar(20), Rol varchar(15) not null, primary key (Username));
alter table Nota add constraint FKNota838827 foreign key (ClienteID_Cliente) references Cliente;
alter table T_Nota add constraint FKT_Nota922466 foreign key (NotaID_Nota) references Nota;
alter table T_Nota add constraint FKT_Nota894777 foreign key (Char_Val_S) references Servicio;
alter table T_Nota add constraint FKT_Nota591809 foreign key (ProductoID_Producto) references Producto;
alter table Catalogo_Producto add constraint FKCatalogo_P475521 foreign key (ID_Proveedor) references Proveedor;
alter table Catalogo_Producto add constraint FKCatalogo_P875463 foreign key (ID_Producto) references Producto;
alter table Catalogo_Proveedor add constraint FKCatalogo_P366761 foreign key (ID_Proveedor) references Proveedor;
alter table Usuario add constraint FKUsuario428010 foreign key (Username) references Personal;
alter table Meta add constraint FKMeta779695 foreign key (IdUsuario) references Personal;