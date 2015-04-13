select sum(points)
from takes natural join grade_points
where ID = 12345
group by ID;

select sum(points)/sum(credits)
from (takes natural join grade_points) join course using(course_id)
where ID = 12345
group by ID;

select ID, sum(points)/sum(credits)
from (takes natural join grade_points) join course using(course_id)
group by ID;

