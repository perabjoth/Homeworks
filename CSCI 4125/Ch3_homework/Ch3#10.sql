update employee
set city = 'Newtown'
where employee_name = 'Jones';

update (select employee_name, salary
		from works
		where employee_name in (select employee_name
								from manages)
set salary = case
				when salary > 100000 then salary*1.1
				else salary*1.03
			end;
