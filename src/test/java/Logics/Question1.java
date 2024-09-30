package Logics;

public class Question1 {

	
	public static void main(String[] args) {
		
		int[] arr= {5,-7,4,3,-5,2,7};

		int small;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i; j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					small=arr[i];
				}
			}
 			
		}
		
	}
}
