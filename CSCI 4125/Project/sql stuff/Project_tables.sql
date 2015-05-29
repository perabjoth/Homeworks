create table course
	( c_code numeric(4),
	title varchar(30) not null,
	lvl numeric(4),
	description varchar(150),
	status varchar(7) check (status in ('active', 'expired')) not null,
	retail_price varchar(4),
	primary key (c_code)
	);

create table skills_covered
	(c_code numeric(4),
	ks_code numeric(4),
	primary key (c_code, ks_code),
	foreign key (c_code) references course on delete set null
	foreign key(ks_code) references skills_covered on delete set null 
	);

create table knowledge_skill
	(
	ks_code numeric(4),
	title varchar(25) not null,
	description varchar(150),
	lvl varchar(8) check (lvl in ('beginner', 'medium', 'advanced')),
	primary key (ks_code),
	
	);

create table per_skill
	(
	person_id numeric(4),
	ks_code numeric(4),
	primary key (person_id,ks_code),
	foreign key (person_id) references person,
	foreign key (ks_code) references knowledge_skill
	);

create table required_skill
	(
		ks_code numeric(4),
		pos_code numeric(4),
		primary key (ks_code, pos_code),
		foreign key (pos_code) references job_profile on delete set null
	    foreign key(ks_code) references knowledge_skill on delete set null /*may not be necessary*/
	);



create table job_profile
	(
		pos_code numeric(4),
		title varchar(25) not null,
		description varchar(150),
		primary key (pos_code)
	);

create table section
	(
		c_code numeric(4),
		sec_no numeric(3),
		year numeric(4),
		semester varchar(6)
		comp_date end_date date,
		check (semester in ('Fall', 'Winter', 'Spring', 'Summer')), 
		primary key (c_code, sec_no, year, semester),
		foreign key (c_code) references course
	);

create table student_schedule
	(
		person_id numeric(4),
		c_code numeric(4),
		sec_no numeric(3),
		year numeric(4),
		semester varchar(6),
		check (semester in ('Fall', 'Winter', 'Spring', 'Summer')), 
		primary key (person_id, c_code, sec_no, year, semester),
		foreign key (c_code,sec_no,year,semester) references section on delete cascade
	);

create table person
	(
		person_id numeric(4),
		name varchar(40) not null,
		address varchar(100) not null,
		zip_code numeric(5) not null,
		email varchar(50) not null,
		gender varchar(6) check (gender in ('male', 'female')) not null,
		primary key (person_id)
	);

create table phone_number
	(
		person_id numeric(4),
		phone_num numeric(10) not null,
		primary key (person_id, phone_num),
		foreign key (person_id) references person on delete set null
	);

create table project 
	(
		project_id numeric(4),
		director varchar(25) not null,
		budget_code numeric(4) not null,
		start_date date not null,
		end_date date,
		company varchar(40),
		primary key (project_id)
	);

create table job
	(
		pos_code numeric(4),
		person_id numeric(4),
		job_code numeric(4),
		project_id numeric(4),
		type varchar(9) check( type in ('full-time', 'part-time')) not null,
		pay_rate varchar(10),
		pay_type varchar(6) check(pay_type in ('wage', 'salary')) not null,
		primary key (job_code),
		foreign key (pos_code) references job_profile on delete set null,
		foreign key (person_id) references person on delete set null,
		foreign key (project_id) references project on delete set null
	);
	
create table company_hires
	(
	job_code numeric(4),
	comp_id numeric(4),
	primary key (job_code,comp_id),
	foreign key(comp_id) references company,
	foreign key (job_code) references job on delete set null
	);

create table company
	(select
		comp_id numeric(4),
		address varchar(100) not null,
		zip_code numeric(5) not null,
		website varchar(100),
		primary key (comp_id)
	);

create table specialty 
	(
		comp_id numeric(4),
		specialty varchar(17) check(specialty in ('construction', 'logistics service', 'computer hardware', 'software', 'electronics', 'basic materials', 'IT consulting', 'transportation')) not null,
		primary key (comp_id,specialty),
		foreign key (comp_id) references company on delete set null
	);

create table company_funds
	(
		comp_id numeric(4),
		proj_id numeric(4),
		primary key (comp_id, proj_id),
		foreign key (comp_id) references company on delete set null,
		foreign key (proj_id) references project on delete set null
	);
