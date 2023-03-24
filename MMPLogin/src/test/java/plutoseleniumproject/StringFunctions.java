package plutoseleniumproject;

public class StringFunctions {

	public static void main(String[] args) {
	
		String s="Selenium123";
		System.out.println(s.length());
		System.out.println(s.trim());
		System.out.println(s.substring(4));
		System.out.println(s.replace("123", "WebDriver"));
		System.out.println(s.charAt(2));
		String Date="23/05/2023";
		String DateArr[]=Date.split("/");
		System.out.println(Date);
		System.out.println(DateArr[0]);
		System.out.println(DateArr[1]);
		System.out.println(DateArr[2]);

	}

}
