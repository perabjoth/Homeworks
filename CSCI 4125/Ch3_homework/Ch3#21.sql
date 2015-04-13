select name
from (member natural join borrowed) natural join book
where publisher = 'McGraw-Hill';

select name
from (select memb_no, sum(isbn) as sum_isbn
	  from member natural join borrowed
	  group by memb_no) natural join member
where sum_isbn = some(select sum(isbn)
			          from book
			          where publisher = 'McGraw-Hill');

select name  
from book,member,borrowed  
where borrowed.memb_no = member.memb_no and book.isbn = borrowed.isbn and borrowed.isbn in (select publisher, count(borrowed.isbn)   
																							from borrowed ,  book
																							where borrowed.isbn = book.isbn   
																							group by publisher   
																							having count(*) > 5);

select count(memb_no)/(select count(memb_no)
						from member)
from borrowed;

