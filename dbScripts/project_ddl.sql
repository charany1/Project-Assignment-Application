DROP TABLE IF EXISTS project;
CREATE TABLE  project (
				id INTEGER NOT NULL AUTO_INCREMENT,
				name VARCHAR(30) NOT NULL,
				has_project_manager BOOLEAN NOT NULL DEFAULT 0 ,
                PRIMARY KEY(id)
                )ENGINE=InnoDB AUTO_INCREMENT=1;
                
                
                
  
                
===========
sample data to insert
===========

insert into project(name,has_project_manager) values('tomtom',1);
insert into project(name) values('pompom');
select * from project;