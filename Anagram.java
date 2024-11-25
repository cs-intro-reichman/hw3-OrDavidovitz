import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  


	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newstr ="";
		for (int i=0; i<str.length();i++)
		{
			
			if (((str.charAt(i)<65||str.charAt(i)>122))&&str.charAt(i)!=32) {
				continue;
			}
			if(Character.isUpperCase(str.charAt(i)))
			{
				newstr+=Character.toLowerCase(str.charAt(i));
			}
			else {
				newstr+= str.charAt(i);
			}

			}
		
		return newstr;
	} 
	   	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int checker = 0;
		str1= preProcess(str1);
		str2=preProcess(str2);
		if (str1.length()!=str2.length())
		{
			return false;
		}
		for (int i=0;i<str1.length();i++)
		{
			for(int j=0;j<str1.length();j++)
			{
				if (str1.charAt(i)==str2.charAt(j))
				{
					checker++;
					break;
				}
				
			}
		}
		if (checker==str1.length()) {
			return true;
		}
		else{
			return false;
		}
	}

	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int length = str.length();
		String changes = str;
		Random random = new Random();
		int randomnum=0;
		String newstr = "";
		for(int i=0;i<str.length();i++)
		{
			randomnum = random.nextInt(length);
			newstr+=changes.charAt(randomnum);
			changes = str.substring(0, randomnum)+str.substring(randomnum+1);
			length--;
		}
		
		return newstr;
	}
}
