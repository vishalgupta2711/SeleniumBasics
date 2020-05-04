package CollectionsSessions;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {

	public static void main(String[] args) {

ArrayList ar = new ArrayList();
		
		ar.add(100);
		ar.add(200);
		ar.add(300);
		
		System.out.println(ar.size());
		
		ar.add(400);
		ar.add(500);
		
		System.out.println(ar.size());
		
		ar.add("Tom");
		ar.add("Hello");
		ar.add(12.33);
		ar.add('M');
		
		System.out.println(ar.size());
		
		//to print all the values of arrayList - use for loop
		
		for(int i =0 ; i<ar.size() ; i++) {
			System.out.println(ar.get(i));
		}
		
		//we want ArrayList to store only integer values then we restrict to use only <Integer> by using the below statement
		
		ArrayList <Integer> ar1 = new ArrayList<Integer>();
		ar1.add(100);
	//	ar1.add("tom"); we cannot add string values
		
		ArrayList <String> ar2 = new ArrayList<String>();
		ar2.add("Tom");
		
		//********************ArrayList************************
		
		//Employee class objects
		Employee e1 = new Employee("Vishal" , 25 , "QA");
		Employee e2 = new Employee("Tom" , 30 , "dev");
		Employee e3 = new Employee("Peter" , 35 , "admin");
		
		//create ArrayList
		ArrayList<Employee> ar3 = new ArrayList<Employee>();
		ar3.add(e1);
		ar3.add(e2);
		ar3.add(e3);
		
		//iterator to traverse the values
		Iterator<Employee> it = ar3.iterator();
		
		while(it.hasNext()) {
			Employee emp = it.next();	
			System.out.println(emp.name);
			System.out.println(emp.age);
			System.out.println(emp.dept);
			
		}
		
		
		
		

	}

}
