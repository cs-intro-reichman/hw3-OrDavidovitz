import java.util.Random;

public class Anagram {
    public static void main(String args[]) {
        System.out.println(isAnagram("silent","listen"));  
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); 
        System.out.println(isAnagram("Madam Curie","Radium came")); 
        System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); 

        System.out.println(preProcess("What? No way!!!"));
        
        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
        
        String str = "1234567";
        Boolean pass = true;
        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass) break;
        }
        System.out.println(pass ? "test passed" : "test Failed");
    }  

    public static String preProcess(String str) {
        String newstr1 ="";
        for (int i = 0; i < str.length(); i++) {
            if (((str.charAt(i) < 65 || str.charAt(i) > 122)) && str.charAt(i) != 32) {
                continue;
            }
            if (Character.isUpperCase(str.charAt(i))) {
                newstr1 += Character.toLowerCase(str.charAt(i));
            } else {
                newstr1 += str.charAt(i);
            }
        }
        return newstr1;
    } 

	public static String Spaceless(String str) {
		int l = str.length();
		String op = "";
		for (int i = 0; i < l; i++) {
			if (str.charAt(i) != ' ')
				op = op + str.charAt(i);
		}
		return op;
	}

	public static boolean isAnagram(String str1, String str2) {
		String s1 = preProcess(str1); //preprocessed version of str1
		String s2 = preProcess(str2); //preprocessed version of str2
		s1 = Spaceless(s1);
		s2 = Spaceless(s2);
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 != l2) //anagrams have the same length
			return false;
		String temp = "";
		boolean isSame = false;

		for (int i = 0; i < l1; i++) { //goes over the letters in s1
			for (int k = 0; k < l2; k++) { //goes over the letters in s2
				if ((s1.charAt(i) == s2.charAt(k)) && (!isSame)) //checks if two letters are the same
					isSame = true; 
				else 
					temp = temp + s2.charAt(k);
			}
			if (!isSame) //a letter exists in one string and doesn't in another
				return false; 
			s2 = temp;
			l2 = s2.length();
			temp = "";
			isSame = false;
		}
		return true;
	}
	

    public static String randomAnagram(String str) {
        int length = str.length();
        String changes = str;
        Random random = new Random();
        int randomnum = 0;
        String newstr = "";  

        while (length > 0) {
            randomnum = random.nextInt(length);  
            newstr += changes.charAt(randomnum);  
            changes = changes.substring(0, randomnum) + changes.substring(randomnum + 1); 
            length--; 
        }

        return newstr;  
    }
}
