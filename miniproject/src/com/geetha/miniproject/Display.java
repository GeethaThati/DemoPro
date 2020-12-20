package com.geetha.miniproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Display implements source{
	
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void getDataBasedOnYear(ArrayList<Rows> list) {
		
		System.out.println("Enter the Year:");
		
		int year=sc.nextInt();
		int y=0;
		int flag=0;
		Rows row = null;
		
		Iterator<Rows> itr= list.iterator();
		while(itr.hasNext()) {
			row = (Rows)itr.next();
			SimpleDateFormat f=null;
			String d= row.getDateReceived();
			if(d.contains("/")) {
				f=new SimpleDateFormat("mm/dd/yyyy");
			}
			else
				f=new SimpleDateFormat("dd-mm-yyyy");
			try {
				Date date = f.parse(d);
				
				Calendar cal = new GregorianCalendar();
				cal.setTime(date);
				y=cal.get(Calendar.YEAR);
				
			}catch (ParseException e1) {
				e1.printStackTrace();
			}
			if(y==year)
			{
				flag=1;
				System.out.print(row.getDateReceived()+" __ "+row.getProduct()+" __ "+row.getSubProduct()+" __ "+row.getIssue()+" __ "+row.getSubIssue()+" __ ");
				System.out.print(row.getCompany()+" __ "+row.getState()+" __ "+row.getZip()+" __ "+row.getSubmittedVia()+" __ "+row.getDateSentToCompany()+" __ ");
				System.out.println(row.getCompanyResponse()+" __ "+row.getTimelyResponse()+" __ "+row.getConsumerDisputed()+" __ "+row.getComplaintId());
			}
		}
		if(flag==0)
		{
			System.out.println("There is no complaint for year "+year);
		}
		
	}

	@Override
	public void getDataBasedOnBankName(ArrayList<Rows> list) {
	
		System.out.println("Enter the Name of the Bank: ");
		String bank = sc.nextLine();
		
		Rows row = null;
		int flag = 0;
		Iterator<Rows> itr= list.iterator();
		while(itr.hasNext()) {
			row = (Rows) itr.next();
			if(row.getCompany().equals(bank)) {
				flag = 1;
				
				System.out.print(row.getDateReceived()+" __ "+row.getProduct()+" __ "+row.getSubProduct()+" __ "+row.getIssue()+" __ "+row.getSubIssue()+" __ ");
				System.out.print(row.getCompany()+" __ "+row.getState()+" "+row.getZip()+" __ "+row.getSubmittedVia()+" __ "+row.getDateSentToCompany()+" __ ");
				System.out.println(row.getCompanyResponse()+" __ "+row.getTimelyResponse()+" __ "+row.getConsumerDisputed()+" __ "+row.getComplaintId());
			}
		}
		if(flag == 0) 
			System.out.println("There is no complaint for "+ bank +" bank");
	}

	@Override
	public void getDataBasedOnComplaintId(ArrayList<Rows> list) {

		System.out.println("Enter the Complaint Id");
		Rows row=null;
		
		String cid=sc.next();
		int flag=0;
		Iterator<Rows> it=list.iterator();
		while(it.hasNext())
		{
			row=(Rows)it.next();
			if(row.getComplaintId().equals(cid))
			{
				flag=1;
				
				System.out.print(row.getDateReceived()+" __ "+row.getProduct()+" __ "+row.getSubProduct()+" __ "+row.getIssue()+" __ "+row.getSubIssue()+" __ ");
				System.out.print(row.getCompany()+" __ "+row.getState()+" "+row.getZip()+" __ "+row.getSubmittedVia()+" __ "+row.getDateSentToCompany()+" __ ");
				System.out.println(row.getCompanyResponse()+" __ "+row.getTimelyResponse()+" __ "+row.getConsumerDisputed()+" __ "+row.getComplaintId());
			}
		}
		
		if(flag==0)
		{
			System.out.println("There is no complaint for "+cid);
		}	
		
	
	}

	@Override
	public void getDataBasedOnNumberOfDaysToSlove(ArrayList<Rows> list) {

		Rows r=null;
		Iterator<Rows> it=list.iterator();
		while(it.hasNext())
		{
			r=(Rows)it.next();
			SimpleDateFormat sdf=null;
			String d1=r.getDateReceived();
			String d2=r.getDateSentToCompany();
			if(d1.contains("/") && d2.contains("/"))
			{
				sdf=new SimpleDateFormat("mm/dd/yyyy",Locale.ENGLISH);
			
			try {
				Date f=sdf.parse(d1);
				Date s=sdf.parse(d2);
				long diff1=Math.abs(s.getTime()-f.getTime());
				long diff=TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
				System.out.println(r.getCompany()+" __ "+r.getIssue()+" __ "+diff);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			}
			if(d1.contains("-") && d2.contains("-"))
			{
				sdf=new SimpleDateFormat("dd-mm-yyyy",Locale.ENGLISH);
			
			try {
				Date f=sdf.parse(d1);
				Date s=sdf.parse(d2);
				long diff1=Math.abs(s.getTime()-f.getTime());
				long diff=TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
				System.out.println(r.getCompany()+" __ "+r.getIssue()+" __ "+diff);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   }
			
		}
		
		
	}

	@Override
	public void getDataBasedOnClosedWithExplaination(ArrayList<Rows> list) {

		
		Rows row=null;
		int flag=0;
		Iterator<Rows> it=list.iterator();
		while(it.hasNext())
		{
			row=(Rows)it.next();
			if(row.getCompanyResponse().equals("Closed with explanation"))
			{
				flag=1;
				System.out.print(row.getDateReceived()+" __ "+row.getProduct()+" __ "+row.getSubProduct()+" __ "+row.getIssue()+" __ "+row.getSubIssue()+" __ ");
				System.out.print(row.getCompany()+" __ "+row.getState()+" "+row.getZip()+" __ "+row.getSubmittedVia()+" __ "+row.getDateSentToCompany()+" __ ");
				System.out.println(row.getCompanyResponse()+" __ "+row.getTimelyResponse()+" __ "+row.getConsumerDisputed()+" __ "+row.getComplaintId());
			}
		}
		
		if(flag==0)
		{
			System.out.println("No Complaint Closed with Explanation");
			System.out.println("haiiiiiiiiiiiiiii");
		}	
		
	}

	@Override
	public void getDataBasedOnHavingTimelyResponse(ArrayList<Rows> list) {

		
		Rows row=null;
		int flag=0;
		Iterator<Rows> it=list.iterator();
		while(it.hasNext())
		{
			row=(Rows)it.next();
			if(row.getTimelyResponse().equals("Yes"))
			{
				flag=1;
				System.out.print(row.getDateReceived()+" __ "+row.getProduct()+" __ "+row.getSubProduct()+" __ "+row.getIssue()+" __ "+row.getSubIssue()+" __ ");
				System.out.print(row.getCompany()+" __ "+row.getState()+" "+row.getZip()+" __ "+row.getSubmittedVia()+" __ "+row.getDateSentToCompany()+" __ ");
				System.out.println(row.getCompanyResponse()+" __ "+row.getTimelyResponse()+" __ "+row.getConsumerDisputed()+" __ "+row.getComplaintId());
			}
		}
		
		if(flag==0)
			System.out.println("No Complaint with Timely Response");
		
		System.out.println("Hello");
			
	}

/*	@Override
	public void raiseAComplaint(String data) {
		
		try {
			FileWriter pw = new FileWriter("C:\\Users\\geeth\\Downloads\\complaints.csv",true);
			
			//String raise[]="".split(",");
			pw.append("18-11-2020");
			pw.append("geetha");
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		}
		*/
	


	
	
			
}
