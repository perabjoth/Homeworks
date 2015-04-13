select distinct name
from (student natural join takes) join course using(course_id)
where course.dept_name = 'Comp. Sci.';

select ID, name
from takes natural join student
where year > 2008;

select max(salary)
from instructor
group by dept_name;

select min(max_salary)
from (select max(salary) as max_salary
	  from instructor
	  group by dept_name);
