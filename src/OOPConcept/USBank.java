package OOPConcept;

public interface USBank {
	
	int min_bal = 100;
	
	public void credit();
	
	public void debit();
	
	public void transferMoney();
	
	
	//only method declaration
	//no method body - only method prototype
	//In interface we can declare the variables, variables are default static in nature
	//variables value will not be changed -- it is final in nature
	//no static method in interface
	//no main method in interface
	//we cannot create the object of interface - interface is abstract in nature

}
