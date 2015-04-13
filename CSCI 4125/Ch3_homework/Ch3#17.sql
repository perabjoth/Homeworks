update works
set salary = salary*1.1
where company_name  = 'First Bank Corporation';

update works
set salary = salary*1.1
where company_name = 'First Bank Corporation' and employee_name = some(select manager_name 
from manages);

delete from works
where company_name = 'Small Bank Corporation';

