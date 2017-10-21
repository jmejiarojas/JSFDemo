//La BD se llama crud

create sequence seq_personas
  minvalue 1
  maxvalue 1000
  increment by 1;

   create table public.persona(
  id integer not null default nextval('seq_personas'),
  nombres varchar(30),
  apellidos varchar(30),
  foto bytea,
  primary key (id)
 );


  create sequence seq_telefono
  minvalue 1
  maxvalue 1000
  increment by 1;

   create table public.telefono(
  id integer not null default nextval('seq_telefono'),
  numero varchar(30),
  idPersona integer references public.persona(id),
  primary key (id)
 );
