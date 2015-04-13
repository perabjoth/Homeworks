select customer_name
from (select customer_name, count(branch_name) as branch_num
		from ((depositor natural join account) natural join branch)
		where branch_city = 'Brooklyn'
		group by customer_name)
where branch_num = (select count(branch_name)
					from branch
					where branch_city = 'Brooklyn');

select sum(amount)
from loan;

select branch_name
from branch
where assets > (select min(assets)
				from branch
				where branch_city = 'Brooklyn');
