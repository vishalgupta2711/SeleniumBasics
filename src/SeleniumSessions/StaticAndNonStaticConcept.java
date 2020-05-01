package SeleniumSessions;

public class StaticAndNonStaticConcept {
	
	String name = "Tom";  // non-static global variable
	static int age =25;	  // static global variable	

	public static void main(String[] args) {
		
		//how to call static variables and methods()?
		//1.direct calling
		sum();
		//2.calling by classname
		StaticAndNonStaticConcept.sum();
		
		System.out.println(age);
		System.out.println(StaticAndNonStaticConcept.age);
		
		//how to call non-static vars and methods? we will have to create objects for this
		
		StaticAndNonStaticConcept obj = new StaticAndNonStaticConcept();
		obj.sendMail();
		System.out.println(obj.name);
		
		// can i access static methods by using object reference? yes, but with certain warnings(you can see below)
		obj.sum();

	}
	
	public void sendMail() {  // non-static method
		System.out.println("sendMail method");
	}

	public static void sum() {  //static method
		System.out.println("sum method");
	}
}
