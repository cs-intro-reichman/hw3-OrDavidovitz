// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;
		if (x2>=0)
		{
			for (int i=0; i<x2;i++)
			{
				sum++;
			}
		}
		else
		{
			for ( int j=0; j>x2;j--)
		{
			sum--;
		}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;
		if (x2>=0)
		{
			for ( int i=0; i<x2;i++)
			{
				sum--;
			}
		}
		else
		{
			for (int j=0; j>x2;j--)
			{
				sum++;
			}
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int sum = 0;
		if(x1==0 || x2==0)
		{
			return 0 ;
		}
		if(x1>0&&x2>0)
		{
		for (int i=0; i<x2;i++)
		{
			sum=plus(sum, x1);
		}
		}
		if (x1<0&&x2>0)
		 {
			for (int i=0; i<x2;i++)
		{
			sum=plus(sum, x1);
		}
		 }
		 if (x1>0&&x2<0)
		 {
			for (int i=0; i<x1;i++)
		{
			sum = x2;
			sum=plus(sum, x2);
		}
		 }
		 if (x1<0 && x2<0)
		 {
			for (int i=0; i>x2;i--)
		{
			sum=minus(sum, x1);
		}
		 }
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int sum = x;
		if (n==0)
		return 1;
		for ( int l = 0; l<n-1;l++)
		{
			sum=times(sum, x);
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		
		int divi = 0 ;
		int num = x1;
		int diviser = x2;
		if (x1==x2)
		{
			return 1;
		}
		if (x1==0 || x2==0) 
		{
			return 0 ;
		}
		if ((x1>0&&x2>0)) 
		{
			
			if(x1>0)	
				if (x1<x2)
				{
					return divi;
				}
				
				while (num>=diviser)
				{
					num = minus(num, diviser);
					divi++;
				}
		}
		if (x1>0&&x2<0)
		 x2=times(x2, -1);
		{
			if ((x1>0&&x2>0)) 
			{
				
				if(x1>0)	
					if (x1<x2)
					{
						return -1;
					}
					
					while (num>=diviser)
					{
						num = minus(num, diviser);
						divi--;
					}
			}
		
		}
		if (x1<00&&x2>0)
		{
			x1 = times(x1, -1);
			if ((x1>0&&x2>0)) 
		{
			
			if(x1>0)	
				if (x1<x2)
				{
					return -1;
				}
				
				while (num>=diviser)
				{
					num = minus(num, diviser);
					divi--;
				}
		}
		}
		if (x1<0&&x2<0)
		 {
			x1=times(x1, -1);
			x2=times(x2, -1);
			if ((x1>0&&x2>0)) 
		{
			
			if(x1>0)	
				if (x1<x2)
				{
					return divi;
				}
				
				while (num>=diviser)
				{
					num = minus(num, diviser);
					divi++;
				}
		}
			
		 }
		return divi;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		// Replace the following statement with your code
		if (x1==0||x2==0)
		{
			return 0 ;
		}
		if (x1>0&&x2>0)
		 {
			int div1 = div(x1, x2);
			return (minus(x1, times(x2, div1)));
		}
		if (x1>0&&x2<0)
	    {
			x2=times(x2, -1);
			int div1 = div(x1, x2);
			return (minus(x1, times(x2, div1)));
		}
		if (x1<0&&x2>0)
		 {
		x1 = times(x1, -1);
		int div1 = div(x1, x2);
		return (minus(x1, times(x2, div1)));
		}
		else
		{
			x1 = times(x1, -1);
			x2=times(x2, -1);
			int div1 = div(x1, x2);
			return (minus(x1, times(x2, div1)));

		}
	

	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int num = x;
		int sum = 0 ;
		int checker = 1;
		if (x<=0) {
			return 0 ;
		}
		while (sum < num)
		{
			sum = pow(checker,2);
			checker++;
		}
		return minus(checker, 1);
	}	  	  
}