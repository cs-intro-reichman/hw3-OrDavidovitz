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

	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
	
		if (str1.length() != str2.length()) {
			return false;
		}
	
		int checker = 0;
		for (int i = 0; i < str1.length(); i++) {
			char currentChar = str1.charAt(i);
			boolean found = false;
			for (int j = 0; j < str2.length(); j++) {
				if (currentChar == str2.charAt(j)) {
					checker++;
					str2 = str2.substring(0, j) + str2.substring(j + 1);
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
	
		return checker == str1.length();
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
