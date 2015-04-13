insert into course values('CS-001', 'Weekly Seminar', 'Comp. Sci.', 0);

insert into section values('CS-001', 1, 'Fall', 2009, null, null, null);

insert into takes (select ID, 'CS-001', 1, 'Fall', 2009, null
					from student
					where dept_name = 'Comp. Sci.');

delete from takes 
where ID = some(select ID
				from student
				where name = 'Chavez') and course_id = 'CS-001' and sec_id = 1 and semester = 'Fall' and year = 2009;

delete from course 
where course_id = 'CS-001';

delete from takes 
where course_id = some(select course_id
						from course
						where lower(title) = '%database%');
