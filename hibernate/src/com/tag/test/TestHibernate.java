package com.tag.test;


import java.util.Iterator;

import com.tag.model.Project;
import com.tag.model.Student;
import com.tag.templates.HibernateTemplate;

public class TestHibernate {

	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		
		/* example for one-to-one and basic annotation and custiom id generations*/
		/*Department dept=new Department();
		dept.setDeptName("op");
		
		Employee emp=new Employee();
		emp.setEmpName("rajasekhar");
		emp.setEmpDesignation("tester");
		emp.setJoinDate(new Date());
		emp.setDepartment(dept);
		hibernateTemplate.save(emp);
			
		
		Department dept1=new Department();
		dept1.setDeptName("gd");
		
		Employee emp1=new Employee();
		emp1.setEmpName("sekhar");
		emp1.setEmpDesignation("sadasd");
		emp1.setJoinDate(new Date());
		emp1.setDepartment(dept1);
		System.out.println("object saved");
		hibernateTemplate.save(emp1);
		
		Department dept2=new Department();
		dept2.setDeptName("sales");
		
		Employee emp2=new Employee();
		emp2.setEmpName("avinash");
		emp2.setEmpDesignation("sadasd");
		emp2.setJoinDate(new Date());
		emp2.setDepartment(dept2);
		System.out.println("object saved");
		hibernateTemplate.save(emp2);
		
		List<Employee> empList= (List<Employee>) hibernateTemplate.findAllByQueryName("employee.findAll");
		System.out.println(empList);
		
		for(Employee e:empList){
		System.out.println(e.getEmpName());
		}
		
		
		List empName=  hibernateTemplate.findAllByQueryName("employee.findName");
		System.out.println(empName);
		
		for(Object e:empName){
			System.out.println(e);
		}*/
		
		
		
		
		/*EmployeeDetails eDetails=new EmployeeDetails();
		eDetails.setFirstName("rajsekhar");
		eDetails.setLastName("arimanda");
		eDetails.setJoiningDate(new  Date());
		eDetails.setSalary(4000.0f);
		
		hibernateTemplate.save(eDetails);*/
		/*
		EmployeeDetails eDetails1=new EmployeeDetails();
		eDetails1.setFirstName("avinash");
		eDetails1.setLastName("karumuri");
		eDetails1.setSalary(8000.0f);
		
		hibernateTemplate.save(eDetails1);*/
		
		/*List<Student> studentsList=new ArrayList<Student>();
		Student student=new Student();
		student.setStudentName("ramcharan");
		
		Student student1=new Student();
		student1.setStudentName("alluarjun");
		
		Student student2=new Student();
		student2.setStudentName("pawankalyan");
		
		studentsList.add(student);
		studentsList.add(student1);
		studentsList.add(student2);
		
		College colleage=new College();
		colleage.setCollegeName("mega");
		colleage.setStudents(studentsList);
		
		
		hibernateTemplate.save(colleage);*/
		
		/*
		 secoundray table annotaion exampel for storing data in two table with single table with dynamic insert and update
		 * */
		
		/*Person p=new Person();
		p.setPersionName("satyam");
		p.setPersionState("ap");
		p.setPersionCity("tel");
		
		hibernateTemplate.save(p);
		
		Person p1=new Person();
		p1.setPersionName("raghu");
		p1.setPersionState("ap");
		p1.setPersionCity("vij");
		
		hibernateTemplate.save(p1);*/
		
		/*
		 * save will wrk out of transcatiobn boundry and persist will wrk with in tr boundry
		 * Student s=new Student();
		s.setStudentName("badri");
		hibernateTemplate.persist(s);*/
		
		
		/* 
		 * one to many exaple
		 * */
		
		
		/*
		 * onw to many mapping entity must have default con and its not a final class
		 * TestOrder testOreder=new TestOrder();
		testOreder.setName("rajase");
		
		TestOrder testOreder1=new TestOrder();
		testOreder1.setName("avinash");
		
		TestCustomer testCust=new TestCustomer();
		testCust.setCustName("tag");
		testCust.setTestOrder(new ArrayList<TestOrder>());
		testCust.getTestOrder().add(testOreder);
		testCust.getTestOrder().add(testOreder1);
		
		hibernateTemplate.save(testCust);
		
		List<TestCustomer> list=(List<TestCustomer>) hibernateTemplate.findAll(TestCustomer.class);
		
		System.out.println(list.size());
		for(TestCustomer tc:list)
		{
			System.out.println("asdsads"+tc.getCustName());
		}*/
		
		
		/*
		 * bag example with one to many
		States st=new States();
		st.setName("delhi");
		
		States st1=new States();
		st1.setName("chennai");
		
		States st2=new States();
		st2.setName("hyd");
		
		States st3=new States();
		st3.setName("bang");
		
		Map<Integer,States> mapStaes=new HashMap<Integer,States>();
		
		mapStaes.put(1, st);
		mapStaes.put(2, st1);
		mapStaes.put(3, st2);
		mapStaes.put(5, st3);
		
		Country ctry=new Country();
		ctry.setCountry("india");
		ctry.setMapStates(mapStaes);
		
		hibernateTemplate.save(ctry);
		
		
		List<Country> list=(List<Country>) hibernateTemplate.findAll(Country.class);
		
		Map<Integer, States> map= list.get(0).getMapStates();
		
			
		for(Entry<Integer, States> e:map.entrySet()){
			System.out.println(e.getKey()+"   state   "+e.getValue().getName());
		}*/
		
		/* custom sort comparator with one to many
		
		Developers dev=new Developers();
		dev.setDevName("raj");
		dev.setSal(1000000);

		Developers dev1=new Developers();
		dev1.setDevName("sekhar");
		dev1.setSal(200);

		Developers dev2=new Developers();
		dev2.setDevName("avi");
		dev2.setSal(50000);
		
		SortedSet<Developers> developersSet=new TreeSet<Developers>();
		developersSet.add(dev);
		developersSet.add(dev1);
		developersSet.add(dev2);
		
		
		Project proj=new Project();
		proj.setProjName("kpl");
		proj.setDevelopersSet(developersSet);
		
		hibernateTemplate.save(proj);
		
		List<Project> list=(List<Project>) hibernateTemplate.findAll(Project.class);
		
		Iterator<Developers> d= list.get(0).getDevelopersSet().iterator();
			
		while(d.hasNext())
			System.out.println(d.next().getDevName());
		
		 */
		
		/* deffrence between query.list and query.iterator 
		 * 
		 * iterator initially get id values and when we try to get pertivluler proj it try to exc select query with where clause
		 * 
		 * This will only usually be the case if you expect that the actual entity instances returned by the query will already be in the session or second-level cache. If they are not already cached, iterate() will be slower than list() and might require many database hits for a simple query, usually 1 for the initial select which only returns identifiers, and n additional selects to initialize the actual instances.
		 *  */
		/*List<Project> projList=(List<Project>) hibernateTemplate.findAll(Project.class);
		
		Iterator<Project> projItr=projList.iterator();
		
		while(projItr.hasNext())
			System.out.println("getting data using list  "+projItr.next().getDevelopersSet().first().getDevName());*/
		
		
		
		/*Iterator<Project> projItr1=(Iterator<Project>) hibernateTemplate.findAllWithIterator(Project.class);
		
		while(projItr1.hasNext()){
			System.out.println("getting data using iterator  "+projItr1.next().getProjName());
		}*/
		
/*		Iterator<Project> p= (Iterator<Project>) hibernateTemplate.findWithCriteris(Project.class).iterator();
		
		while(p.hasNext())
			System.out.println(p.next().getProjName());
		
		
		
		
		Iterator<Project> projItr1=(Iterator<Project>) hibernateTemplate.findAll(Project.class).iterator();
		
		while(projItr1.hasNext()){
			System.out.println("getting data using iterator  "+projItr1.next().getProjName());
		}
		
		Iterator<Project> projItr2=(Iterator<Project>) hibernateTemplate.findAll(Project.class).iterator();
		
		while(projItr2.hasNext()){
			System.out.println("getting data using iterator  "+projItr2.next().getProjName());
		}
		
		Iterator<Project> projItr3=(Iterator<Project>) hibernateTemplate.findAllWithIterator(Project.class);
		
		while(projItr3.hasNext()){
			System.out.println("getting data using iterator  "+projItr3.next().getProjName());
		}
		
		Iterator<Project> p2= (Iterator<Project>) hibernateTemplate.findWithCriteris(Project.class).iterator();
		
		while(p2.hasNext())
			System.out.println(p2.next().getProjName());*/
		
		
		
			
	
		
		}
}
