package LABOOP;

import java.util.*;
import java.util.Scanner;

public class LAB3_2 {
	
	public static void main(String[] args) {
         
	    int n;
		int i = 0;
		String text;
		
		System.out.print("Input Stack Size : ");
		   Scanner sc = new Scanner(System.in);
	       n = sc.nextInt();
		
		Stack<String> stack = new Stack<String>();
		stack.setSize(n);
		stack.clear();
		
		do{
			  System.out.println("--------------------------------- ");
			  System.out.println("Stack Fn ");
			  System.out.println("--------------------------------- ");
			  System.out.println("1 : Push ");
			  System.out.println("2 : Pop ");
			  System.out.println("3 : isEmpty ");
			  System.out.println("4 : Top ");
			  System.out.println("5 : CheckStack ");
			  System.out.println("10 : END");
			  System.out.println("--------------------------------- ");
			  
			  System.out.print("Input ");
			  i = sc.nextInt();
			  System.out.println("");
			  System.out.println("--------------------------------- ");
		      
		switch(i) {
		
		case 1:
		    System.out.print("Push : ");
		    Scanner sct = new Scanner(System.in);
		    text = sct.nextLine();
		    if(stack.size() == n) {
		    	System.out.println("----| STACK OVERFLOW!!!!!!");
		    }else {
		    	  stack.push(text);	
		    }
		    break;
		        
		case 2:
			  if(stack.size() == 0) {
			    	System.out.println("----| STACK IS EMPTY");
			    }else {
			    	System.out.println("Pop");
			    	stack.pop();
			    }//end if
		    break;
		    
		case 3: 
			if(stack.isEmpty() == true) {
				
				System.out.println("----| Yes");
				
			}else {
				
				System.out.println("----| No");
			}//end if
		    break;
		    
		case 4: 
		    if(stack.size() == 0) {
		    	System.out.println("----| NULL");
		    }else {
		    	System.out.println("----| Top : "+stack.peek());
		    }//end if
		    break;  
		    
		case 5: 
			System.out.println("----| STACK : "+stack);
		    break;  
		 
		case 10: 
			i = 10;
		    break;   
		}// end switch
			
		}while(i != 10 ); //endloop
		
	}//end main

}