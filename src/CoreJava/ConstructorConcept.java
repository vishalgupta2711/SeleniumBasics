package CoreJava;

public class ConstructorConcept {
	//class vars
	String name;
	int age;
	
	public ConstructorConcept() {	//0 param constructor
		System.out.println("Default constructor");
	}
	
	public ConstructorConcept(int i) {	//1 param constructor
		System.out.println("1 param constructor");
		System.out.println(i);
	}
	
	public ConstructorConcept(int i , int j) {	//2 param constructor
		System.out.println("2 param constructor");
		System.out.println(i+" and "+j);
	}
	
	public ConstructorConcept(String name , int age) {//this name and age is local variable and this is getting the values from the object which we have passed in the main function.
		this.name = name; //TO initialize this class variables with the values of name and age we use this keyword.The class variables name and age is different from the local variables name and age declared in this constructor
		this.age = age;//this means current class
		//this.classvariable = local variable
	}
	
	
	public static void main(String[] args) {
		ConstructorConcept obj = new ConstructorConcept();
		ConstructorConcept obj1 = new ConstructorConcept(10);
		ConstructorConcept obj2 = new ConstructorConcept(10,20);
		ConstructorConcept obj3 = new ConstructorConcept("Tom",25);
		System.out.println(obj3.name);
		System.out.println(obj3.age);
	}

}
