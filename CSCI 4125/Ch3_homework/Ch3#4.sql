select count(distinct driver_id)
from participated natural join accident
where date = 2009;

insert into accident values (1354354, 2015, 'New Orleans');

delete from owns
where driver_id = some(select driver_id
					from (car natural join owns) natural join person
					where model = 'Mazda' and name = 'John Smith');
