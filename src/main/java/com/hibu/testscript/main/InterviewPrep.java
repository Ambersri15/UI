package com.hibu.testscript.main;

import java.util.Iterator;
import java.util.Set;

public class InterviewPrep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s = null;
		String a = "amamberr";
		System.out.println("this is old a " + a);
		String[] b = a.split("");
		for(int i=0;i<b.length;i++)
		{
			s.add(b[i]);
		}
 
		a = s.toString();
		System.out.println("this is new a " + a);
		Iterator itr = s.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}

}
