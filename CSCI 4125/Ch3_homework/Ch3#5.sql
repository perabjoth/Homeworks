alter table marks add grade char(1);

update marks
set grade = case when score between 0 and 39 then 'F'
			when score between 40 and 59 then 'C'
			when score between 60 and 79 then 'B'
			else 'A'
			end;

select ID, grade
from marks;

select count(ID), grade
from marks
group by grade;
