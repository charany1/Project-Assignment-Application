/*
Quries for listing project and staff for requirement (e).
*/

#First , get maximum id from project : that gives  total number of projects,store it in a field .
select max(id) from project;
#For id = 1:max_id ,execute belpow query
select project_id,project_name,result.employee_id,employee.name as employee_name,role from(select project.id as project_id,project.name as project_name,employee_id from project left join project_employee on project.id=project_employee.project_id
) as result left join 
employee on employee.id = result.employee_id where project_id = 1 ;