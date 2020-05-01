package SeleniumSessions;

public class WrapperClassConcept {

	public static void main(String[] args) {

		String x = "100";
		System.out.println(x+20);
		
		//data conversion from String to int
		
		int i = Integer.parseInt(x);
		System.out.println(i+20);
		
		//Integer, double, boolean
		
		//String to double conversion
		String y ="12.33";
		Double d = Double.parseDouble(y);
		System.out.println(d+10);
		
		//String to boolean
		String k = "True";
		Boolean b = Boolean.parseBoolean(k);
		System.out.println(b);
		
		//int to String conversion
		int j=200;
		String s = String.valueOf(i);
		System.out.println(s+20);
		
		String u = "100A"; // this should be a pure string then only it will be converted/parsed into integer
		Integer.parseInt(u); //NumberFormatException -- For input string: "100A"
	}

}
