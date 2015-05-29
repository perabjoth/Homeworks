--knowledge_skill
insert into knowledge_skill values(3489,'very skillful person', 'This person would be a dream hire', 'advanced');
insert into knowledge_skill values(8234,'killing', 'killer', 'beginner');
insert into knowledge_skill values(2348,'teacher', 'english', 'advanced');
insert into knowledge_skill values(2394,'criminal justice', 'detective', 'medium');
insert into knowledge_skill values(0394,'basketball', 'shooting guard', 'advanced');
insert into knowledge_skill values(0328,'Teaching School','How to teach','beginner');
insert into knowledge_skill values(5601,'Advanced teaching class','advanced teaching conceps','medium');
insert into knowledge_skill values(3141,'Math 3423','Multivariable Calc','advanced');
-----------------------------------------------------------------------------------------------------
insert into knowledge_skill values(8293,'Abstract art','A the ability to do abstract art','medium');
insert into knowledge_skill values(7424,'Advanced class','advanced teaching conceps','medium');
insert into knowledge_skill values(3829,'Gimp skills','A the ability to use Gimp','advanced');

insert into knowledge_skill values(8248,'Phyics','A the ability to do Phyics','advanced');
insert into knowledge_skill values(1930,'Advanced math','a ability to do advanced math','advanced');
insert into knowledge_skill values(8233,'Engineering skill','A the ability to do Engineering work','advanced');
insert into knowledge_skill values(1984,'Advanced algorithms','A the ability to do advanced algorithms','advanced');
insert into knowledge_skill values(7328,'Writing','A the ability to write','advanced');
-----------------------------------------------------------------------------------------------------
--job_profile
insert into job_profile values(6262, 'b-ball player','shoot hoops');
insert into job_profile values(1234, 'security guard', 'protects people');
insert into job_profile values(4567, 'professor', 'educates people');
insert into job_profile values(7892, 'cop', 'upholds the law');
-----------------------------------------------------------------------------------------------------
insert into job_profile values(6723, 'artist', 'makes pretty things');
insert into job_profile values(7394,'rocket scientists', 'Does rocket science');
-----------------------------------------------------------------------------------------------------
--required_skill
insert into required_skill values(3489,6723);
insert into required_skill values(8234,1234);
insert into required_skill values(2348,4567);
insert into required_skill values(2394,7892);
insert into required_skill values(0394,6262);
-----------------------------------------------------------------------------------------------------
insert into required_skill values(4567,0328);
insert into required_skill values(4567,5601);
insert into required_skill values(4567,3141);

insert into required_skill values(8293,6723);
insert into required_skill values(5601,7424);
insert into required_skill values(3141,6723);

insert into required_skill values(8248,7394);
insert into required_skill values(1930,7394);
insert into required_skill values(8233,7394);
insert into required_skill values(1984,7394);
insert into required_skill values(7328,7394);
-----------------------------------------------------------------------------------------------------

--project
insert into project values(6123,'Dr. Tu',5672,'11-Nov-2003','13-Mar-2004','Tu enterprises');
insert into project values(5236,'Noah Abdleguerfi', 7232,'04-Feb-2010', '15-Mar-2010', 'Noah and Sons');
insert into project values(3214,'Perabjoth Singh Bajwa', 3470, '30-Apr-1995', '30-Apr-2015', 'Pera and Co.');
insert into project values(3423, 'Barack Husein Obama', 9231,'15-May-2010','17-Apr-2016','USA');
insert into project values(1236,'Christopher Summa',6123,'17-Jan-2015','02-May-2015','UNO');
--course
insert into course values('1583','java programming', '1000', 'Intro into java sofware programming. This class will teach use object oriented programming', 'active',500);
insert into course values('2120','java 2 programming','2000','The second sofware programming class','active', 634);
insert into course values('2125','data stuctures','3000','class that covers major data stuctures','expired',750);
insert into course values('2107','calculus 1','2000','intro into calculus 1','active',500);
insert into course values('2108','calculus 2','3000','calculus 2 mathematics','expired',600);
--skills_covered
insert into skills_covered values(1583,8234);
insert into skills_covered values(2120,2348);
insert into skills_covered values(2125,3489);
insert into skills_covered values(2107,0394);
insert into skills_covered values(2108,2394);
--person 
insert into person values('0234','Perabjoth Singh Bajwa','5 Rene Ct.',2342, 'pera@hotmail.com','male');
insert into person values('2341','Noah Abdelguerfi','5 Rene Ct.',70471, 'noah@hotmail.com','male');
insert into person values('4353','Phil Dawson','7 Pinewood dr.',7980, 'pdawson@gmail.com','male');
insert into person values('9818','Mary Jane','10 sederwood ave',1212, 'jane@yahoo.com','female');
insert into person values('1223','Ronda Smith','4 Cherr st',70471, 'jane@yahoo.com','female');
insert into person values('4654','Billy Patterson','9 philwood ave',1212, 'jane@yahoo.com','female');
insert into person values('1226','Larry Hanes','18 Cherr st',70471, 'ajfnjanf@yahoo.com','male');
insert into person values('9800','Linda James','9 seder ave',7980, 'linda@yahoo.com','female');
insert into person values('9989','Gary Anderson','9 Cherrdaad st',7978, 'gary@yahoo.com','male');
insert into person values('9808','Gabe oadioa','9 jane ave',1212, 'gabe@yahoo.com','male');
insert into person values('1229','Sandra Aakjndja','7 sandy ln.',70471, 'sandra@yahoo.com','female');
insert into person values('2342','Andy Unger','7 sandyadad ln.',9893, 'andy@yahoo.com','female');
--phone_number
insert into phone_number values(0234,6234512789);
insert into phone_number values(9800,1223456789);
insert into phone_number values(1229,3245768219);
insert into phone_number values(2342,2342234223);
insert into phone_number values(1226,6972726666);
--job
insert into job values(6262,0234,9234,6123,'full-time','1000000','salary');
insert into job values(1234,2341,6219,5236,'part-time','20','wage');
insert into job values(4567,4353,7234,3214,'part-time','50','wage');
insert into job values(7892,9800,9238,3423,'full-time','72000','salary');
insert into job values(6723,4654,6219,1236,'part-time','21','wage');
--section
insert into section values('1583','01','2015','Fall');
insert into section values('1583','01','2008','Spring');
insert into section values('1583','01','2008','Summer');
insert into section values('1583','01','2015','Spring');
insert into section values('2120','01','2015','Fall');
insert into section values('2120','02','2008','Spring');
insert into section values('2120','03','2008','Summer');
insert into section values('2120','01','2015','Spring');
insert into section values('2125','05','2015','Fall');
insert into section values('2125','02','2010','Spring');
insert into section values('2125','03','2009','Summer');
insert into section values('2125','01','2007','Spring');
--student_schedule
insert into student_schedule values(2341,1583,01,2008,'Fall');
insert into student_schedule values(1226,2125,03,2009,'Summer');
insert into student_schedule values(4654,2120,01,2015,'Spring');
insert into student_schedule values(2342,2120,01,2015,'Fall');
insert into student_schedule values(9818,1583,01,2015,'Spring');
--per_skill
insert into per_skill values(0234,8234);
insert into per_skill values(2341,2394);
insert into per_skill values(1223,0394);
insert into per_skill values(9818,2348);
insert into per_skill values(4654,3489);
insert into per_skill values(0234,5601);
insert into per_skill values(0234,5601);
--company
insert into company values(1236,'2000 lakeshore dr.',70148);
insert into company values(5623,'grande isle',53284);
insert into company values(7228,'empire state',32889);
insert into company values(7645,'New Orleans',70130);
insert into company values(5692,'Jamaica', 98234);
--specialty
insert into specialty values(1236,'construction');
insert into specialty values(5623,'software');
insert into specialty values(7228,'IT consulting');
insert into specialty values(7645,'transportation');
insert into specialty values(5692,'logistics service');
--company_funds
insert into company_funds values(1236,5236);
insert into company_funds values(5623,6123);
insert into company_funds values(7228,3214);
insert into company_funds values(7645,3423);
insert into company_funds values(5692,1236);
--company_hires
insert into company_hires values(6262,1236);
insert into company_hires values(1234,5623);
insert into company_hires values(4567,7228);
insert into company_hires values(7892,7645);
insert into company_hires values(6723,5692);