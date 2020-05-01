package OOPConcept;

public class TestBank {

	public static void main(String[] args) {

		System.out.println(USBank.min_bal);//accessing min_bal through interface name because it is non static variable
	//	USBank.min_bal = 200; cannot do this because the value of variable min_bal defined in the interface is final and cannot be changed
		
		HSBCBank hs = new HSBCBank();
		hs.credit();
		hs.debit();
		hs.transferMoney();
		hs.educationLoan();
		hs.carLoan();
		hs.mutualFund();
	}

}
