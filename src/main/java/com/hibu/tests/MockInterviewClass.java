package com.hibu.tests;

public class MockInterviewClass {

	public void main() {
		// TODO Auto-generated method stub
      String s = "welcome";
		/*
		 * String compare ="compared"; if(s.contentEquals(compare))
		 * System.out.println("equal"); System.out.println("normal method");
		 * if(s==compare) System.out.println("equals");
		 */
      String[] w = s.split("");
      //String[] rev = new String[w.length];
      StringBuffer sr = new StringBuffer();
      for(int i=w.length-1;i>=0;i--)
      {
    	  sr = sr.append(w[i]);
      }
      String rev = sr.toString();      
	}

}
