package Logics;

import java.util.concurrent.ForkJoinPool;

public class Tast123 {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5};
		int[] a1 = { 5, 6, 7, 8 };
		int length=0;
		int Pos=0;
		if (a.length>a1.length) {
			length=a.length;
		}else
		{
			length=a1.length;
		}
		int[] finalarr=new int[length];
		try {
			for(int i=0;i<=length;i++)
			{
				Pos=i;
				finalarr[i]=a[i]+a1[i];
				
			}
			
		} catch (Exception e) {
			finalarr[Pos]=a[Pos]+0;
		}
		for(int i=0;i<finalarr.length;i++)
		{
			System.out.print(finalarr[i]+", ");
			//Sysout This is the change
		}

	}
	
}
