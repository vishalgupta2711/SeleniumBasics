package CoreJava;

public class ClassC extends ClassB{

	public ClassC() {
		super(); // super() keyword is used to call the base class constructor
		//there can be only one super keyword in a constructor
		System.out.println("ClassC Constructor");
	}
	public static void main(String[] args) {
		ClassB obj = new ClassB();		
		ClassC obj1 = new ClassC();
		
		
	}

}
