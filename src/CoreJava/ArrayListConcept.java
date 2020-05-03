package CoreJava;

import java.util.ArrayList;

public class ArrayListConcept {

	public static void main(String[] args) {

		//one disadvantage of single dimensional array is it stores data of similar types and its size is fixed
		//to overcome the above problem we use collections - dynamic array -  ArrayList which stores data of multiple types
		
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
		//ar1.add(100); not allowed bcoz we are restricting to string only
		
		//For formatting/ alignment of code press ctrl+shift+s
		
	}

}
