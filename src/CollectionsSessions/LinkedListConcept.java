package CollectionsSessions;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListConcept {

	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("test");
		ll.add("selenium");
		ll.add("qtp");
		ll.add("RPA");
		
		//print
		System.out.println("contents of linked list"+ll);
		
		//addfirst
		ll.addFirst("Vishal");
		
		//addlast
		ll.addLast("Automation");
		System.out.println("content of linkedlist"+ll);
		
		//get
		System.out.println(ll.get(0));
		
		//set
		System.out.println(ll.set(0,"Tom"));
		
		//remove first and last element
		ll.removeFirst();
		ll.removeLast();
		System.out.println("content of linked list"+ll);
		
		//how to print all the values in the linked list
		//for loop
		
		for(int i=0 ; i<ll.size() ; i++) {
			System.out.println(ll.get(i));
			
		}
		
		//print all the values using iterator
		System.out.println("**************using iterator**************");
			Iterator<String> it = ll.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		
	}

}
