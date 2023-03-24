package plutoseleniumproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Datefunctionality {

	public String getFutureDate(int noofDays)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofDays);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
		System.out.println(sdf.format(cal.getTime()));
		return cal.getTime().toString();
		
	}
	

    public String getFutureDate(int noofDays,String format)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofDays);
		System.out.println("To Date:"+cal.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		System.out.println(sdf.format(cal.getTime()));
		return cal.getTime().toString();
		
	}
	
	public static void main(String[] args)
	{
		
		Datefunctionality d1=new Datefunctionality();
		String result=d1.getFutureDate(0);
		System.out.println(result);

	}	
}
