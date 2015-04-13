select course_id
from course
where dept_name = 'Comp. Sci.' and credits = 3;

select distinct takes.ID
from takes join teaches using(course_id, sec_id, semester, year)
where teaches.ID = some(select ID
					from instructor
					where name = 'Einstein');

select max(salary)
from instructor;

select name 
from instructor
where salary = max(salary);

select sec_id, count(ID)
from takes
where semester = 'Fall' and year = 2009
group by sec_id;

select max(count(ID))
from takes
where semester = 'Fall' and year = 2009
group by sec_id;

select T.sec_id
from takes as T
where semester = 'Fall' and year = 2009 
group by T.sec_id
having count(T.ID) = (select max(count(S.ID))
						from takes as S
						where semester = 'Fall' and year = 2009
						group by sec_id);


