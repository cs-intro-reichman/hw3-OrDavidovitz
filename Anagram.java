import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
    public static void main(String args[]) {
        // Tests the isAnagram function.
        System.out.println(isAnagram("silent", "listen"));  // true
        System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
        System.out.println(isAnagram("Madam Curie", "Radium came")); // true
        System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

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
        String newstr1 = "";
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
            for (int j = 0; j < str2.length(); j++) {
                if (currentChar == str2.charAt(j)) {
                    checker++;
                    str2 = str2.substring(0, j) + str2.substring(j + 1);
                    break;
                }
            }
        }

        return checker == str1.length();
    }

    // Returns a random anagram of the given string. The random anagram consists of the same
    // characters as the given string, re-arranged in a random order. 
    public static String randomAnagram(String str) {
        int length = str.length();
        String changes = str;
        Random random = new Random();
        String newstr = "";  

        for (int i = 0; i < length; i++) {
            int randomnum = random.nextInt(changes.length()); 
            newstr += changes.charAt(randomnum);  
            changes = changes.substring(0, randomnum) + changes.substring(randomnum + 1); 
        }

        return newstr;  
    }
}
