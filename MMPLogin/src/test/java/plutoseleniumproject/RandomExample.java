package plutoseleniumproject;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		Random r1=new Random();
		int i=r1.nextInt(100);
		System.out.println(i);
		
		System.out.println(65+r1.nextInt(26));
		
		char c=(char)(65+r1.nextInt(26));
		System.out.println(c);
		
		c=(char)(97+r1.nextInt(26));
		System.out.println(c+ "EliteQATeam"+c+r1.nextInt(100)+"@gmail.com");

	}

}
