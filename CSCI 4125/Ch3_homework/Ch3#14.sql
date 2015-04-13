select count(report_number)
from participated natural join person
where name = 'John Smith';

update participated
set damage_amount  = 3000
where license = 'AABB2000' and report_number = 'AR2197';

