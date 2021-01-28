package cg.demo.test.main;
import java.util.Scanner;

import cg.demo.test.ExDemo;
public class MainClass {

	public static void main(String[] args) {
		int idd;
		ExDemo ed=new ExDemo();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("enter the name:");
		ed.setName(sc.nextLine());
		
		System.out.println("enter the id:");
		ed.setId(sc.nextInt());
		
	
		
		System.out.println(ed.getId()+" "+ed.getName());
		
		
		
		
	}

}
