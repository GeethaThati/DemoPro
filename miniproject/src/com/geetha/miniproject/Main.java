package com.geetha.miniproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ReadFromFile read=new ReadFromFile();
		ArrayList<Rows> list=new ArrayList<>();
		list=read.readfromfile(list);
		Scanner sc= new Scanner(System.in);
		
		Display show=new Display();
		String str;
		
		do {
			
		System.out.println("-----------GIVE YOUR SEARCH OPTION-------------- \n");
		System.out.println("1.Get the details based on year:\n");
		System.out.println("2.Get the details based on Bank Name:\n");
		System.out.println("3.Get the details based on Complaint Id:\n");
		System.out.println("4.Get the details based on Closed:\n");
		System.out.println("5.Get the details based on Timely Response:\n");
		System.out.println("6.Get the details based on No.of days to reslove a complaint:\n");
      		
		int option =sc.nextInt();
        
        switch(option) {
        	
        case 1:
        	show.getDataBasedOnYear(list);
            break;
        case 2:
        	show.getDataBasedOnBankName(list);
            break;
        case 3:
        	show.getDataBasedOnComplaintId(list);
            break;
        case 4:
        	show.getDataBasedOnNumberOfDaysToSlove(list);
        	break;
        case 5:
        	show.getDataBasedOnClosedWithExplaination(list);
        	break;
        case 6:
        	show.getDataBasedOnHavingTimelyResponse(list);
        	break;
        	}
        
        System.out.println("Do you want to continue:yes / no");
        sc.nextLine();
        str=sc.nextLine(); 
		}while(str.equals("yes"));
		
		if(str.equals("no"))
			System.out.println("----------THANKYOU----------");
		
	}

}
