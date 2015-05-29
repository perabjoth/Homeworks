/**
 * Name: Perabjoth Singh Bajwa, Noah Abdelguerfi
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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBC {
	private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	private static final String DB_URL = "jdbc:oracle:thin:@dbsvcs.cs.uno.edu:1521:orcl";
	private static final String USER = "nabdelgu";
	private static final String PASS = "PdXqw4dHL9";
	private static Connection conn = null;
	private static Statement stmt = null;

	private static int inputmatcher()
	{
		int q = -1;
		Scanner scanner  = new Scanner(System.in);
		do{
			try {
				q = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again:");
			}
			scanner.nextLine();
		}while(q<0);
		return q;
	}

	private static int inputmatcher3(int q, String s)
	{	

		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println(s);			
			try {
				q = scanner.nextInt();


				if(!(String.valueOf(q).length() >= 5 || q<0)){
					return q;
				}

			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again:" + s);
				scanner = new Scanner(System.in);
				continue;

			}


		}

	}
	private static int inputmatcher61(int q, String s) throws SQLException
	{	

		System.out.println(s);	
		Scanner scanner = new Scanner(System.in);

		int potato = 342342;
		while(true){
			try {
				q = scanner.nextInt();
				PreparedStatement s1 = conn.prepareStatement("select c_code from course where c_code = ?");
				s1.setInt(1, q);
				ResultSet rs = s1.executeQuery();
				if(rs.next())
					potato = rs.getInt(1);

				if(q == potato && String.valueOf(q).length() <= 4){
					return q;
				}
				else{
					System.out.println("Value doesn not exist, try again:");
				}

			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again: " + s);
				scanner = new Scanner(System.in);
				continue;
			}
		}
	}

	private static int inputmatcher6(int q, String s) throws SQLException
	{	

		System.out.println(s);	
		Scanner scanner = new Scanner(System.in);

		int potato = 342342;
		while(true){
			try {
				q = scanner.nextInt();
				PreparedStatement s1 = conn.prepareStatement("select c_code from course where c_code = ?");
				s1.setInt(1, q);
				ResultSet rs = s1.executeQuery();
				if(rs.next())
					potato = rs.getInt(1);

				if(q != potato && String.valueOf(q).length() <= 4){
					return q;
				}
				else{
					System.out.println("Value exists, try again:");
				}

			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again:" + s);
				scanner = new Scanner(System.in);
				continue;
			}
		}
	}
	private static int check(int q, String column, String table) throws SQLException
	{	
		Scanner scanner = new Scanner(System.in);

		int potato = 342342;
		while(true){
			try {
				q = scanner.nextInt();
				PreparedStatement s1 = conn.prepareStatement("select "+column+" from "+table+" where "+column+" = ?");
				s1.setInt(1, q);
				ResultSet rs = s1.executeQuery();
				if(rs.next())
					potato = rs.getInt(1);

				if(q == potato && String.valueOf(q).length() <= 4){
					return q;
				}
				else{
					System.out.println("Invalid, try again:");
				}

			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again:");
				scanner = new Scanner(System.in);
				continue;
			}
		}
	}
	private static int inputmatcher7(int q, String s) throws SQLException
	{	

		System.out.println(s);	
		Scanner scanner = new Scanner(System.in);

		int potato = 342342;
		while(true){
			try {
				q = scanner.nextInt();
				PreparedStatement s1 = conn.prepareStatement("select c_code from course where c_code = ?");
				s1.setInt(1, q);
				ResultSet rs = s1.executeQuery();
				if(rs.next())
					potato = rs.getInt(1);

				if(q == potato && String.valueOf(q).length() <= 4){
					return q;
				}
				else{
					System.out.println("Value exists, try again:");
				}

			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again:" + s);
				scanner = new Scanner(System.in);
				continue;
			}
		}
	}


	private static String inputmatcher1(String x)
	{
		Scanner scanner  = new Scanner(System.in);
		do{
			try {
				x = scanner.nextLine();
			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again:");
			}
		}while(x == null);
		return x;
	}


	private static String inputmatcher5(int n, String message)
	{

		String x = "";

		Scanner scanner  = new Scanner(System.in);
		while(true){
			System.out.println(message);
			try {
				x = scanner.nextLine();

				if(x.length()  < n){

					break;
				}
			}catch(InputMismatchException e){
				System.out.println("Invalid value. Try again. ");
				inputmatcher5(n, message);
			}
			return x;
		}

		return x;

	}

	private static void updateStatments(){
		try {
			stmt.executeUpdate("CREATE SEQUENCE CourseSet_seq START WITH 1 INCREMENT BY 1 MAXVALUE 999999 NOCYCLE");
			stmt.executeUpdate("CREATE  TABLE CourseSet (csetID NUMBER(8, 0) PRIMARY KEY, c_code1 NUMBER(6, 0), c_code2 NUMBER(6, 0), c_code3 NUMBER(6, 0),num NUMBER(2, 0))");
			stmt.executeUpdate("INSERT INTO CourseSet SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, null, 2 FROM Course C1, Course C2 WHERE C1.c_code < C2.c_code");
			stmt.executeUpdate("INSERT INTO CourseSet SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, C3.c_code, 3 FROM Course C1, Course C2, Course C3 WHERE C1.c_code < C2.c_code AND C2.c_code < C3.c_code");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}

	}
	private static void updateStatments2(){
		try {
			stmt.executeUpdate("CREATE SEQUENCE CourseSet_seq START WITH 1 INCREMENT BY 1 MAXVALUE 999999 NOCYCLE");
			stmt.executeUpdate("CREATE  TABLE CourseSet (csetID NUMBER(8, 0) PRIMARY KEY,c_code1 NUMBER(6, 0), c_code2 NUMBER(6, 0), c_code3 NUMBER(6, 0),num NUMBER(2, 0), total_price NUMBER(6,0))");			
			stmt.executeUpdate("INSERT INTO CourseSet SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, null, 2, (select retail_price from course where C1.c_code = c_code)+(select retail_price from course where C2.c_code = c_code) FROM Course C1, Course C2 WHERE C1.c_code < C2.c_code");
			stmt.executeUpdate("INSERT INTO CourseSet SELECT CourseSet_seq.NEXTVAL, C1.c_code, C2.c_code, C3.c_code, 3, (select retail_price from course where C1.c_code = c_code)+(select retail_price from course where C2.c_code = c_code) + (select retail_price from course where C3.c_code = c_code) FROM Course C1, Course C2, Course C3 WHERE C1.c_code < C2.c_code AND C2.c_code < C3.c_code");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}

	}


	private static void clear(){
		try{
			stmt.executeUpdate("drop TABLE CourseSet");
			stmt.executeUpdate("drop sequence CourseSet_seq");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	private static int choiceCheck()
	{
		int choice = -11;
		Scanner scanner = new Scanner(System.in);
		try{
			choice = scanner.nextInt();
			if(choice != 1 && choice != 2 && choice!= 0){
				while(choice != 1 && choice != 2 && choice!= 0){
					System.out.println("Press 1 to look for qualified people. Press 2 for unqualified people. Press 0 to exit.");
					choice = scanner.nextInt();
				}
			}
		}catch(Exception e){
			choiceCheck();
		}
		return choice;
	}
	private static int numCheck(){
		Scanner scanner = new Scanner(System.in);
		int ch = -11;
		try{
			ch = scanner.nextInt();
			if(ch<1 || ch >10){
				while(ch<=1 || ch >=10){
					System.out.println("Enter a number between 1 and 10");
					ch = scanner.nextInt();
				}
			}
		}
		catch(Exception e){
			System.out.println("Invalid choice.Enter a number between 1 and 10 \n");
			numCheck();
		}
		return ch;
	}



	public static void main(String[] args) {

		try{

			Class.forName(JDBC_DRIVER);


			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);


			System.out.println("Creating statement...");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			ResultSet rs;
			Scanner scanner  = new Scanner(System.in);
			int x = -1;

			int i = 1;

			while(true){
				i=1;
				x=-1;
				System.out.println("Please enter choice:\nFor queries, enter number from 1-25\nFor description of queries, enter 26\nTo quit, press 0\n30 to insert,update,or delete from the database. \n31 to perform job hunting. \n32 to hire a person \n33 to find qualified or underqualified personnel\n34 to find the personnel and their costs for training for a project\n35 to find optimal skill that needs training for position");
				x = inputmatcher();
				System.out.println();
				if(x<0 || x>26 && x != 30 && x!=31 && x!= 32 && x!=33 && x!=34 && x!=35)
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
				if(x==35)
				{
					PreparedStatement s = conn.prepareStatement("WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (SELECT distinct person_id, COUNT(ks_code) as skillCnt FROM per_skill natural JOIN person where ks_code in (select ks_code from required_skill where pos_code = ?) and person_id not in (select person_id from job natural join person) GROUP BY person_id),PosSkillCnt(pos_code, skillCnt) AS (select pos_code, COUNT(unique ks_code) as skillCnt from required_skill where pos_code = ? group by pos_code),PeopleMissingOne AS (select p.person_id from person P where ? >= ((select skillCnt from PosSkillCnt)-(select skillCnt from PersonRequiredSkillCnt PRSC where P.person_id = PRSC.person_id))),SkillsNedded as ((select person_id, ks_code from PeopleMissingOne,required_skill where pos_code = ?) minus (select person_id,ks_code from PeopleMissingOne natural JOIN per_skill)), people as (select distinct ks_code, count(person_id) as missing_One_Count from SkillsNedded group by ks_code order by count(person_id) DESC) select ks_code from people where missing_One_Count = (select max(missing_One_Count) from people)");
					System.out.println("Enter pos code for training optimization:");
					int choice = check(-11,"pos_code", "job_profile");
					System.out.println("Enter number of skills missing for position: ");
					int ch = numCheck();
					s.setInt(1,choice);
					s.setInt(2,choice);
					s.setInt(3,ch);
					s.setInt(4,choice);
					rs = s.executeQuery();
					System.out.println("These skills will train most people: ");
					while(rs.next())
					{
						System.out.println(i+"-"+rs.getInt(1));
					}
					rs.close();

				}
				if(x==34){
					ArrayList<Integer> numbers = new ArrayList<>();
					int condition = -1;
					updateStatments2();
					stmt.executeUpdate("Insert into CourseSet SELECT CourseSet_seq.NEXTVAL, c_code, null, null, 1, retail_price FROM Course");

					System.out.println("Type in project id. Type 0  when you're done.");
					int ch = inputmatcher();
					PreparedStatement ps = conn.prepareStatement("select distinct ks_code from project natural join job natural join required_skill where project_id = ?");
					ps.setInt(1, ch);
					rs = ps.executeQuery();
					while(rs.next()){
						numbers.add(rs.getInt(1));
					}


					String sqlBase = "";
					for( int id : numbers ){
						if(numbers.indexOf(id)!= numbers.size()-1)
							sqlBase += "?,";
					}
					sqlBase+="?";
					PreparedStatement s = conn.prepareStatement("WITH CourseSet_Skill(csetID, ks_code) AS ( SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code1=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code2=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code3=CS.c_code),missing_skills as (select ks_code from knowledge_skill where ks_code in ("+sqlBase+")),Cover_CSet(csetID, num) AS (SELECT csetID, num FROM CourseSet CSet WHERE NOT EXISTS ((SELECT ks_code FROM missing_skills)MINUS(SELECT ks_code FROM CourseSet_Skill CSSk WHERE CSet.csetID = CSSK.csetID))),minNum(num) as (select min(num)from(select 1, min(num) as num from Cover_CSet group by csetID)group by 1 ),minimal_cset(csetID, num) as(select csetID, num from Cover_CSet where num in(select num from minNum)),needed as(select csetID, num from CourseSet where csetID in ( select csetID from minimal_cset)),prices as(select csetID, total_price from CourseSet where csetID in (select csetID from needed))select csetID, total_price from prices where total_price = (select min(total_price)from prices)");
					for( int itemInd = 0; itemInd < numbers.size(); itemInd++ ){
						s.setInt( itemInd +1, numbers.get( itemInd )  );
					}


					rs = s.executeQuery();
					while(rs.next()){

						int price = rs.getInt(2);
						System.out.println("Minimal cost of training for project is "+price);
					}
					clear();
					rs.close();
				}
				if(x==33){

					System.out.println("Press 1 to look for qualified people. Press 2 for unqualified people. Press 0 to exit.");

					int choice = -11;
					int v = 1;
					while(choice!=1 || choice!=2 || choice!=0){
						if(choice==0){
							break;
						}
						choice = choiceCheck();

						if(choice==1){
							System.out.println("Enter job profile");
							int jp = check(-2873,"pos_code","job_profile");
							PreparedStatement pstmt = conn.prepareStatement("with per_info as(select name,email,ks_code from person natural join per_skill where name not in (select name from job natural join person))select distinct name,email from person S where not exists((select ks_code from required_skill where pos_code = ?) minus (select ks_code from per_info where per_info.name = S.name))");
							pstmt.setInt(1, jp);
							rs = pstmt.executeQuery();

							while(rs.next()){
								String name = rs.getString(1);
								String email = rs.getString(2);
								System.out.println(i+"-NAME: " + name +", EMAIL: " + email);

								i++;
							}
							i=1;
							rs.close();
						}
						if(choice ==2){
							System.out.println("Enter job profile");
							int jp = check(-111,"pos_code","job_profile");
							PreparedStatement pstmt = conn.prepareStatement("with PerSkillMiss as(select person_id, (select count(ks_code) from required_skill where pos_code = ?) - (select count(ks_code) from per_skill PS where P.person_id = PS.person_id and ks_code in (select ks_code from required_skill where pos_code = '1231')) as MissSkCnt from person P where person_id not in (select person_id from job natural join person)group by person_id),per_info as(select name,email,ks_code, person_id from person natural join per_skill where name not in (select name from job natural join person)),people as(select person_id,MissSkCnt from PerSkillMiss where MissSkCnt = (select min(MissSkCnt) from PerSkillMiss)) select distinct name , email , missSkCnt from people natural join per_info");
							pstmt.setInt(1,  jp);
							rs = pstmt.executeQuery();

							while(rs.next()){
								String name = rs.getString(1);
								String email = rs.getString(2);
								int missing = rs.getInt(3);

								System.out.println(i+"-NAME: " + name +", EMAIL: " + email + ", MISSING COUNT: " + missing);

								i++;
							}
							i=1;
							rs.close();
						}

						break;
					}
				}
				if(x==32){
					conn.setAutoCommit(false);

					System.out.println("Enter company ID:");
					int c_id = scanner.nextInt();
					System.out.println("Insert job code:");
					int jc = check(-111, "job_code", "job");
					System.out.println("Insert person id:");
					int pid = check(-111,"person_id","person");
					PreparedStatement pstmt1 = conn.prepareStatement("select pos_code from job where job_code = ?");
					pstmt1.setInt(1, jc);
					rs = pstmt1.executeQuery();

					int jp = -1;
					if(rs.next()){
						jp  = rs.getInt(1);
					}
					rs = null;
					PreparedStatement pstmt = conn.prepareStatement("with PerSkillMiss as(select person_id, (select count(ks_code) from required_skill where pos_code = ?) - (select count(ks_code) from per_skill PS where P.person_id = PS.person_id and ks_code in (select ks_code from required_skill where pos_code = ?)) as MissSkCnt from person P where person_id not in (select person_id from job natural join person)group by person_id),per_info as(select name,email,ks_code, person_id from person natural join per_skill where name not in (select name from job natural join person)),people as(select person_id,MissSkCnt from PerSkillMiss where MissSkCnt = (select min(MissSkCnt) from PerSkillMiss)) select distinct name , email , missSkCnt from people natural join per_info");
					pstmt.setInt(1, jp);
					pstmt.setInt(2, jp);
					rs = pstmt.executeQuery();
					int missing_skills = 3;
					while(rs.next()){
						String name = rs.getString(1);
						String email = rs.getString(2);
						int missing = rs.getInt(3);
						missing_skills = missing;
						System.out.println(i+"-NAME: " + name +", EMAIL: " + email + ", MISSING COUNT: " + missing);

						i++;
					}
					i=1;


					PreparedStatement update16 = conn.prepareStatement("insert into company_hires values(?,?)");
					update16.setInt(1,jc);
					update16.setInt(2, c_id);
					update16.executeUpdate();
					PreparedStatement update15 = conn.prepareStatement("update job set person_id ="+pid+" where job_code = ?");

					update15.setInt(1, jc);
					update15.executeUpdate();

					System.out.println("Person "+ pid + " hired for job "+jc+".");

					if(missing_skills >0 ){

						PreparedStatement s = conn.prepareStatement("with needed as((select RS.ks_code from required_skill RS where RS.pos_code = ?)minus(select ks_code from per_skill where person_id = ?))select distinct c_code, title from course s  where not exists((select ks_code from needed)minus(select ks_code from course natural join skills_covered where s.c_code = c_code))");	 


						PreparedStatement s1 = conn.prepareStatement("Select pos_code from job where job_code = ?");
						s1.setInt(1, jc);
						rs = s1.executeQuery();
						int ch =0;
						if(rs.next())
						{	ch  = rs.getInt(1);
							s.setInt(1, ch);

							s.setInt(2, pid);
							rs =null;
							rs = s.executeQuery();



							while(rs.next()){


								int c_code = rs.getInt(1);
								String title = rs.getString(2);
								System.out.println(i+"-"+"C_CODE: " + c_code+ ", TITLE: " + title);

								i++;
							}

						}
					}
					rs.close();
					conn.commit();
					conn.setAutoCommit(true);
				}
				if(x==31){
					System.out.println("Press 1 to find qualified jobs by person_id or 2 to enter skill codes or 0 to exit");
					scanner = new Scanner(System.in);
					int choice = choiceCheck();
					int v = 1;
					while(choice!=1 || choice!=2 || choice!=0)
					{
						if(choice==0){
							break;
						}
						if(v!=1){
							System.out.println("Press 1 to find qualified jobs by person_id or 2 to enter skill codes or 0 to exit");
							choice = scanner.nextInt();
						}
						v++;
						if(choice ==1){
							PreparedStatement s = conn.prepareStatement("select distinct pos_code from job_profile J where not exists ((select ks_code from job_profile natural join required_skill where pos_code = J.pos_code)MINUS(select ks_code from per_skill where person_id = ?))");
							System.out.println("Please enter Person ID:");
							int ch = -111;
							ch = inputmatcher();
							s.setInt(1, ch);
							rs = s.executeQuery();

							System.out.println("POS_CODE:");

							while(rs.next()){


								int pos_code = rs.getInt(1);
								System.out.println(i+"-" +pos_code);

								i++;
							}

							rs.close();
							break;
						}
						if(choice==2){
							ArrayList<Integer> numbers = new ArrayList<>();
							int condition = -1;
							System.out.println("Type in skills codes. Type 0  when you're done.");
							while(condition != 0){

								int ch = inputmatcher();
								condition = ch;
								if(condition!= 0)
								{
									numbers.add(ch);
								}

							}
							String sqlBase = "";
							for( int id : numbers ){
								if(numbers.indexOf(id)!= numbers.size()-1)
									sqlBase += "?,";
							}
							sqlBase+="?";
							PreparedStatement s = conn.prepareStatement("select distinct pos_code from job_profile J where not exists ((select ks_code from job_profile natural join required_skill where pos_code = J.pos_code)MINUS(select ks_code from knowledge_skill where ks_code in("+sqlBase+")))");
							for( int itemInd = 0; itemInd < numbers.size(); itemInd++ ){
								s.setInt( itemInd +1, numbers.get( itemInd )  );
							}


							rs = s.executeQuery();



							System.out.println("POS_CODE:");

							while(rs.next()){

								int pos_code = rs.getInt(1);

								System.out.printf("%2d-%4d\n",i, pos_code);

								i++;
							}
							rs.close();
						}
					}
				}
				if(x == 30){
					conn.setAutoCommit(false);	
					/**
					  System.out.println("Enter a table to insert into or type list to list the tables. Enter delete to delete from a table");
					  String choice = scanner.nextLine();

					  switch(choice){

					  case "skills_covered":
					  int potato = 13412334;
					  int c_code1 = -1;
					  do{
					  System.out.println("Enter the course code");
					  c_code1 = scanner.nextInt();
					  PreparedStatement s = conn.prepareStatement("select c_code from course where c_code = ?");
					  s.setInt(1, c_code1);
					  rs = s.executeQuery();
					  if(rs.next())
					  potato = rs.getInt(1);
					  }while(c_code1 != potato);


					  int ks_code = -1;
					  int ks_code1 = 2934;
					  do{
					  System.out.println("Enter the ks code");
					  ks_code1 = scanner.nextInt();
					  PreparedStatement s = conn.prepareStatement("select ks_code from knowledge_skill where ks_code = ?");
					  s.setInt(1, ks_code1);
					  rs = s.executeQuery();
					  if(rs.next())
					  ks_code = rs.getInt(1);
					  }while(ks_code1 != ks_code);



					  PreparedStatement s = conn.prepareStatement("insert into skills_covered values(?,?)");

					  s.setInt(1, c_code1);
					  s.setInt(2, ks_code);
					  s.executeUpdate();
					  System.out.println("Inserting into skills_covered....");


					  break;

					  case "knowledge_skill":
					  System.out.println("Enter a ks code");
					  int ks_code11 = inputmatcher(-11);

					  System.out.println("Enter a title");
					  String title1 = scanner.next();

					  System.out.println("Enter a description");
					  String description1 = scanner.next();


					  System.out.println("Enter a level");
					  String level1 = scanner.next();
					  int x3 = 1 ;
					//status
					while(!(level1.contains("beginner") || level1.contains("medium") || level1.contains("advanced"))){
					if(x3==1){
					System.out.println("Enter the course status either beginner or medium or advanced. WATCH SPELLING");
					}
					else{
					System.out.println("Invalid status. Enter active or expired!!!");
					}
					level1 = scanner.next();
					x3++;
					}

					PreparedStatement s1 = conn.prepareStatement("insert into knowledge_skill values(?,?,?,?)");
					s1.setInt(1, ks_code11);
					s1.setString(2, title1);
					s1.setString(3, description1);
					s1.setString(4, level1);
					s1.executeUpdate();
					System.out.println("Inserting into knowledge_skill....");
					break;
					**/
						//case "delete":

						String ch = "";
					while(true){
						System.out.println("Enter query to view the contents of the course table\nEnter delete to delete from the course table.\nEnter update to update the course table.\nEnter insert to insert into the course table.\nTo exit type exit.");
						ch = scanner.nextLine();


						while(!(ch.equals("query") || ch.equals("delete") || ch.equals("exit") || ch.equals("update") || ch.equals("insert"))){

							try{


								System.out.println("Invalid command: Enter query to view the contents of the course table\nEnter delete to delete from the course table.\nEnter update to update the course table.\nEnter insert to insert into the course table.\nTo exit type exit.");
								ch = scanner.next();



							}catch(InputMismatchException e){
								ch = "";
								scanner = new Scanner(System.in);
							}

						}

						if(ch.equals("query")){
							PreparedStatement tomato = conn.prepareStatement(
									"SELECT c_code from course");
							int i2 = 1;
							ResultSet grape = tomato.executeQuery();
							System.out.println(" C_CODES: ");
							while(grape.next()){
								System.out.println(i2 + "-" +grape.getInt(1));
								i2++;
							}
						}else if(ch.equals("delete")){

							int c_code3 = inputmatcher61(-111, "Enter a valid c_code ");
							PreparedStatement delete = conn.prepareStatement(
									"Delete from skills_covered where c_code = ?");
							delete.setInt(1, c_code3);
							delete.executeUpdate();
							delete = conn.prepareStatement(
									"Delete from course where c_code = ?");
							delete.setInt(1, c_code3);
							delete.executeUpdate();
							System.out.println(c_code3);
							System.out.println("Deleting from course table");
							conn.commit();

						}else if(ch.equals("insert")){

							//course
							int c_code = inputmatcher6(-111, "Enter a course code. Must be a number exactly 4 digits long.");
							//title

							String title = inputmatcher5(30 , "Enter a title length must not exceed 30 characters.");

							//status

							//level

							int level2 = 0;

							while(!(level2 == 1000 || level2==2000 || level2 == 3000 || level2 == 4000 || level2 == 5000)){
								try{


									System.out.println("Enter the course level. Either 1000,2000,3000,4000, or 5000");
									level2 = scanner.nextInt();


								}catch(InputMismatchException e){
									level2 = 0;
									scanner = new Scanner(System.in);
								}

							}

							//description

							String description = inputmatcher5(150, "Enter a description. Length must not exceed 150 characters.");

							String status = "woop";
							int x1 = 1 ;
							//status
							while(!(status.contains("active") || status.contains("expired"))){
								if(x1==1){
									System.out.println("Enter the course status either active or expired");
									scanner.nextLine();
								}
								else{
									System.out.println("Invalid status. Enter active or expired!!!");
									status = scanner.nextLine();
								}

								x1++;
							}
							//retail price

							int retail_price = inputmatcher3(-111,"Enter the course retail price. The price must not exceed 4 character.");

							PreparedStatement s2 = conn.prepareStatement("insert into course values(?,?,?,?,?,?)");
							s2.setInt(1, c_code);

							s2.setString(2, title);

							s2.setInt(3, level2);

							s2.setString(4, description);

							s2.setString(5, status);

							s2.setInt(6,retail_price );

							s2.executeUpdate();
							conn.commit();
							System.out.println("Inserting into course....");

							break;

						}else if(ch.equals("update")){
							scanner = new Scanner(System.in);
							//update course set title = 'soireofs sdjf ksj' where c_code = 1583;


							//String update = scanner.next();


							String update1 = new String();

							while(!(update1.equals("title") || update1.equals("lvl") ||update1.equals("description") || update1.equals("status") || update1.equals("retail_price"))){
								try{
									System.out.println("Enter a column to update: title, lvl, description, status, or retail_price.");

									update1 = scanner.nextLine();

								}catch(InputMismatchException e){
									update1 = "";
									scanner = new Scanner(System.in);
								}

							}

							//System.out.println("Enter a course code to update");
							int c_code4 = inputmatcher61(-111,"Enter a course code to update");
							//works
							if(update1.equals("title")){


								String title_update = inputmatcher5(30, "Enter a new title to insert must be 30 characters long");
								title_update = "\'" + title_update + "\'";
								PreparedStatement update10 = conn.prepareStatement(
										"update course set title = "+title_update+" where c_code = ?");
								update10.setInt(1, c_code4);
								update10.executeUpdate();
								System.out.println("Updating title...");

							}else if(update1.equals("lvl")){

								System.out.println("Enter a new lvl: 1000,2000,3000,4000,5000");


								String update_lvl = scanner.nextLine();

								//status
								while(!(update_lvl.contains("1000") || update_lvl.contains("2000") || update_lvl.contains("3000") || update_lvl.contains("4000") || update_lvl.contains("5000"))){

									System.out.println("Enter a valid level");
									scanner.nextLine();

								}

								PreparedStatement update10 = conn.prepareStatement(
										"update course set lvl = "+update_lvl+" where c_code = ?");

								update10.setInt(1, c_code4);
								update10.executeUpdate();
								//conn.commit();
								System.out.println("Updating course lvl...");

								//works	
							}else if(update1.equals("description")){



								String description2 = inputmatcher5(150, "Enter a description. Length must not exceed 150 characters.");

								description2 = "\'" + description2 + "\'";

								PreparedStatement update11 = conn.prepareStatement(
										"update course set description = "+description2+" where c_code = ?");

								update11.setInt(1, c_code4);
								update11.executeUpdate();
								System.out.println("Updating course description....");


								//works							
							}else if(update1.equals("status")){

								System.out.println("Enter either active or expired");
								scanner = new Scanner(System.in);
								String status1 = scanner.nextLine();

								while(!status1.equals("active") && !status1.equals("expired")){

									scanner = new Scanner(System.in);
									System.out.println("Enter a valid status");
									status1 = scanner.nextLine();
								}

								status1 = "\'" + status1 + "\'";

								PreparedStatement update12 = conn.prepareStatement(
										"update course set status = "+status1+" where c_code = ?");

								update12.setInt(1, c_code4);

								update12.executeUpdate();

								System.out.println("Updating course status to " + status1 + ".....");


							}else if(update1.equals("retail_price")){


								int price = inputmatcher3(-111,"Enter the course retail price. The price must not exceed 4 digits.");


								PreparedStatement update15 = conn.prepareStatement(
										"update course set retail_price = "+price+" where c_code = ?");

								update15.setInt(1, c_code4);
								update15.executeUpdate();
								System.out.println("Updating the retail price");
							}

							conn.commit();
						}else if(ch.equals("exit")){
							ch = "";
							break;
						}


					}


					/**	
					  case "job_profile":
					  break;
					  case "section":
					  break;
					  case "student_schedule":
					  break;
					  case "person":
					  break;
					  case "per_skill":
					  break;
					  case "project":
					  break;
					  case "job":
					  break;
					  case "company":
					  break;
					  case "company_hires":
					  break;
					  case "speciality":
					  break;
					  default:
					  System.out.println("Invalid choice try again");
					  break;
					 **/




				}

				if(x == 1 ){


					PreparedStatement s = conn.prepareStatement(
							"SELECT name FROM person natural join company_hires natural join job WHERE comp_id = ?");



					System.out.println("Please enter Company ID:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1,ch);

					rs = s.executeQuery();
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
					PreparedStatement s = conn.prepareStatement(
							"select name, pay_rate from person natural join company_hires natural join job where comp_id = ? and pay_type = 'salary' order by pay_rate DESC");




					int ch = -111;
					System.out.println("Enter Company ID:");
					ch = inputmatcher();
					s.setInt(1,ch);


					rs = s.executeQuery();
					while(rs.next()){


						String name = rs.getString(1);
						int pay_rate = rs.getInt(2);
						System.out.println(i+"-"+"NAME: " + name + ", PAY_RATE: " + pay_rate);


					}

					rs.close();
				}

				if(x==3)
				{

					sql = "with SALARY AS (select comp_id, sum(pay_rate) as worker_salary from job natural join company_hires where pay_type = 'salary' group by comp_id), WAGE AS (select comp_id, sum(pay_rate*1920) as worker_salary from job natural join company_hires where pay_type = 'wage' group by comp_id), salary_wage as((select * from SALARY) union (select * from WAGE) )select comp_id,sum(worker_salary) as total_worker_cost from salary_wage group by comp_id order by total_worker_cost DESC";

					rs = stmt.executeQuery(sql);



					while(rs.next()){


						int comp_id = rs.getInt(1);
						int worker_cost = rs.getInt(2);
						System.out.println(i+"-"+"COMP_ID: " + comp_id + ", WORKER_COST: " + worker_cost);


					}

					rs.close();
				}
				if(x==4)
				{
					PreparedStatement s = conn.prepareStatement("select job_code from person natural join job where person_id = ?");



					int ch = -111;
					System.out.println("Enter Person ID:");
					ch = inputmatcher();
					s.setInt(1, ch);
					rs = s.executeQuery();

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
					PreparedStatement s = conn.prepareStatement("select distinct person_id from project natural join job where project_id = ?");
					int ch = -111;
					System.out.println("Enter Project ID:");
					ch = inputmatcher();
					s.setInt(1, ch);
					rs = s.executeQuery();

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


					PreparedStatement s = conn.prepareStatement( "select ks_code from natural join per_skill where person_id = ?");

					int ch = -111;
					System.out.println("Enter Person ID:");
					ch = inputmatcher();
					s.setInt(1, ch);
					rs = s.executeQuery();

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
					PreparedStatement s = conn.prepareStatement("(select ks_code from required_skill natural join job where person_id = ?) minus (select ks_code from per_skill where person_id = ?)");

					int ch = -111;
					System.out.println("Enter Person ID:");
					ch = inputmatcher();
					s.setInt(1, ch);
					s.setInt(2, ch);
					rs = s.executeQuery();

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


					PreparedStatement s = conn.prepareStatement("select ks_code from required_skill where pos_code = ?");


					int ch = -111;
					System.out.println("Enter Position ID:");
					ch = inputmatcher();
					s.setInt(1, ch);
					rs = s.executeQuery();

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


					PreparedStatement s = conn.prepareStatement("(select ks_code from required_skill natural join job where pos_code = ?) minus (select ks_code from per_skill where person_id = ?)");




					int ch = -111;
					System.out.println("Enter Position ID:");
					ch = inputmatcher();
					s.setInt(1, ch);
					int ch1 = -111;
					System.out.println("Enter Person ID:");
					ch1 = inputmatcher();
					s.setInt(2, ch);		
					rs = s.executeQuery();

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


					ArrayList<Integer> numbers = new ArrayList<>();
					int condition = -1;	 
					System.out.println("Type in skill sets. Type 0 to execute with current skills.");
					while(condition != 0){

						int ch = inputmatcher();
						condition = ch;
						if(condition!= 0)
						{
							numbers.add(ch);
						}

					}
					String sqlBase = "";
					for( int id : numbers ){
						if(numbers.indexOf(id)!= numbers.size()-1)
							sqlBase += "?,";
					}
					sqlBase+="?";
					PreparedStatement s = conn.prepareStatement("select distinct s.c_code from skills_covered s where not exists((select ks_code from knowledge_skill where ks_code in ("+sqlBase+"))minus(select ks_code from course natural join skills_covered where s.c_code = c_code))");
					for( int itemInd = 0; itemInd < numbers.size(); itemInd++ ){
						s.setInt( itemInd +1, numbers.get( itemInd ) );
					}

					rs = s.executeQuery();
					System.out.println("   C_code");
					while(rs.next()){


						int c_code = rs.getInt(1);
						System.out.println(i+"-"+ "   " + c_code);

						i++;
					}

					rs.close();


				}







				if(x==11)
				{



					PreparedStatement s = conn.prepareStatement("with needed as((select RS.ks_code from required_skill RS where RS.pos_code = ?)minus(select ks_code from per_skill where person_id = ?))select distinct c_code, title from course s  where not exists((select ks_code from needed)minus(select ks_code from course natural join skills_covered where s.c_code = c_code))");	 



					int ch = -111;
					System.out.println("Enter Position ID:");
					ch = inputmatcher();
					s.setInt(1, ch);
					int ch1 = -111;
					System.out.println("Enter Person ID:");
					ch1 = inputmatcher();
					s.setInt(2, ch1);

					rs = s.executeQuery();



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

					PreparedStatement s = conn.prepareStatement("with missing_skills as((select ks_code from required_skill where pos_code = ?)minus(select ks_code from person natural join per_skill where person_id = ?)),course_needed as(select distinct c_code, title from course s where not exists((select ks_code from missing_skills)minus(select ks_code from course natural join skills_covered where s.c_code = c_code)))select c_code, comp_date from course_needed natural join section where comp_date = (select min(comp_date)from course_needed natural join section group by c_code)");    

					int ch = -111;
					System.out.println("Enter Position ID:");

					s.setInt(1, ch);
					int ch1 = -111;
					System.out.println("Enter Person ID:");
					ch1 = inputmatcher();
					s.setInt(2, ch1); 
					rs = s.executeQuery();



					while(rs.next()){


						int c_code = rs.getInt(1);
						String date = rs.getString(2);
						System.out.println(i+"-C_CODE:" +c_code + ", DATE:" + date);

						i++;
					}

					rs.close();
				}
				if(x==13)
				{


					conn.setAutoCommit(false);	

					updateStatments();



					int count = 1;
					ArrayList<Integer> numbers = new ArrayList<>();
					int condition = -1;
					System.out.println("Type in skill sets. Type 0 to execute with current skills.");
					while(condition != 0){

						int ch = inputmatcher();
						condition = ch;
						if(condition!= 0)
						{
							numbers.add(ch);
						}

					}
					String sqlBase = "";
					for( int id : numbers ){
						if(numbers.indexOf(id)!= numbers.size()-1)
							sqlBase += "?,";
					}
					sqlBase+="?";
					PreparedStatement s = conn.prepareStatement("WITH CourseSet_Skill(csetID, ks_code) AS (SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code1=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code2=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code3=CS.c_code),missing_skills as (select ks_code from knowledge_skill where ks_code in (" +sqlBase+")),Cover_CSet(csetID, num) AS (SELECT csetID, num FROM CourseSet CSet WHERE NOT EXISTS ((SELECT ks_code FROM missing_skills)MINUS(SELECT ks_code FROM CourseSet_Skill CSSk WHERE CSet.csetID = CSSK.csetID))), minNum(num) as (select min(num) from(select 1, min(num) as num from Cover_CSet group by csetID)group by 1),minimal_cset(csetID, num) as(select csetID, num from Cover_CSet where num in(select num from minNum))select csetID, num from CourseSet where csetID in ( select csetID from minimal_cset)");
					for( int itemInd = 0; itemInd < numbers.size(); itemInd++ ){
						s.setInt( itemInd +1, numbers.get( itemInd )  );
					}


					rs = s.executeQuery();



					System.out.println("CSETID:   " + "NUM");

					while(rs.next()){

						int cset_id = rs.getInt(1);
						int num = rs.getInt(2);
						System.out.printf("%2d-%2d  %4d\n",i, cset_id,num);

						i++;
					}
					clear();
					conn.commit();
					rs.close();

				}
				if(x==14)
				{

					PreparedStatement s = conn.prepareStatement("WITH CourseSet_Skill(csetID, ks_code) AS (SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code1=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code2=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code3=CS.c_code),missing_skills as ((select ks_code from required_skill j where pos_code = ?)MINUS(select ks_code from per_skill KS where person_id = ?))SELECT csetID, num FROM CourseSet CSet WHERE NOT EXISTS ((SELECT ks_code FROM missing_skills)MINUS(SELECT ks_code FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID))");


					System.out.println("Please enter Position Code:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1, ch);


					System.out.println("Please enter Person Id:");
					int ch1 = -111;
					ch = inputmatcher();
					s.setInt(2, ch1);

					conn.setAutoCommit(false);
					updateStatments();
					rs = s.executeQuery();

					System.out.println("CSETID:" + "   NUM");

					while(rs.next()){


						int csetid = rs.getInt(1);
						int num = rs.getInt(2);
						System.out.println(i+"-" +csetid + "      " + num);

						i++;
					}
					clear();
					conn.commit();
					rs.close();
				}
				if(x==15)
				{
					conn.setAutoCommit(false);
					updateStatments2();
					PreparedStatement s = conn.prepareStatement("WITH CourseSet_Skill(csetID, ks_code) AS (SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code1=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code2=CS.c_code UNION SELECT csetID, ks_code FROM CourseSet CSet JOIN skills_covered CS ON CSet.c_code3=CS.c_code), missing_skills as ((select ks_code from required_skill j where pos_code = ?)  MINUS (select ks_code from per_skill KS where person_id = ?)), Cover_CSet(csetID, num) AS (SELECT csetID, num FROM CourseSet CSet WHERE NOT EXISTS ((SELECT ks_code FROM missing_skills) MINUS (SELECT ks_code FROM CourseSet_Skill CSSk WHERE CSSk.csetID = Cset.csetID))), needed as(select c_code1, c_code2, c_code3, total_price from CourseSet where csetID in(select csetID from Cover_CSet) order by total_price ASC) select c_code1, c_code2, c_code3, total_price from needed where total_price = (select min(total_price) from (select 1, total_price from needed) group by 1)");

					System.out.println("Please enter Position Code:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1, ch);


					System.out.println("Please enter Person Id:");
					int ch1 = -111;
					ch = inputmatcher();
					s.setInt(2, ch1);
					rs = s.executeQuery();
					System.out.println("   c_code1  " + " c_code2  " + " c_code3  " + "total_price");
					while(rs.next()){


						int c_code1 = rs.getInt(1);
						int c_code2 = rs.getInt(2);
						int c_code3 = rs.getInt(3);
						int total_min_price = rs.getInt(4);
						System.out.println(i+"- " + "   " + c_code1 + "   " + c_code2 + "      " + c_code3 + "        " + total_min_price);

						i++;
					}
					clear();
					conn.commit();
					rs.close();
				}


				if(x==16)
				{

					PreparedStatement s = conn.prepareStatement("select distinct pos_code from job_profile J where not exists ((select ks_code from job_profile natural join required_skill where pos_code = J.pos_code)MINUS(select ks_code from per_skill where person_id = ?))");
					System.out.println("Please enter Person ID:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1, ch);
					rs = s.executeQuery();

					System.out.println("POS_CODE:");

					while(rs.next()){


						int pos_code = rs.getInt(1);
						System.out.println(i+"-" +pos_code);

						i++;
					}

					rs.close();
				}
				if(x==17){

					PreparedStatement s = conn.prepareStatement("with eligible_jobs as(select distinct pos_code from job_profile J where not exists ((select ks_code from job_profile natural join required_skill where pos_code = J.pos_code) MINUS(select ks_code from per_skill where person_id = ?)))select pos_code from eligible_jobs natural join job where pay_rate = (select max(pay_rate) from job natural join eligible_jobs)");


					System.out.println("Please enter Person ID:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1, ch);


					rs = s.executeQuery();

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

					PreparedStatement s = conn.prepareStatement("with per_info as(select name,email,ks_code from person natural join per_skill where name not in (select name from job natural join person))select distinct name,email from person S where not exists((select ks_code from required_skill where pos_code = ?) minus (select ks_code from per_info where per_info.name = S.name))");



					System.out.println("Please enter Position Code:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1, ch);
					rs = s.executeQuery();



					while(rs.next()){


						String name = rs.getString(1);
						String email = rs.getString(2);
						System.out.println(i+"-" +"NAME: " + name + ", EMAIL: " + email);

						i++;
					}

					rs.close();
				}
				if(x==19){


					PreparedStatement s = conn.prepareStatement("WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (SELECT distinct person_id, COUNT(ks_code) as skillCnt FROM per_skill where ks_code in (select ks_code from required_skill where pos_code = ?) and person_id not in (select person_id from job natural join person)GROUP BY person_id),PosSkillCnt(pos_code, skillCnt) AS (select pos_code, COUNT(unique ks_code) as skillCnt from required_skill where pos_code = ? group by pos_code)select p.person_id from person P where 1 = ((select skillCnt from PosSkillCnt)-(select skillCnt from PersonRequiredSkillCnt PRSC where P.person_id = PRSC.person_id))");					

					System.out.println("Please enter Position Code:");
					int ch = -111;	
					ch = inputmatcher();
					s.setInt(1, ch);
					s.setInt(2, ch);
					rs = s.executeQuery();

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


					PreparedStatement s = conn.prepareStatement("WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (SELECT distinct person_id, COUNT(ks_code) as skillCnt FROM per_skill natural join person where ks_code in (select ks_code from required_skill where pos_code = ?) and person_id not in (select person_id from job natural join person) GROUP BY person_id),PosSkillCnt(pos_code, skillCnt) AS (select pos_code, COUNT(unique ks_code) as skillCnt from required_skill where pos_code = ? group by pos_code),PeopleMissingOne AS (select p.person_id from person P where 1 = ((select skillCnt from PosSkillCnt) - (select skillCnt from PersonRequiredSkillCnt PRSC where P.person_id = PRSC.person_id))),SkillsNedded as ((select person_id, ks_code from PeopleMissingOne,required_skill where pos_code = ?) minus (select person_id,ks_code from PeopleMissingOne natural JOIN per_skill))select ks_code, count(person_id) as missing_One_Count from SkillsNedded group by ks_code order by count(person_id) ASC");



					System.out.println("Please enter Position Code:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1, ch);
					s.setInt(2, ch);
					s.setInt(3, ch);

					rs = s.executeQuery();

					System.out.println("     KS_CODE:" + "  PERSON_COUNT");

					while(rs.next()){

						int ks_code = rs.getInt(1);
						int person_id = rs.getInt(2);

						// System.out.println(i + "-"+"KS_CODE: " + ks_code + " PERSON_ID: " + person_id);

						System.out.printf("%1d-%9d  %4d\n",i, ks_code,person_id);

						i++;
					}

					rs.close();
				}

				if(x==21)
				{


					PreparedStatement s = conn.prepareStatement("with PerSkillMiss as(select person_id, (select count(ks_code) from required_skill where pos_code = ?) - (select count(ks_code) from per_skill PS where P.person_id = PS.person_id and ks_code in (select ks_code from required_skill where pos_code = ?)) as MissSkCnt from person P group by person_id)select person_id,MissSkCnt from PerSkillMiss where MissSkCnt = (select min(MissSkCnt) from PerSkillMiss)");



					System.out.println("Please enter Position Code:");
					int ch = -111;
					ch = inputmatcher();
					s.setInt(1, ch);
					s.setInt(2, ch);
					rs = s.executeQuery();

					System.out.println("  PERSON_ID:  " + "MissSkCnt");

					while(rs.next()){

						int person_id = rs.getInt(1);
						int skCnt = rs.getInt(2);

						System.out.printf("%2d-%8d  %4d\n",i, person_id,skCnt);


						i++;
					}

					rs.close();
				}

				//finished
				if(x==22)
				{

					PreparedStatement s = conn.prepareStatement("WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (SELECT distinct person_id, COUNT(ks_code) as skillCnt FROM per_skill where ks_code in (select ks_code from required_skill where pos_code = ?) and person_id not in (select person_id from job natural join person)GROUP BY person_id),PosSkillCnt(pos_code, skillCnt) AS (select pos_code, COUNT(unique ks_code) as skillCnt from required_skill where pos_code = ? group by pos_code),PeopleMissingOne AS (select p.person_id from person P where ? >= ((select skillCnt from PosSkillCnt) - (select skillCnt from PersonRequiredSkillCnt PRSC where P.person_id = PRSC.person_id))),SkillsNedded as ((select person_id, ks_code from PeopleMissingOne,required_skill where pos_code = ?)minus (select person_id,ks_code from PeopleMissingOne natural JOIN per_skill ))select person_id, count(ks_code) as missing_One_Count from SkillsNedded group by person_id order by count(person_id) ASC");


					System.out.println("Please enter Position Code:");
					int ch = -111;
					ch = inputmatcher();

					System.out.println("Please enter a K value:");
					int ch1 = -111;
					ch1 = inputmatcher();
					s.setInt(1, ch);
					s.setInt(2, ch);
					s.setInt(3, ch1);
					s.setInt(4, ch);

					rs = s.executeQuery();

					System.out.println("   PERSON_ID    " + "COUNT_KS");
					while(rs.next()){

						int person_id = rs.getInt(1);
						int count_ks_code = rs.getInt(2);
						// System.out.println(i+"-"+"PERSON_ID: " + person_id + ", COUNT_KS_CODE: " + count_ks_code);
						System.out.printf("%2d-%9d  %4d\n",i, person_id,count_ks_code);
						i++;
					}

					rs.close();
				}

				//working
				if(x==23)
				{
					PreparedStatement s = conn.prepareStatement("WITH PersonRequiredSkillCnt(person_id, skillCnt) AS (SELECT distinct person_id, COUNT(ks_code) as skillCnt FROM per_skill natural JOIN person where ks_code in (select ks_code from required_skill where pos_code = ?) and person_id not in (select person_id from job natural join person) GROUP BY person_id),PosSkillCnt(pos_code, skillCnt) AS (select pos_code, COUNT(unique ks_code) as skillCnt from required_skill where pos_code = ? group by pos_code),PeopleMissingOne AS (select p.person_id from person P where ? >= ((select skillCnt from PosSkillCnt)-(select skillCnt from PersonRequiredSkillCnt PRSC where P.person_id = PRSC.person_id))),SkillsNedded as ((select person_id, ks_code from PeopleMissingOne,required_skill where pos_code = ?) minus (select person_id,ks_code from PeopleMissingOne natural JOIN per_skill))select distinct ks_code, count(person_id) as missing_One_Count from SkillsNedded group by ks_code order by count(person_id) DESC");



					System.out.println("Please enter Position Code:");
					int ch = -111;
					ch = inputmatcher();

					System.out.println("Please enter a K value:");
					int ch1 = -111;
					ch1 = inputmatcher();

					s.setInt(1, ch);
					s.setInt(2, ch);
					s.setInt(3, ch1);
					s.setInt(4, ch);

					rs = s.executeQuery();
					System.out.println("     KS_CODE" + "   COUNT_PERSON");
					while(rs.next()){

						int count_person = rs.getInt(2);
						int ks_code = rs.getInt(1);

						System.out.printf("%2d-%9d  %4d\n",i, ks_code,count_person);

						i++;
					}

					rs.close();
				}
				if(x==24)
				{

					sql = "with open_positions as (select pos_code, count(job_code) as openings from job where person_id is null group by pos_code), pos_ks as(select pos_code, ks_code, person_id  from open_positions natural join required_skill natural join per_skill), qual_people as(select distinct pos_code, person_id from pos_ks KS group by pos_code, person_id having count(ks_code) = (select count(ks_code) from required_skill RS group by pos_code having RS.pos_code= KS.pos_code)), pos_qual as (select pos_code, count(person_id) as people from qual_people group by pos_code), pos as( select pos_code, (openings - people) as difference from open_positions natural join pos_qual)select distinct pos_code, people from pos natural join pos_qual where difference = (select max(difference) from (select 1, difference from pos))";

					rs = stmt.executeQuery(sql);
					System.out.println("   POS_CODE:     PEOPLE:");

					while(rs.next()){
						int people = rs.getInt(2);
						int pos_code = rs.getInt(1);
						System.out.printf("%2d-  %4d,    %4d\n",i, pos_code, people);

						i++;
					}

					rs.close();
				}
				if(x==25)
				{
					sql = "with open_positions as (select pos_code, count(job_code) as openings from job where person_id is null group by pos_code),pos_ks as(select pos_code, ks_code, person_id from open_positions natural join required_skill natural join per_skill),qual_people as(select distinct pos_code, person_id from pos_ks KS group by pos_code, person_id having count(ks_code) = (select count(ks_code) from required_skill RS group by pos_code having RS.pos_code= KS.pos_code)),pos_qual as (select pos_code, count(person_id) as people from qual_people group by pos_code),pos as(select pos_code, (openings - people) as difference from open_positions natural join pos_qual),largest_job_opening as(select distinct pos_code, people from pos natural join pos_qual where difference = (select max(difference) from (select 1, difference from pos)))select distinct c_code from largest_job_opening natural join required_skill natural join skills_covered";		
					rs = stmt.executeQuery(sql);
					System.out.println("   C_CODE: ");

					while(rs.next()){

						int c_code = rs.getInt(1);
						System.out.printf("%2d-  %4d\n",i, c_code);

						i++;
					}

					rs.close();
				}
				}
				stmt.close();
				conn.close();
				scanner.close();

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
