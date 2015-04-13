
/*query 1 works*/
SELECT name
FROM person natural join company_hires natural join job
WHERE comp_id = '3411';

/*query 2 works*/
select name, pay_rate
from person natural join company_hires natural join job
where comp_id = '3411' and pay_type = 'salary'
order by pay_type DESC;

/*query 3 works*/
with SALARY AS (select comp_id, sum(pay_rate) as salary_workers
from job natural join company_hires
where pay_type = 'salary'
group by comp_id),
WAGE AS (select comp_id, sum(pay_rate*1920) as wage_workers
from job natural join company_hires
where pay_type = 'wage'
group by comp_id)
select comp_id, (wage_workers+salary_workers) as worker_cost
from WAGE natural join SALARY;


/*query 4- works*/
select job_code
from person natural join job
where person_id = 9808;

/*query 5 - works*/
select distinct person_id
from project natural join job
where project_id = 3233;
/*query 6 - works*/
select ks_code
from person natural join knowledge_skill
where person_id = 9800;
/*query 7 works*/
(select ks_code 
from required_skill natural join job
where pos_code = '2223')
minus
(select ks_code
from required_skill natural join job
where person_id = '2342');
/*query 8 works*/
select ks_code
from required_skill natural join knowledge_skill
where pos_code = '3233';
/*query 9 works*/
(select ks_code 
from required_skill natural join job
where pos_code = '2223')
minus
(select ks_code
from person natural join knowledge_skill
where person_id = '9818');

/*query 10 works */
select distinct c_code
from skills_covered
where c_code in(select SC.c_code from skills_covered SC where ks_code = '1023');



/*query 11*/
select c_code, title
from course natural join skills_covered
where ks_code in
((
  select RS.ks_code 
  from required_skill RS       --skills for positipn
  where RS.pos_code = '1231')
minus(
  select ks_code
  from person natural join knowledge_skill     --persons skills
  where person_id = '2341'));

/*query 12*/
--works till here
with missing_skills as(
(select ks_code 
from required_skill                       
where pos_code = '3233')
minus
(select ks_code
from person natural join knowledge_skill
where person_id = '0234'))
select distinct T.c_code
from skills_covered T
where not exists ((select * from missing_skills) minus (select S.ks_code from skills_covered S where T.c_code = S.c_code));

/*query 13 works*/


       with REMAINING as((select ks_code
       from knowledge_skill            /*select knowledge_skill from person*/
       where person_id = '1234')
       MINUS(select ks_code
       from required_skill
       where pos_code = '3456')),            
       course_cov as
	       (select ks_code, c_code
	       from skills_covered natural join REMAINING)
       select c_code from course_cov where 4 > (select count(c_code) from course_cov group by ks_code);

      

/*query 14: List the course sets that their combinations cover all the missing knowledge/skills for a person to pursue a specific
job. The considered course sets will not include more than three courses.*/
--works but need testing      
with REMAINING as(    --remaining skills for a job
(select ks_code         --works
from required_skill
where pos_code = '3456')
MINUS 
(select ks_code
from knowledge_skill
where person_id = '1234')),
skill_cov as(
select c_code, ks_code    --skills covered 
from skills_covered natural join REMAINING
),
c_count as (select c_code, ks_code, count(c_code) as cour_count 
from skill_cov 
group by c_code,ks_code)
select c_code
from c_count          
where cour_count <= 3;

/*query 15 works*/
with skill_gap as(
(select ks_code 
from required_skill natural join job
where pos_code = '2223')
minus
(select ks_code
from person natural join knowledge_skill
where person_id = '9818'))
select c_code, min(retail_price)
from (skill_gap natural join skills_covered) natural join course
group by c_code;

--#16
/*query 16 works*/
select distinct pos_code
from job_profile J
where not exists ((select ks_code
    from job_profile natural join required_skill
    where pos_code = J.pos_code)
    MINUS
    (select ks_code
    from knowledge_skill
    where person_id = '1234'));

--17
/*query 17 works*/

with eligible_jobs as(
  select pos_code
  from(
  select distinct JP.pos_code
  from job_profile JP
  where not exists ((select ks_code
      from job_profile natural join required_skill
      where pos_code = JP.pos_code)
      MINUS
      (select ks_code
      from knowledge_skill
      where person_id = '9818')))
)
select pos_code
from eligible_jobs natural join job
where pay_rate = (select max(pay_rate) from job);

--18
with per_info as(
	select name,email,ks_code,pos_code
	from person natural join knowledge_skill natural join job natural join job_profile
)
select name,email 
from per_info S
where not exists(
	(select ks_code 
	from required_skill
	where pos_code = '3233')
	minus
	(select ks_code
	from per_info
	where per_info.name = S.name)
);
--needs testing buts work
--19
with REQ as
(select count(ks_code) as countKS, pos_code as PC
from required_skill
group by pos_code
having pos_code = '3456'),
PQUAL as(
select count(ks_code) as COUNTP, person_id, pos_code
from(
  select KS.ks_code, KS.person_id, RS.pos_code
  from required_skill RS, knowledge_skill KS
  where RS.ks_code = KS.ks_code
  )
group by person_id, pos_code)
select distinct person_id as PI 
from PQUAL
where COUNTP = (select countKS-1
      from REQ
      where pos_code = PC);
--needs testing but works 
--20
with PQUAL as(
select KS.ks_code, KS.person_id
from required_skill RS, knowledge_skill KS
where RS.ks_code = KS.ks_code AND pos_code = 1234
),
RQRDSKLL as (
  select ks_code
  from required_skill
  where pos_code = 1234
  ),
NEEDEDPEOPLE as(
select person_id, ks_code from PQUAL where person_id in(
select person_id
from PQUAL P
where (select count(ks_code) from PQUAL  PQ where P.person_id = PQ.person_id)  = (select count(ks_code)-1
      from RQRDSKLL)
    )
),
NOSKILL AS(
select ks_code
from RQRDSKLL
where ks_code not in (select ks_code
      from NEEDEDPEOPLE)),
SUMPERSON AS(
select SUM(ks_code) as SUMKS, person_id
from NEEDEDPEOPLE
group by person_id)
select missing_ks, count(person_id)
from(
select ((select SUM(ks_code) from RQRDSKLL)-SUMKS) AS missing_ks, person_id
from SUMPERSON
where (select SUM(ks_code) from RQRDSKLL)-SUMKS = (select ks_code from NOSKILL))
group by missing_ks
order by count(person_id) ASC;
--needs testing but works
--21
with pskill as(select person_id, ks_code from knowledge_skill where ks_code in (select ks_code from required_skill where pos_code = '3456')),
pcount as(select person_id, count(ks_code) as COUNTKS from pskill group by person_id)
select person_id from pcount where COUNTKS = (select MAX(COUNTKS) from pcount group by person_id);
--needs testing but works
--22
with REQ as
(select count(ks_code) as countKS, pos_code as PC
from required_skill
group by pos_code
having pos_code = '3456'),
PQUAL as(
select count(ks_code) as COUNTP, person_id, pos_code
from(
  select KS.ks_code, KS.person_id, RS.pos_code
  from required_skill RS, knowledge_skill KS
  where RS.ks_code = KS.ks_code
 )
group by person_id, pos_code
)
select distinct person_id as PI, ((select countKS from REQ where P1.pos_code = PC) - (select P2.COUNTP from PQUAL P2 where P1.person_id = P2.person_id)) 
from PQUAL P1
where P1.COUNTP <= (select countKS-1--any number k
      from REQ
      where P1.pos_code = PC)
group by person_id, pos_code;
--needs testing but works

--23
/*with REQ as
(select count(ks_code) as countKS, pos_code as PC
from required_skill
group by pos_code
having pos_code = '3456'),*/
with PQUAL as(
select count(ks_code) as COUNTP, person_id, pos_code
from(
  select KS.ks_code, KS.person_id, RS.pos_code
  from required_skill RS, knowledge_skill KS
  where RS.ks_code = KS.ks_code
 )
group by person_id, pos_code),
PID as(select person_id from PQUAL where COUNTP = (select MIN(COUNTP) from PQUAL group by person_id)),
/*KS as(select ks_code
	from required_skill RS,knowledge_skill KS
	where pos_code = '3456' and ks_code not = (select ks_code
											from knowledge_skill
											where person_id = (select person_id from PID))
per_ks as(select ks_code,person_id from KS,knowledge_skill),*/
missing as(select KS.ks_code as KS, RS.ks_code as RS, person_id   --all per doesent have -- all skills a person doesent have not in
from required_skill RS, knowledge_skill KS
where KS.ks_code != RS.ks_code and RS.pos_code = '3456' AND KS.person_id  in(select person_id from PID) AND RS.ks_code not in(select KS2.ks_code from knowledge_skill KS2 where KS2.person_id = KS.person_id))
select RS, count(person_id) from missing
group by RS
order by count(person_id) DESC;
--needs testing but works 
--24
/* works needs testing*/
with all_job_profiles as(
select distinct pos_code     --all positions requiring some skill
from required_skill
),
pos_qualified as(
select pos_code      --all the positions for which there are qualified people
from knowledge_skill natural join required_skill
),
pos_no_qual as (select pos_code 
from all_job_profiles   --all positions for which there are no qualified people
where pos_code in ((select pos_code from all_job_profiles) MINUS (select pos_code from pos_qualified))),
job_for_no_qual_pos as(
select pos_code, count(job_code) as job_count
from pos_no_qual natural join job     --number of open jobs for each position for which there are no qualified people
group by pos_code
)
select pos_code
from job_for_no_qual_pos      --select pos with the largest number of job openings
where job_count >= ALL(select job_count from job_for_no_qual_pos);
/* Query 25*/
with all_job_profiles as(
select distinct pos_code     --all positions requiring some skill
from required_skill
),
pos_qualified as(
select pos_code      --all the positions for which there are qualified people
from knowledge_skill natural join required_skill
),
pos_no_qual as (select pos_code 
from all_job_profiles   --all positions for which there are no qualified people
where pos_code in ((select pos_code from all_job_profiles) MINUS (select pos_code from pos_qualified))),
job_for_no_qual_pos as(
select pos_code, count(job_code) as job_count
from pos_no_qual natural join job     --number of open jobs for each position for which there are no qualified people
group by pos_code
),
pos_largest_job_opening as (select pos_code
from job_for_no_qual_pos      --select pos with the largest number of job openings
where job_count >= ALL(select job_count from job_for_no_qual_pos))
select c_code
from pos_largest_job_opening natural join required_skill natural join skills_covered;














