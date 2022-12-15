/*
 * LAB ASSIGNMENT 10
 * HIBERNATE PROJECT
 @authorName :-Rakhee Gaikwad
 @Date :- 15 Dec 2022
  
  Project :- Create  an employee table with eid,
   ename, edept, esalary and add employee 
  address in this table using different class.
 */

package com.example;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static String addEmployee(Session s,Transaction t)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Name");
		String ename=sc.nextLine();
		System.out.println("Enter Employee Department");
		String edept=sc.nextLine();
		System.out.println("Enter Employee Id");
		int eid=sc.nextInt();
		System.out.println("Enter Employee Salary");
		int esalary=sc.nextInt();
		
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter House Name");
		String h_name=sc1.nextLine();
		
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter Area Name");
		String area=sc2.nextLine();
		
		Scanner sc3=new Scanner(System.in);
		System.out.println("Enter City Name");
		String city=sc3.nextLine();
		
		Scanner sc4=new Scanner(System.in);
		System.out.println("Enter Pincode");
		int pincode=sc4.nextInt();
		
		Address ad=new Address();
		ad.setH_name(h_name);
		ad.setArea(area);
		ad.setCity(city);
		ad.setPincode(pincode);
		
		Employee ss=new Employee();
		ss.setEname(ename);
		ss.setEid(eid);
		ss.setEdept(edept);
		ss.setEsalary(esalary);
		ss.setAddress(ad);

		s.save(ss);
		t.commit();
		
		Query query =s.createQuery("from Employee");
		List<Employee>employees=query.list();
		
		for(Employee e1:employees)
		{
			System.out.println("Employee Name: "+e1.getEname()+" "+"Employee Id : "+e1.getEid()+" "+" Employee Department: "+e1.getEdept()+" "+"Employee Salary: "+e1.getEsalary());
		}
		s.close();
		return "Employee is added";
		
	}
    public static void main( String[] args )
    {
        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf=con.buildSessionFactory();
        Session ss=sf.openSession();
        Transaction T=ss.beginTransaction();
        System.out.println(addEmployee(ss,T));
        
        
    }
}
