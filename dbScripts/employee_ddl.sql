DROP TABLE IF EXISTS employee;

CREATE TABLE IF NOT EXISTS employee (
								id INTEGER NOT NULL AUTO_INCREMENT,
								name VARCHAR(30) NOT NULL,
								email  VARCHAR(50) NOT NULL,
								role INTEGER NOT NULL,
                                PRIMARY KEY (id) )ENGINE=InnoDB AUTO_INCREMENT=1;
                                
                               
 ====================
 sample data to insert
 ====================
insert into employee(name,email,role) values('yog','yog@gmail.com',1);
insert into employee(name,email,role) values('rahul','rahul@gmail.com',0);
select * from employee;