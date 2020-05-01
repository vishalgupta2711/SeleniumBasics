package OOPConcept;

public class HSBCBank implements USBank , BrazilBank {  // we are achieving multiple inheritance

	//if a class is implementing an interface then it is mandatory to define/override all the methods of interface
	@Override
	
	//overriding from USBank
	public void credit() {
		System.out.println("hsbc --- credit");
	}

	@Override
	public void debit() {
		System.out.println("hsbc --- debit");	
	}

	@Override
	public void transferMoney() {
		System.out.println("hsbc --- transferMoney");
	}
	//seperate methods of hsbc bank
	
	public void educationLoan() {
		System.out.println("hsbc -- education loan");
	}
	
	public void carLoan() {
		System.out.println("hsbc -- car loan");
	}

	//brazilBank method
	public void mutualFund() {
		System.out.println("hsbc -- mutualFund");
		
	}

}
