select employee_name
from works
where company_name = 'First Bank Corporation';

select employee_name
from (employee natural join works) join company using (company_name)
where company.city = employee.city;


select employee_name
from employee, (select employee_name as manager_name, city as manager_city, street as manager_street
				from employee
				where employee_name = some(select manager_name
							from manager))
where city = manager_city and street = manager_street and (employee_name, manager_name) in (select employee_name, manager_name 
																							from manages);

select employee_name
from works natural join (select company_name, avg(salary) as avg_salary
						from works
						group by company_name)
where salary > avg_salary;

select company_name
from (select company_name, min(total_salary)
	  from (select company_name, sum(salary) as total_salary
		    from works
			group by company_name));

