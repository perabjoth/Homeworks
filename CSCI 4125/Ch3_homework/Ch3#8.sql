(select customer_name
from depositor)
except (select customer_name
		from borrower); 

select customer_name
from customer
where (customer_city, customer_street) = some(select customer_city, customer_street
										  from customer
										  where customer_name = 'Smith');

select distinct branch_name
from (((branch natural join account) natural join depositor) natural join customer)
where customer_city = 'Harrison';
