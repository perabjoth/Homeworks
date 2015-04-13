	select employee_name, city
from employee natural join works
where company_name = 'First Bank Corporation';

select employee_name, street, city
from employee natural join works
where company_name = 'First Bank Corporation' and salary > 10000;

(select employee_name
from employee)
except (select employee_name
		from employee natural join works
		where company_name = 'First Bank Corporation');

select employee_name
from employee natural join works
where salary > (select max(salary)
				from employee natural join works
				where company_name = 'Small Bank Corporation');

select company_name
from company
where city = some(select city
				from company
				where company_name = 'Small Bank Corporation');

select company_name
from works natural join employee
group by company_name
having count(employee_name) = max(count(employee_name));

select company_name
from (select company_name, avg(salary) as avg_salary
	  from company
	  group by company_name)
where avg_salary > (select avg_salary
					from (select company_name, avg(salary) as avg_salary
						  from company
						  group by company_name)
					where company_name = 'First Bank Corporation');
