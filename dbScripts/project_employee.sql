


CREATE TABLE project_employee(
										  project_id INTEGER NOT NULL,
										  employee_id INTEGER NOT NULL,
										  CONSTRAINT FK1 FOREIGN KEY (project_id) REFERENCES project(id),
										  CONSTRAINT FK2 FOREIGN KEY (employee_id) REFERENCES employee(id),
                                          PRIMARY KEY(project_id,employee_id));
					
DESCRIBE project_employee;


==========
sample data to insert
==========
insert into project_employee values(2,2);
insert into project_employee values(1,2);
