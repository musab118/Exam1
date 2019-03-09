create table server (
  id serial not null primary key,
  name varchar(20),
  location varchar(120),
  replacement_cost decimal(13,4),
  running_cost decimal(13,4)

)