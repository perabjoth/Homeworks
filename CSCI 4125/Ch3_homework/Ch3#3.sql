update instructor
set salary = salary * 1.1
where dept_name = 'Comp. Sci.';

delete from course
where course_id not in (select course_id
						from section);

insert into instructor
select ID, name, dept_name, 10000
from student
where tot_cred > 100;


