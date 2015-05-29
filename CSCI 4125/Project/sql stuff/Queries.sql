
/*query 1 works*/

SELECT name
FROM person natural join company_hires natural join job
WHERE comp_id = '3411';


/*query 2 works*/

select name, pay_rate
from person natural join company_hires natural join job
where comp_id = '3411' and pay_type = 'salary'
order by pay_rate DESC;

/*query 3 works*/

with SALARY AS (select comp_id, sum(pay_rate) as worker_salary
from job natural join company_hires
where pay_type = 'salary'
group by comp_id),
WAGE AS (select comp_id, sum(pay_rate*1920) as worker_salary
from job natural join company_hires
where pay_type = 'wage'
group by comp_id),
salary_wage as(
(select * from SALARY) union (select * from WAGE) 
)
select comp_id,sum(worker_salary) as total_worker_cost
from salary_wage 
group by comp_id
order by total_worker_cost DESC;

/*query 4- works*/

select job_code
from person natural join job
where person_id = '1229';


/*query 5 - works*/

select distinct person_id
from project natural join job
where project_id = '3233';

/*query 6 - works*/

select ks_code
from per_skill
where person_id = '9800';


/*query 7 works*/

(select ks_code 
from required_skill natural join job
where person_id = '2342')
minus
(select ks_code
from per_skill
where person_id = '2342');

/*query 8 works*/

select ks_code
from required_skill
where pos_code = '3233';

/*query 9 works*/

(select ks_code 
from required_skill natural join job
where  pos_code = '3233')
minus
(select ks_code
from per_skill
where person_id = '2342');

/*query 10 works uppdated*/
select distinct s.c_code
from skills_covered s
where not exists(
(select ks_code from knowledge_skill where ks_code in (1967, 1876))
minus
(select ks_code
from course natural join skills_covered
where s.c_code = c_code));



/*query 11*/

with needed as((
  select RS.ks_code 
  from required_skill RS
  where RS.pos_code = '1231')
minus(
  select ks_code
  from per_skill
  where person_id = '4654'))
select distinct c_code, title
from course s 
where not exists(
(select ks_code from needed)
minus
(select ks_code
from course natural join skills_covered
where s.c_code = c_code));

/*query 12*/ 
with missing_skills as(
(select ks_code 
from required_skill                       
where pos_code = '1231')
minus
(select ks_code
from person natural join per_skill
where person_id = '4654')),
course_needed as(
select distinct c_code, title
from course s 
where not exists(
(select ks_code from missing_skills)
minus
(select ks_code
from course natural join skills_covered
where s.c_code = c_code)))
select c_code, comp_date
from course_needed natural join section
where comp_date = (select min(comp_date)
from course_needed natural join section group by c_code );    
--13

CREATE SEQUENCE CourseSet_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE;
CREATE  TABLE CourseSet (
csetID NUMBER(8, 0) PRIMARY KEY,
c_code1 NUMBER(6, 0), c_code2 NUMBER(6, 0), c_code3 NUMBER(6, 0),
num NUMBER(2, 0) 
);

INSERT INTO CourseSet
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, null, 2
FROM Course C1, Course C2
WHERE C1.c_code < C2.c_code;

INSERT INTO CourseSet
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, C3.c_code, 3
FROM Course C1, Course C2, Course C3
WHERE C1.c_code < C2.c_code AND C2.c_code < C3.c_code;

WITH CourseSet_Skill(csetID, ks_code) AS (
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code1=CS.c_code
UNION
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code2=CS.c_code
UNION
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code3=CS.c_code),
missing_skills as (select ks_code
from knowledge_skill
where ks_code in ('1967', '1876', '1598')),
Cover_CSet(csetID, num) AS (
SELECT csetID, num
FROM CourseSet CSet
WHERE NOT EXISTS ((
SELECT ks_code
FROM missing_skills)
MINUS(
SELECT ks_code
FROM CourseSet_Skill CSSk
WHERE CSet.csetID = CSSK.csetID
))),
minNum(num) as (select min(num)
from(
select 1, min(num) as num
from Cover_CSet
group by csetID)
group by 1
),
minimal_cset(csetID, num) as(
select csetID, num
from Cover_CSet
where num in(select num from minNum))
select csetID, num
from CourseSet
where csetID in ( select csetID from minimal_cset);
drop sequence CourseSet_seq;
drop TABLE CourseSet;



--14
CREATE SEQUENCE CourseSet_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE;
CREATE  TABLE CourseSet (
csetID NUMBER(8, 0) PRIMARY KEY,
c_code1 NUMBER(6, 0), c_code2 NUMBER(6, 0), c_code3 NUMBER(6, 0),
num NUMBER(2, 0) /* number of courses */
);

INSERT INTO CourseSet
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, null, 2
FROM Course C1, Course C2
WHERE C1.c_code < C2.c_code;

INSERT INTO CourseSet
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, C3.c_code, 3
FROM Course C1, Course C2, Course C3
WHERE C1.c_code < C2.c_code AND C2.c_code < C3.c_code;

WITH CourseSet_Skill(csetID, ks_code) AS (
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code1=CS.c_code
UNION
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code2=CS.c_code
UNION
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code3=CS.c_code),
missing_skills as ((select ks_code
                from required_skill j
                where pos_code = '1231')    --all missing skills
                MINUS
                (select ks_code
                from per_skill KS 
                where person_id = '4654'))
SELECT csetID, num
FROM CourseSet CSet
WHERE NOT EXISTS ((
SELECT ks_code
FROM missing_skills)
MINUS(
SELECT ks_code
FROM CourseSet_Skill CSSk
WHERE CSSk.csetID = Cset.csetID
));
drop sequence CourseSet_seq;
drop TABLE CourseSet;


--15

CREATE SEQUENCE CourseSet_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 999999
NOCYCLE;
CREATE  TABLE CourseSet (
csetID NUMBER(8, 0) PRIMARY KEY,
c_code1 NUMBER(6, 0), c_code2 NUMBER(6, 0), c_code3 NUMBER(6, 0),
num NUMBER(2, 0), total_price NUMBER(6,0) /* number of courses */
);
INSERT INTO CourseSet
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, null, 2, (select retail_price from course where C1.c_code = c_code)+(select retail_price from course where C2.c_code = c_code)
FROM Course C1, Course C2
WHERE C1.c_code < C2.c_code;

INSERT INTO CourseSet
SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, C3.c_code, 3, (select retail_price from course where C1.c_code = c_code)+(select retail_price from course where C2.c_code = c_code) + (select retail_price from course where C3.c_code = c_code)
FROM Course C1, Course C2, Course C3
WHERE C1.c_code < C2.c_code AND C2.c_code < C3.c_code;

WITH CourseSet_Skill(csetID, ks_code) AS (
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code1=CS.c_code
UNION
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code2=CS.c_code
UNION
SELECT csetID, ks_code
FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code3=CS.c_code),
missing_skills as ((select ks_code
                from required_skill j
                where pos_code = '1231')    --all missing skills
                MINUS
                (select ks_code
                from per_skill KS 
                where person_id = '4654')),
Cover_CSet(csetID, num) AS (
SELECT csetID, num
FROM CourseSet CSet
WHERE NOT EXISTS ((
SELECT ks_code
FROM missing_skills)
MINUS(
SELECT ks_code
FROM CourseSet_Skill CSSk
WHERE CSSk.csetID = Cset.csetID
))),
needed as(
select c_code1, c_code2, c_code3, total_price
from CourseSet
where csetID in(select csetID from Cover_CSet) 
order by total_price ASC)
select c_code1, c_code2, c_code3, total_price
from needed 
where total_price = (select min(total_price)
                        from (select 1, total_price from needed)
                        group by 1);
drop sequence CourseSet_seq;
drop TABLE CourseSet;

--#16

select distinct pos_code
from job_profile J
where not exists ((select ks_code
    from job_profile natural join required_skill
    where pos_code = J.pos_code)
    MINUS
    (select ks_code
    from per_skill
    where person_id = '9800'));
-------------------------------------------------------------------------------------------------------------
/*query17*/
--updated
--needs to be joined with eleigable jobs or you just return the pos if it the highest paying
with eligible_jobs as(
  select distinct J.pos_code
from job_profile J
where not exists ((select ks_code
    from job_profile natural join required_skill
    where pos_code = J.pos_code)
    MINUS
    (select ks_code
    from per_skill
    where person_id = '9800')))
select pos_code
from eligible_jobs natural join job
where pay_rate = (select max(pay_rate) from job natural join eligible_jobs);
-------------------------------------------------------------------------------------------------------------
/*query 18*/
--updated need to select from person in case you have a job that has no requirments
--works passes testing

with per_info as(
  select name,email,ks_code
  from person natural join per_skill
  where name not in (select name from job natural join person)
)
select distinct name,email 
from person S
where not exists(
  (select ks_code 
  from required_skill
  where pos_code = '6262')
  minus
  (select ks_code
  from per_info
  where per_info.name = S.name)
);



-------------------------------------------------------------------------------------------------------------
/*query 19*/
--full outer join what if you have a pos that requires 1 skill and you need people with 0 skills as missing 1
--works passes testing

WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (
  SELECT distinct person_id, COUNT(ks_code) as skillCnt   --good
  FROM per_skill
  where ks_code in (select ks_code from required_skill where pos_code = '1231') and person_id not in (select person_id from job natural join person)
  GROUP BY person_id),
PosSkillCnt(pos_code, skillCnt) AS (
  select pos_code, COUNT(unique ks_code) as skillCnt
  from required_skill                                 
  where pos_code = '1231'
  group by pos_code
)
select p.person_id
from person P
where 1 = (
  (select skillCnt
  from PosSkillCnt)
  -
  (select skillCnt
  from PersonRequiredSkillCnt PRSC
  where P.person_id = PRSC.person_id)
);
-------------------------------------------------------------------------------------------------------------
/*query 20*/
--works passes testing

WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (
  SELECT distinct person_id, COUNT(ks_code) as skillCnt   --good
  FROM per_skill natural join person
  where ks_code in (select ks_code from required_skill where pos_code = '1231') and person_id not in (select person_id from job natural join person)
  GROUP BY person_id),
PosSkillCnt(pos_code, skillCnt) AS (
  select pos_code, COUNT(unique ks_code) as skillCnt
  from required_skill                                 
  where pos_code = '1231'
  group by pos_code
),
PeopleMissingOne AS (
select p.person_id
from person P
where 1 = (
  (select skillCnt
  from PosSkillCnt)
  -
  (select skillCnt
  from PersonRequiredSkillCnt PRSC
  where P.person_id = PRSC.person_id)
)),
SkillsNedded as ((select person_id, ks_code
from PeopleMissingOne,required_skill 
where pos_code = '1231')
minus
(select person_id,ks_code from PeopleMissingOne natural JOIN per_skill))
select ks_code, count(person_id) as missing_One_Count
from SkillsNedded
group by ks_code
order by count(person_id) ASC;

----------------------------------------------------------------------------------------------------------------

/*query 21*/
--works passes testing
with PerSkillMiss as(
select person_id, (select count(ks_code) from required_skill where pos_code = '4567') - (select count(ks_code) from per_skill PS where P.person_id = PS.person_id and ks_code in (select ks_code from required_skill where pos_code = '4567')) as MissSkCnt
from person P
group by person_id
)
select person_id,MissSkCnt
from PerSkillMiss
where MissSkCnt = (select min(MissSkCnt) from PerSkillMiss);
---------------------------------------------------------------------------------------------------------------
/*query 22*/
--fails test
WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (
  SELECT distinct person_id, COUNT(ks_code) as skillCnt   --good
  FROM per_skill
  where ks_code in (select ks_code from required_skill where pos_code = '7394') and person_id not in (select person_id from job natural join person)
  GROUP BY person_id),
PosSkillCnt(pos_code, skillCnt) AS (
  select pos_code, COUNT(unique ks_code) as skillCnt
  from required_skill                                 
  where pos_code = '7394'
  group by pos_code
),
PeopleMissingOne AS (
select p.person_id
from person P
where 2 >= (    --k
  (select skillCnt
  from PosSkillCnt)
  -
  (select skillCnt
  from PersonRequiredSkillCnt PRSC
  where P.person_id = PRSC.person_id)
)),
SkillsNedded as ((select person_id, ks_code
from PeopleMissingOne,required_skill 
where pos_code = '7394')
minus
(select person_id,ks_code from PeopleMissingOne natural JOIN per_skill ))
select person_id, count(ks_code) as missing_One_Count
from SkillsNedded 
group by person_id
order by count(person_id) ASC;


--this solution works
WITH PersonRequiredSkillCnt(perID, skillCnt) AS (
SELECT person_id, COUNT(ks_code)
FROM per_skill NATURAL JOIN required_skill
WHERE pos_code = '7394'
GROUP BY person_id)
select perID, ((select count(ks_code) from required_skill where pos_code = '7394')- skillCnt) as missingSkills
from PersonRequiredSkillCnt
where skillCnt >= (
          select count(ks_code) - 2 --k
          from required_skill
          where pos_code = '7394'
)
order by skillCnt DESC;




---------------------------------------------------------------------------------------------------------------
/*query 23*/
--works seems to pass testing
WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (
  SELECT distinct person_id, COUNT(ks_code) as skillCnt   --good
  FROM per_skill natural JOIN person
  where ks_code in (select ks_code from required_skill where pos_code = '7394') and person_id not in (select person_id from job natural join person)
  GROUP BY person_id),
PosSkillCnt(pos_code, skillCnt) AS (
  select pos_code, COUNT(unique ks_code) as skillCnt
  from required_skill                                 
  where pos_code = '7394'
  group by pos_code
),
PeopleMissingOne AS (
select p.person_id
from person P
where 2 >= (    
  (select skillCnt
  from PosSkillCnt)
  -
  (select skillCnt
  from PersonRequiredSkillCnt PRSC
  where P.person_id = PRSC.person_id)
)),
SkillsNedded as ((select person_id, ks_code
from PeopleMissingOne,required_skill 
where pos_code = '7394')
minus
(select person_id,ks_code from PeopleMissingOne natural JOIN per_skill))
select distinct ks_code, count(person_id) as missing_One_Count
from SkillsNedded
group by ks_code
order by count(person_id) DESC;



WITH PersonRequiredSkillCnt(perID, skillCnt) AS (
SELECT person_id, COUNT(ks_code)
FROM per_skill NATURAL JOIN required_skill
WHERE pos_code = '7394'
GROUP BY person_id),
people as (
select perID
from PersonRequiredSkillCnt
where skillCnt >= (
					select count(ks_code) - 2--k
					from required_skill
					where pos_code = '7394'
)),
skillsneeded as ((select perID as person_id, ks_code
from people, required_skill
where pos_code = '7394')
minus
(select person_id, ks_code from per_skill))
select ks_code, count(person_id) as people
from skillsneeded
group by ks_code
order by count(person_id) DESC;

----------------------------------------------------------------------------------------------------------------------
--24
--group by not necessay
--may be right needs more robust checking
--p1: find the job profile with the least number of people qualified for that job
--make sure if the courses selected are correct (not sure)

with open_positions as (select pos_code, count(job_code) as openings
from job 
where person_id is null               --number of open positions
group by pos_code),
pos_ks as(
select pos_code, ks_code, person_id         
from open_positions natural join required_skill natural join per_skill),
qual_people as(select distinct pos_code, person_id
from pos_ks KS
group by pos_code, person_id
having count(ks_code) = (select count(ks_code) from required_skill RS group by pos_code having RS.pos_code= KS.pos_code)),
pos_qual as (select pos_code, count(person_id) as people from qual_people group by pos_code),
pos as(
select pos_code, (openings - people) as difference
from open_positions natural join pos_qual)
select distinct pos_code, people
from pos natural join pos_qual
where difference = (select max(difference) from (select 1, difference from pos));


/* Query 25*/

with open_positions as (select pos_code, count(job_code) as openings
from job 
where person_id is null               --number of open positions
group by pos_code),
pos_ks as(
select pos_code, ks_code, person_id         
from open_positions natural join required_skill natural join per_skill),
qual_people as(select distinct pos_code, person_id
from pos_ks KS
group by pos_code, person_id
having count(ks_code) = (select count(ks_code) from required_skill RS group by pos_code having RS.pos_code= KS.pos_code)),
pos_qual as (select pos_code, count(person_id) as people from qual_people group by pos_code),
pos as(
select pos_code, (openings - people) as difference
from open_positions natural join pos_qual),
largest_job_opening as(
select distinct pos_code, people
from pos natural join pos_qual
where difference = (select max(difference) from (select 1, difference from pos)))
select distinct c_code
from largest_job_opening natural join required_skill natural join skills_covered;