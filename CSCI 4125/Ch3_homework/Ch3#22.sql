select title
from course 
group by title
having count(*) between 0 and 1;
