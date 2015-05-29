/*8 -- a**/
--case 1
insert into person values('1223','Ronda Smith','4 Cherr st',70471, 'jane@yahoo.com','female');
insert into job_profile values(2941, 'artist', 'makes pretty things');

insert into knowledge_skill values(8248,'Phyics','A the ability to do Phyics','advanced');
insert into knowledge_skill values(1930,'Advanced math','a ability to do advanced math','advanced');
insert into knowledge_skill values(8233,'Engineering','A the ability to do Engineering work','advanced');

insert into required_skill values(8248,2941);
insert into required_skill values(1930,2941);
insert into required_skill values(8233,2941); 


insert into per_skill values(1223,8248);
insert into per_skill values(1223,1930);
insert into per_skill values(1223,8233);
	/** expected result 2941 for person_id = 1223**/
	/** expected result 2941 for ks_code = 2848, 1930, 8233**/
--case 2
insert into person values('2341','Noah Abdelguerfi','5 Rene Ct.',70471, 'noah@hotmail.com','male');
insert into job_profile values(8293, 'teacher', 'teaches database');

insert into knowledge_skill values(8293,'sofware sk','A the ability program','medium');
insert into knowledge_skill values(9823,'assembly sk','A the ability to do assembly','medium');
insert into knowledge_skill values(3829,'databse sk','A the ability to use a databse','advanced');

insert into required_skill values(8293,8293); 
insert into required_skill values(9823,8293); 
insert into required_skill values(3829,8293); 

insert into per_skill values(2341,8293);
insert into per_skill values(2341,9823);
insert into per_skill values(2341,3829);
	/** expected result 2941 for person_id = 1223**/
	/** expected result 2941 for ks_code = 2848, 1930, 8233**/

/**8 --b **/

insert into person values('2342','Andy Unger','7 sandyadad ln.',9893, 'andy@yahoo.com','female');
insert into company values(7628,'7 Lakeshore dr',86193,'www.oracle.com');
insert into project values(6123,'Dr. Tu',5672,'11-Nov-2003','13-Mar-2004','Tu enterprises');
insert into job_profile values(6262, 'artist', 'makes pretty things');
insert into job values(6262,null,9231,6123,'full-time','1000000','salary');
insert into knowledge_skill values(8923,'welding1','welding skill','medium');
insert into knowledge_skill values(1923,'welding1','welding skill 2','medium');
insert into required_skill values(8923, 6262);
insert into required_skill values(1923, 6262);
--insert into per_skill values(2342, 8923);
insert into per_skill values(2342, 1923);	
insert into course values(1010,'art','3000','art stuff','expired',4000);
insert into skills_covered values(1010,8923);



/**expected result: person 2342 gets hired for job_code 9231**/

insert into person values('8924','Sam Brock','2000 lakeshore dr',23044, 'sdjfgh@dfg.edu','male');
insert into project values(0923,'Dim Sum',3452,'01-Nov-2002','14-Mar-2004','big Brother');
insert into job_profile values(2340, 'mechanic', 'Fixes cars');
insert into job values(2340,null,2478,923 ,'full-time','1000000','salary');
/**expected result: person 8924 gets hired for job_code 2478**/

/**8 --c**/
insert into job_profile values(0001, 'welder', 'welds things');
insert into person values(1119,'Phil Sam','3000 Cherry dr',73293, 'afjaak@dfg.edu','male');

insert into knowledge_skill values(8923,'welding1','welding skill','medium');
insert into knowledge_skill values(1923,'welding1','welding skill 2','medium');
insert into knowledge_skill values(0283,'welding_adv','A the ability to do advanced welding','advanced');
--person missing least skills
insert into required_skill values(8923,0001);
insert into required_skill values(1923,0001);
insert into required_skill values(0283,0001); 

insert into per_skill values(1119,8923);
insert into per_skill values(1119,1923);
insert into per_skill values(1119,0283);
/**expected results: Phil Sam for pos_code = 1 for qualified and most qualified**/

insert into job_profile values(0002, 'driver', 'professional driver');
insert into person values(9381,'Ronny Anderson','3000 Speed ln',88230, 'janfjaofjd@dfg.edu','male');

insert into knowledge_skill values(0923,'stunt driving','how to do stunts','medium');
insert into knowledge_skill values(9823,'drifting','how to drift','medium');
insert into knowledge_skill values(1923,'parallel parking','how to parallel park','advanced');

--person missing least skills
insert into required_skill values(0923,0002);
insert into required_skill values(9823,0002);
insert into required_skill values(1923,0002); 


insert into per_skill values(9381,0923);
insert into per_skill values(9381,9823);
/**expected results: Ronny Anderson for pos_code = 2 for most qualified and no one for qualified**/

/**8 --d**/
--case 1
insert into project values(6123,'Dr. Tu',5672,'11-Nov-2003','13-Mar-2004','Tu enterprises');
insert into job_profile values(9292, 'secratary', 'book work');
insert into job values(9292, null, 1324, 6123, 'full-time', '23451', 'salary');
insert into knowledge_skill values(2934,'general study','study general stuff','medium');
insert into knowledge_skill values(8290,'university study','study about the university','medium');
insert into knowledge_skill values(9023,'art','draw studd','advanced');
insert into required_skill values(2934, 9292);
insert into required_skill values(8290, 9292);
insert into required_skill values(9023, 9292);
insert into course values(8932,'general study','3000','general stuff','expired',5000);
insert into course values(1010,'art','3000','art stuff','expired',4000);

insert into skills_covered values(8932,2934);
insert into skills_covered values(8932,8290);
insert into skills_covered values(1010,9023);
/**expected results for porject_id = 6123: Price = 9000**/
insert into project values(9292,'Dr. Ed',8239,'18-Mar-2003','25-Mar-2004','Tu enterprises');
insert into job_profile values(8382, 'singer', 'singing work');
insert into job values(8382, null, 1324, 9292, 'full-time', '23451', 'salary');
insert into knowledge_skill values(8382,'singing','singing class1','medium');
insert into knowledge_skill values(9282,'singing2','singing class2','medium');
insert into knowledge_skill values(0103,'art','singing3','advanced');

insert into course values(9292,'singing','3000','lern to sing','expired',5000);
insert into course values(1932,'singing 3','3000','advanced singing','expired',5000);

insert into required_skill values(8382,8382);
insert into required_skill values(9282,8382);
insert into required_skill values(0103,8382);


insert into skills_covered values(9292,8382);
insert into skills_covered values(9292,9282);
insert into skills_covered values(1932,0103);
/**expected results for porject_id = 9292: Price = 10000**/

/**8---e**/
--case 1
insert into job_profile values( 8293, 'teacher', 'teaches database');
insert into knowledge_skill values(3829, 'teaching','teach class1', 'medium');
insert into knowledge_skill values(3839, 'teaching','teach class2', 'medium');	
insert into knowledge_skill values(3849, 'teaching','teach class3', 'medium');

insert into required_skill values(3829, 8293);
insert into required_skill values(3839, 8293);
insert into required_skill values(3849, 8293);


insert into person values('0234','Perabjoth Singh Bajwa','5 Rene Ct.',2342, 'pera@hotmail.com','male');
insert into person values('2341','Noah Abdelguerfi','5 Rene Ct.',70471, 'noah@hotmail.com','male');
insert into person values(9381,'Ronny Anderson','3000 Speed ln',88230, 'janfjaofjd@dfg.edu','male');

insert into per_skill values(234, 3829);
insert into per_skill values(234, 3839);
insert into per_skill values(2341, 3829);
insert into per_skill values(2341, 3839);
insert into per_skill values(2341, 3849);
insert into per_skill values(9381, 3849);

	/**expected results: skills training most people: 3829, 3849, 3839 for pos_code = 8293 and missing skills
	=2 **/
--case 2
insert into job_profile values( 8280, 'Engineering', 'mechanical Engineering');
insert into knowledge_skill values(9829, 'advanced math','complex algorithms', 'advanced');
insert into knowledge_skill values(0293, 'physics','physics ks', 'medium');	
insert into knowledge_skill values(3982, 'building','build stuff', 'medium');

insert into required_skill values(9829, 8280);
insert into required_skill values(0293, 8280);
insert into required_skill values(3982, 8280);


insert into person values('0234','Perabjoth Singh Bajwa','5 Rene Ct.',2342, 'pera@hotmail.com','male');
insert into person values('2341','Noah Abdelguerfi','5 Rene Ct.',70471, 'noah@hotmail.com','male');
insert into person values(9381,'Ronny Anderson','3000 Speed ln',88230, 'janfjaofjd@dfg.edu','male');

insert into per_skill values(234, 9829);
insert into per_skill values(234, 0293);
insert into per_skill values(2341, 9829);
insert into per_skill values(2341, 0293);
insert into per_skill values(2341, 3982);
insert into per_skill values(9381, 3982);

	/**expected results: for pos_code = 8280, & missing 1: skill = 3982
	& for missing 2: skill = 3982, 9829, 293**/







	
/*query 21*/
--Ex. 1
insert into job_profile values(6723, 'artist', 'makes pretty things');
--requires
insert into knowledge_skill values(8293,'art','A the ability to do abstract art','medium');
insert into knowledge_skill values(9823,'Graphics sk','A the ability to do computer graphics','medium');
insert into knowledge_skill values(3829,'Gimp skills','A the ability to use Gimp','advanced');
--person missing least skills
insert into required_skill values(8293,6723);
insert into required_skill values(9823,6723);
insert into required_skill values(3829,6723); 
--person
insert into person values(0234,'Jimmy Johnson', '7 Creek ln.', 73820,'Johnson@gmail.com', 'male');

--per_skill
insert into per_skill values(0234,8293);
insert into per_skill values(0234,3829);
/*expected results person_id = 0234, MissSkCnt = 1 for pos_code 234*/

--Ex 2.
insert into job_profile values(4567, 'professor', 'educates people');

insert into person values('2342','Andy Unger','7 sandyadad ln.',9893, 'andy@yahoo.com','female');
insert into person values('4654','Billy Patterson','9 philwood ave',1212, 'jane@yahoo.com','female');

--requires
insert into knowledge_skill values(5601,'Teaching School','How to teach','beginner');
insert into knowledge_skill values(7424,'Advanced class','advanced teaching conceps','medium');
insert into knowledge_skill values(3141,'Math 3423','Multivariable Calc','advanced');


insert into required_skill values(7424,4567);
insert into required_skill values(3141,4567);
insert into required_skill values(5601,4567);

insert into per_skill values(2342,5601);
insert into per_skill values(2342,7424);

insert into per_skill values(4654,5601);
insert into per_skill values(4654,7424);
/* expected results person_id = 2342,4654 MissSkCnt =1 for pos_code 4567*/
------------------------------------------------------------------------------------------------------------
/*query 22*/
--Ex. 1
insert into job_profile values(7394,'rocket science', 'Does rocket science');

insert into person values('2341','Noah Abdelguerfi','5 Rene Ct.',70471, 'noah@hotmail.com','male');
insert into person values('1223','Ronda Smith','4 Cherr st',70471, 'jane@yahoo.com','female');


insert into knowledge_skill values(8248,'Phyics','A the ability to do Phyics','advanced');
insert into knowledge_skill values(1930,'Advanced math','a ability to do advanced math','advanced');
insert into knowledge_skill values(8233,'Engineering','A the ability to do Engineering work','advanced');
insert into knowledge_skill values(1984,'algorithms','A the ability to do advanced algorithms','advanced');
insert into knowledge_skill values(8320 ,'Writing','A the ability to write','advanced');


insert into required_skill values(8248,7394);
insert into required_skill values(1930,7394);
insert into required_skill values(8233,7394);
insert into required_skill values(1984,7394);
insert into required_skill values(8320,7394);

/*missing 1 list for 7394*/
insert into per_skill values(2341,8248);
insert into per_skill values(2341,1930);
insert into per_skill values(2341,8233);
insert into per_skill values(2341,1984);

insert into per_skill values(1223,8248);
insert into per_skill values(1223,1930);
insert into per_skill values(1223,8233);
insert into per_skill values(1223,8320);
--expected results 2341,1223

/*missing 2 list*/
insert into person values('9800','Linda James','9 seder ave',7980, 'linda@yahoo.com','female');
insert into person values('9818','Mary Jane','10 sederwood ave',1212, 'jane@yahoo.com','female');
insert into person values('4353','Phil Dawson','7 Pinewood dr.',7980, 'pdawson@gmail.com','male');

insert into per_skill values(9800,8320);
insert into per_skill values(9800,1984);
insert into per_skill values(9800,1930);

insert into per_skill values(9818,8248);
insert into per_skill values(9818,8233);
insert into per_skill values(9818,1984);

insert into per_skill values(4353,8320);
insert into per_skill values(4353,1930);
insert into per_skill values(4353,8248);
--expected results 2341,1223,9800,9818,4353
-----------------------------------------------------------------------------------------------------------------------------------
/*query 23*/
--Ex. 1


For position 7394 for missing 1 should be
ks_code: 8320 count_people: 1
ks_code: 1984 count_people: 1

--double check
For position 7394 for missing 2 should be
Ks_code: 8248 count_people: 1
Ks_code: 1930 count_people: 1

Ks_code: 8320 count_people: 2
ks_code: 1984 count_people: 2
ks_code: 8233 count_people: 2

/*query 24*/
--test case 1
insert into project values(6123,'Dr. Tu',5672,'11-Nov-2003','13-Mar-2004','Tu enterprises');
insert into person values('1223','Ronda Smith','4 Cherr st',70471, 'jane@yahoo.com','female');
insert into job_profile values(7394,'rocket science', 'Does rocket science');
insert into job_profile values(6723, 'artist', 'makes pretty things');
insert into job_profile values(6262, 'b-ball player','shoot hoops');
insert into knowledge_skill values(1930,'Advanced math','a ability to do advanced math','advanced');
insert into knowledge_skill values(3141,'Math 3423','Multivariable Calc','advanced');

insert into job values(7394,null,7394,6123,'full-time','1000000','salary');
insert into job values(7394,null,3423,6123,'full-time','1000000','salary');
insert into job values(7394,null,9323,6123,'full-time','1000000','salary');
insert into job values(7394,null,1039,6123,'full-time','1000000','salary');
insert into job values(7394,null,8103,6123,'full-time','1000000','salary');

insert into job values(6262,null,2304,6123,'full-time','1000000','salary');
insert into job values(6262,null,0002,6123,'full-time','1000000','salary');
insert into job values(6262,null,0923,6123,'full-time','1000000','salary');
insert into job values(6262,null,8399,6123,'full-time','1000000','salary');
insert into job values(6262,null,3214,6123,'full-time','1000000','salary');
insert into job values(6262,null,9274,6123,'full-time','1000000','salary');
insert into job values(6262,null,9239,6123,'full-time','1000000','salary');

insert into required_skill values(1930, 6262);
insert into required_skill values(3141, 6262);
insert into per_skill values(1223, 1930);
insert into per_skill values(1223, 3141);

/*expected results person_id: 6262 ppl_cnt = 1*/
--test case 2


insert into knowledge_skill values(9945,'Basic Algebra','A the ability to do basic algebra','beginner');
insert into knowledge_skill values(9284,'Basic Welding','a ability to do basic welding','medium');
insert into knowledge_skill values(3849,'Safty Training','A the ability to be safe in the work enviroment','advanced');
insert into job_profile values(9999, 'doctor', 'heals people');




insert into person values('1226','Larry Hanes','18 Cherr st',70471, 'ajfnjanf@yahoo.com','male');
insert into person values('1227','Phil Juan','18 Cherr st',70471, 'ajfnjanf@yahoo.com','male');



insert into project values(1236,'Christopher Summa',6123,'17-Jan-2015','02-May-2015','UNO');

insert into required_skill values(9945,9999);
insert into required_skill values(9284,9999);
insert into required_skill values(3849,9999);



insert into per_skill values(1226,9945);
insert into per_skill values(1226,9284);
insert into per_skill values(1226,3849);
insert into per_skill values(1227,9945);
insert into per_skill values(1227,9284);
insert into per_skill values(1227,3849);

insert into job values(9999,null,9302,1236,'full-time','1000000','salary');
insert into job values(9999,null,0931,1236,'full-time','1000000','salary');
insert into job values(9999,null,8472,1236,'full-time','1000000','salary');
insert into job values(9999,null,3203,1236,'full-time','1000000','salary');
insert into job values(9999,null,8392,1236,'full-time','1000000','salary');
insert into job values(9999,null,8273,1236,'full-time','1000000','salary');
insert into job values(9999,null,0938,1236,'full-time','1000000','salary');
insert into job values(9999,null,8938,1236,'full-time','1000000','salary');
insert into job values(9999,null,9393,1236,'full-time','1000000','salary');
/* expected results pos_code:9999 ppl_cnt: 2*/
/*query 25*/
insert into course values('2125','data stuctures','3000','class that covers major data stuctures','expired',750);
insert into course values('2107','calculus 1','2000','intro into calculus 1','active',500);
insert into course values('2108','calculus 2','3000','calculus 2 mathematics','expired',600);


insert into skills_covered values(2125,1930);
insert into skills_covered values(2125,3141);
insert into skills_covered values(2107,9945);
insert into skills_covered values(2107,9284);
insert into skills_covered values(2108,9284);
insert into skills_covered values(2108,3849);
/* expected results c_code: 2107, 2108*/


insert into skills_covered values(2125, 3849);
delete from skills_covered where ks_code in (9945, 9284) and c_code = 2107;
/*expected results c_code: 2108, 2125 */




