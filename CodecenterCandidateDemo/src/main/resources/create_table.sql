CREATE TABLE  inputdata (
  id int(10) unsigned not null auto_increment primary key,
  firstname varchar(30) not null,
  lastname varchar(30) not null,
  gender varchar(10) not null,
  description varchar(2000) not null
) ENGINE=InnoDB;