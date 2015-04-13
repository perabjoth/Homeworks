/**
* Name: Perabjoth Singh Bajwa
* ID: 2449713
* CSCI 4125 Spring 2015
* JDBC for Project 
*      ******
*    **********
*   *************
*  ***************
*  **   *****  ***
*  ***************
*   ****** ******
*    ***********
*     *********
*    ***********
*   ************* 
**/
import java.sql.*;
import java.util.Scanner;
public class JDBC {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	static final String DB_URL = "jdbc:oracle:thin:@dbsvcs.cs.uno.edu:1521:orcl";
	static final String USER = "nabdelgu";
	static final String PASS = "PdXqw4dHL9";

public static void main(String[] args) {
	Connection conn = null;
	Statement stmt = null;
	try{
      
	Class.forName(JDBC_DRIVER);


	System.out.println("Connecting to database...");
	conn = DriverManager.getConnection(DB_URL,USER,PASS);


	System.out.println("Creating statement...");
	stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String sql;
	ResultSet rs;
	Scanner scanner  = new Scanner(System.in);
	int x = 1;

	int i = 1;
	
	while(true){
		i=1;
		System.out.print("\nFor queries, enter number from 1-25\nFor description of queries, enter 26\nTo quit, press 0\nPlease enter choice: ");
		x = scanner.nextInt();
		System.out.println();
		if(x<0 || x>26)
		{
			System.out.println("Invalid choice. Try again.");
		}
		if(x==0)
		{
			break;
		}
		if(x==26)
		{
			System.out.println("1. List a company's workers by names.\n2. List a company's staff by salary in descending order.\n3. List companies' labor cost (total salaries and wage rates by 1920 hours) in descending order.\n4. Find all the jobs a person is currently holding.\n5. List all the workers who are working for a specific project.\n6. List a person's knowledge/skills in a readable format.\n7. List the skill gap of a worker between his/her job(s) and his/her skills.\n8. List the required knowledge/skills of a job profile in a readable format.\n9. List a person's missing knowledge/skills for a specific job in a readable format.\n10. Find the courses each of which alone can cover a given skill set.\n11. List the courses (course id and title) that each alone teaches all the missing knowledge/skills for a person to pursue a specific job.\n12. Suppose the skill gap of a worker and the requirement of a desired job can be covered by one course. Find the \"quickest\" solution for this worker. Show the course and the completing date.\n13. If query #10 returns nothing, then find the course sets with the minimum number of courses that their combination covers the given skill set. The considered course sets will not include more than three courses.\n14. List the course sets that their combinations cover all the missing knowledge/skills for a person to pursue a specific job. The considered course sets will not include more than three courses.\n15. Find the cheapest course choices to make up one's skill gap by showing the courses to take and the total cost. The considered course sets will not include more than three courses.\n16. List all the job profiles that a person is qualified.\n17. Find the job with the highest pay rate for a person according to his/her skill qualification.\n18. List all the names along with the emails of the persons who are qualified for a job profile.\n19. When a company cannot find any qualified person for a job, a secondary solution is to find a person who is almost qualified to the job. Make a \"missing-one\" list that lists people who miss only one skill for a specified job profile.\n20. List the skillID and the number of people in the missing-one list for a given job profile in the ascending order of the people counts.\n21. Suppose there is a new job profile that has nobody qualified. List the persons who miss the least number of skills and report the \"least number\".\n22. For a specified job profile and a given small number k, make a \"missing-k\" list that lists the people's IDs and the number of missing skills for the people who miss only up to k skills in the ascending order of missing skills.\n23. Given a job profile and its corresponding missing-k list specified in Question 22. Find every skill that is needed by at least one person in the given missing-k list. List each skillID and the number of people who need it in the descending order of the people counts.\n24. Find the job profiles that have the most openings due to lack of qualified workers. If there are many opening jobs of a job profile but at the same time there are many qualified jobless people. Then training cannot help fill up this type of job. What we want to find is such a job profile that has the largest difference between vacancies (the unfilled jobs of this job profile) and the number of jobless people who are qualified for this job profile.\n25. Find the courses that can help most jobless people find a job by training them toward the job profiles that have the most openings due to lack of qualified workers.");
		}
		if(x == 1 ){
			sql = "SELECT name FROM person natural join company_hires natural join job WHERE comp_id = '3411'";

			rs = stmt.executeQuery(sql);
			System.out.println("NAME: ");

			
			while(rs.next()){
				

				 String name = rs.getString(1);
				 System.out.println(i+"-" + name);
				i++;
			}

			
			rs.close();
		}
		if(x==2)
		{
			sql = "select name, pay_rate from person natural join company_hires natural join job where comp_id = '3411' and pay_type = 'salary' order by pay_rate DESC";

			rs = stmt.executeQuery(sql);


			
			while(rs.next()){
			

				 String name = rs.getString(1);
				 int pay_rate = rs.getInt(2);
				 System.out.println(i+"-"+"NAME: " + name + ", PAY_RATE: " + pay_rate);
				 i++;

			}
			
			rs.close();
		}

		if(x==3)
		{
			sql = "with SALARY AS (select comp_id, sum(pay_rate) as worker_salary from job natural join company_hires where pay_type = 'salary' group by comp_id),WAGE AS (select comp_id, sum(pay_rate*1920) as worker_salary from job natural join company_hires where pay_type = 'wage' group by comp_id),salary_wage as((select * from SALARY) union (select * from WAGE))select comp_id,sum(worker_salary) as total_worker_cost from salary_wage group by comp_id order by total_worker_cost DESC";

			rs = stmt.executeQuery(sql);


			
			while(rs.next()){
			

				 int comp_id = rs.getInt(1);
				 int worker_cost = rs.getInt(2);
				 System.out.println(i+"-"+"COMP_ID: " + comp_id + ", WORKER_COST: " + worker_cost);
				 i++;

			}
			
			rs.close();
		}
		if(x==4)
		{
			sql = "select job_code from person natural join job where person_id = 1229";
			rs = stmt.executeQuery(sql);

			System.out.println("JOB_CODE:");
			
			while(rs.next()){
				

				 int job_code = rs.getInt(1);
				 System.out.println(i+"-"+job_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==5)
		{
			sql = "select distinct person_id from project natural join job where project_id = 3233";
			rs = stmt.executeQuery(sql);

			System.out.println("PERSON_ID:");
			
			while(rs.next()){
			

				 int person_id = rs.getInt(1);
				 System.out.println(i+"-"+person_id);
				 
				i++;
			}
			rs.close();
		}
		if(x==6)
		{
			sql = "select ks_code from knowledge_skill where person_id = 9800";
			rs = stmt.executeQuery(sql);

			System.out.println("KS_CODE:");
			
			while(rs.next()){
				

				 int ks_code = rs.getInt(1);
				 System.out.println(i+"-"+ks_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==7)
		{
			sql = "(select ks_code from required_skill natural join job where person_id = '2342')minus(select ks_code from knowledge_skill natural join job where person_id = '2342')";
			rs = stmt.executeQuery(sql);

			System.out.println("KS_CODE:");
			
			while(rs.next()){
			

				 int ks_code = rs.getInt(1);
				 System.out.println(i+"-"+ks_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==8)
		{
			sql = "select ks_code from required_skill where pos_code = '3233'";
			rs = stmt.executeQuery(sql);

			System.out.println("KS_CODE:");
			
			while(rs.next()){
				

				 int ks_code = rs.getInt(1);
				 System.out.println(i+"-"+ks_code);
				 
				i++;
			}
			
			rs.close();
		} 
		if(x==9)
		{
			sql = "((select ks_code from required_skill natural join job where person_id = '2342' where pos_code = '3233')minus(select ks_code from knowledge_skill natural join job where person_id = '2342')";
			rs = stmt.executeQuery(sql);

			System.out.println("KS_CODE:");
			
			while(rs.next()){
				

				 int ks_code = rs.getInt(1);
				 System.out.println(i+"-"+ks_code);
				 
				i++;
			}
			
			rs.close();
		} 
			 if(x==10)
		{
			sql = "select distinct c_code from skills_covered where c_code in(select SC.c_code from skills_covered SC where ks_code = '1023')";
			rs = stmt.executeQuery(sql);

			System.out.println("C_CODE:");
			
			while(rs.next()){
			

				 int c_code = rs.getInt(1);
				 System.out.println(i+"-"+c_code);
				 
				i++;
			}
			
			rs.close();
		}
			 if(x==11)
		{
			sql = "select distinct c_code, title from course natural join skills_covered where ks_code = all((select ks_code from required_skill  where pos_code = '1231')minus(select ks_code from person natural join knowledge_skill where person_id = '2341'))";
			rs = stmt.executeQuery(sql);


			
			while(rs.next()){
			

				 int c_code = rs.getInt(1);
				 String title = rs.getString(2);
				 System.out.println(i+"-"+"C_CODE: " + c_code+ ", TITLE: " + title);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==12)
		{
			sql = "with missing_skills as((select ks_code from required_skill where pos_code = '3233') minus (select ks_code from person natural join knowledge_skill where person_id = '0234')) select distinct T.c_code from skills_covered T where not exists ((select * from missing_skills) minus (select S.ks_code from skills_covered S where T.c_code = S.c_code))";
			rs = stmt.executeQuery(sql);

			System.out.println("C_CODE:");
			
			while(rs.next()){
			

				 int c_code = rs.getInt(1);
				 System.out.println(i+"-" +c_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==13)
		{
			sql = "with REMAINING as((select ks_code from knowledge_skill where person_id = '1234')MINUS(select ks_code from required_skill where pos_code = '3456')), course_cov as (select ks_code, c_code from skills_covered natural join REMAINING) select c_code from course_cov where 4 > (select count(c_code) from course_cov group by ks_code)";
			rs = stmt.executeQuery(sql);

			System.out.println("C_CODE:");
			
			while(rs.next()){
			

				 int c_code = rs.getInt(1);
				 System.out.println(i+"-" +c_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==14)
		{
			sql = "with REMAINING as((select ks_code from required_skill where pos_code = '3456')MINUS (select ks_code from knowledge_skill where person_id = '1234')),skill_cov as(select c_code, ks_code from skills_covered natural join REMAINING),c_count as (select c_code, ks_code, count(c_code) as cour_count from skill_cov group by c_code,ks_code)select c_code from c_count where cour_count <= 3";
			rs = stmt.executeQuery(sql);

			System.out.println("C_CODE:");
			
			while(rs.next()){
			

				 int c_code = rs.getInt(1);
				 System.out.println(i+"-" +c_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==15)
		{
			sql = "with skill_gap as((select ks_code from required_skill natural join job where pos_code = '2223')minus(select ks_code from person natural join knowledge_skill where person_id = '9818'))select c_code, min(retail_price)from (skill_gap natural join skills_covered) natural join course group by c_code";
			rs = stmt.executeQuery(sql);


			
			while(rs.next()){
			

				 int c_code = rs.getInt(1);
				 int min_retail_price = rs.getInt(2);
				 System.out.println(i+"-" +"C_CODE: " + c_code + ", MIN_RETAIL_PRICE: " + min_retail_price);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==16)
		{
			sql = "select distinct pos_code from job_profile J where not exists ((select ks_code from job_profile natural join required_skill where pos_code = J.pos_code)MINUS(select ks_code from knowledge_skill where person_id = '1234'))";
			rs = stmt.executeQuery(sql);

			System.out.println("POS_CODE:");
			
			while(rs.next()){
				

				 int pos_code = rs.getInt(1);
				 System.out.println(i+"-" +pos_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==17)
		{
			sql = "with eligible_jobs as(select pos_code from(select distinct JP.pos_code from job_profile JP where not exists ((select ks_code from job_profile natural join required_skill where pos_code = JP.pos_code)MINUS(select ks_code from knowledge_skill where person_id = '9818'))))select pos_code from eligible_jobs natural join job where pay_rate = (select max(pay_rate) from job)";
			rs = stmt.executeQuery(sql);

			System.out.println("POS_CODE:");
			
			while(rs.next()){
			

				 int pos_code = rs.getInt(1);
				 System.out.println(i+"-" +pos_code);
				 
				i++;
			}
			
			rs.close();
		}
		if(x==18)
		{
			sql = "with per_info as(select name,email,ks_code,pos_code from person natural join knowledge_skill natural join job natural join job_profile)select name,email from per_info S where not exists((select ks_code from required_skill where pos_code = '3233')minus(select ks_code from per_info where per_info.name = S.name))";
			rs = stmt.executeQuery(sql);


			
			while(rs.next()){
			

				 String name = rs.getString(1);
				 String email = rs.getString(2);
				 System.out.println(i+"-" +"NAME: " + name + ", EMAIL: " + email);
				 
				i++;
			}
			
			rs.close();
			}
			if(x==19)
		{
			sql = "with REQ as(select count(ks_code) as countKS, pos_code as PC from required_skill group by pos_code having pos_code = '3456'),PQUAL as(select count(ks_code) as COUNTP, person_id, pos_code from(select KS.ks_code, KS.person_id, RS.pos_code from required_skill RS, knowledge_skill KS where RS.ks_code = KS.ks_code)group by person_id, pos_code)select distinct person_id as PI from PQUAL where COUNTP = (select countKS-1 from REQ where pos_code = PC)";
			rs = stmt.executeQuery(sql);

			System.out.println("PERSON_ID:");
			
			while(rs.next()){
			

				 int person_id = rs.getInt(1);
				 System.out.println(i+"-"+person_id);
				 
				i++;
			}
			
			rs.close();
		}
		 if(x==20)
		{
			sql = "with PQUAL as(select KS.ks_code, KS.person_id from required_skill RS, knowledge_skill KS where RS.ks_code = KS.ks_code AND pos_code = 1234),RQRDSKLL as (select ks_code from required_skill where pos_code = 1234),NEEDEDPEOPLE as(select person_id, ks_code from PQUAL where person_id in(select person_id from PQUAL P where (select count(ks_code) from PQUAL  PQ where P.person_id = PQ.person_id)  = (select count(ks_code)-1 from RQRDSKLL))),NOSKILL AS(select ks_code from RQRDSKLL where ks_code not in (select ks_code from NEEDEDPEOPLE)),SUMPERSON AS(select SUM(ks_code) as SUMKS, person_id from NEEDEDPEOPLE group by person_id)select missing_ks, count(person_id)from(select ((select SUM(ks_code) from RQRDSKLL)-SUMKS) AS missing_ks, person_id from SUMPERSON where (select SUM(ks_code) from RQRDSKLL)-SUMKS = (select ks_code from NOSKILL))group by missing_ks order by count(person_id) ASC";
			rs = stmt.executeQuery(sql);


			
			while(rs.next()){
			
				int ks_code = rs.getInt(1);
				 int person_id = rs.getInt(2);
				 System.out.println(i+"-"+"PERSON_ID: " + person_id+ ", KS_CODE: " + ks_code);
				 
				i++;
			}
			
			rs.close();
		}
		 if(x==21)
		{
			sql = "with pskill as(select person_id, ks_code from knowledge_skill where ks_code in (select ks_code from required_skill where pos_code = '3456')),pcount as(select person_id, count(ks_code) as COUNTKS from pskill group by person_id)select person_id from pcount where COUNTKS = (select MAX(COUNTKS) from pcount group by person_id)";
			rs = stmt.executeQuery(sql);

			System.out.println("PERSON_ID:");
			
			while(rs.next()){
				
				 int person_id = rs.getInt(1);
				 System.out.println(i+"-"+person_id);
				 
				i++;
			}
			
			rs.close();
		}
		 if(x==22)
		{
			sql = "with REQ as(select count(ks_code) as countKS, pos_code as PC from required_skill group by pos_code having pos_code = '3456'),PQUAL as(select count(ks_code) as COUNTP, person_id, pos_code from(select KS.ks_code, KS.person_id, RS.pos_code from required_skill RS, knowledge_skill KS where RS.ks_code = KS.ks_code)group by person_id, pos_code)select distinct person_id as PI, ((select countKS from REQ where P1.pos_code = PC) - (select P2.COUNTP from PQUAL P2 where P1.person_id = P2.person_id)) from PQUAL P1 where P1.COUNTP <= (select countKS-1 from REQ where P1.pos_code = PC)group by person_id, pos_code";
			rs = stmt.executeQuery(sql);

			
			while(rs.next()){
			
				 int person_id = rs.getInt(1);
				 int count_ks_code = rs.getInt(2);
				 System.out.println(i+"-"+"PERSON_ID: " + person_id + ", COUNT_KS_CODE: " + count_ks_code);
				 
				i++;
			}
			
			rs.close();
		}
		 if(x==23)
		{
			sql = "with PQUAL as(select count(ks_code) as COUNTP, person_id, pos_code from(select KS.ks_code, KS.person_id, RS.pos_code from required_skill RS, knowledge_skill KS where RS.ks_code = KS.ks_code)group by person_id, pos_code), PID as(select person_id from PQUAL where COUNTP = (select MIN(COUNTP) from PQUAL group by person_id)), missing as(select KS.ks_code as KS, RS.ks_code as RS, person_id from required_skill RS, knowledge_skill KS where KS.ks_code != RS.ks_code and RS.pos_code = '3456' AND KS.person_id  in(select person_id from PID) AND RS.ks_code not in(select KS2.ks_code from knowledge_skill KS2 where KS2.person_id = KS.person_id))select RS, count(person_id) from missing group by RS order by count(person_id) DESC";
			rs = stmt.executeQuery(sql);

			
			while(rs.next()){
			
				 int count_person = rs.getInt(2);
				 int ks_code = rs.getInt(1);
				 System.out.println(i+"-"+"ks_code: " + ks_code + ", COUNT_PERSON: " + count_person);
				 
				i++;
			}
			
			rs.close();
		}
		 if(x==24)
		{
				sql = "with all_job_profiles as(select distinct pos_code from required_skill),pos_qualified as(select pos_code from knowledge_skill natural join required_skill),pos_no_qual as (select pos_code from all_job_profiles where pos_code in ((select pos_code from all_job_profiles) MINUS (select pos_code from pos_qualified))),job_for_no_qual_pos as(select pos_code, count(job_code) as job_count from pos_no_qual natural join job group by pos_code)select pos_code from job_for_no_qual_pos where job_count >= ALL(select job_count from job_for_no_qual_pos)";
				rs = stmt.executeQuery(sql);
				System.out.println("POS_CODE: ");
				
				while(rs.next()){
					
					int pos_code = rs.getInt(1);
					 System.out.println(i+"-"+pos_code);
					 
					i++;
				}
				
				rs.close();
			}
			if(x==25)
			{
			sql = "with all_job_profiles as(select distinct pos_code from required_skill),pos_qualified as(select pos_code from knowledge_skill natural join required_skill),pos_no_qual as (select pos_code from all_job_profiles where pos_code in ((select pos_code from all_job_profiles) MINUS (select pos_code from pos_qualified))),job_for_no_qual_pos as(select pos_code, count(job_code) as job_count from pos_no_qual natural join job group by pos_code),pos_largest_job_opening as (select pos_code from job_for_no_qual_pos where job_count >= ALL(select job_count from job_for_no_qual_pos))select c_code from pos_largest_job_opening natural join required_skill natural join skills_covered";
			rs = stmt.executeQuery(sql);
			System.out.println("C_CODE: ");
			
			while(rs.next()){
				
				int c_code = rs.getInt(1);
				 System.out.println(i+"-"+c_code);
				 
				i++;
			}
			
			rs.close();
		}
	}
	stmt.close();
	conn.close();
	}catch(SQLException se){
		System.out.println("SQLException se:\n");
		se.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(stmt!=null)
				stmt.close();
		}catch(SQLException se2){
			System.out.println("SQLException se2:\n");
			se2.printStackTrace();
		}
		try{
			 if(conn!=null)
				conn.close();
		}catch(SQLException se3){
			System.out.println("SQLException se3:\n");
			se3.printStackTrace();
		}
	}
System.out.println("Goodbye!");
}
}
