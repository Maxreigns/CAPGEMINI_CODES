package capgemeini_training;

public class Assignment_20Jan_String {
    public static void main(String[] args) {
        //Ques1: convert string to lowercase
        String str1 = "HELLO WORLD";
        String lowerStr = str1.toLowerCase();
        System.out.println("Lowercase: " + lowerStr);

        //Ques2: convert string to uppercase
        String str2 = "hello world";
        String upperStr = str2.toUpperCase();
        System.out.println("Uppercase: " + upperStr);

        //Ques3: count number of vowels, consonants, numbers and special characters in a string
        String str3 = "Hello World! 123";
        int vowels = 0, consonants = 0, digits = 0, specialChars = 0;
        for (char ch : str3.toCharArray()) {
            if (Character.isLetter(ch)) {
                char lowerCh = Character.toLowerCase(ch);
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                    vowels++;
                } else {
                    consonants++;   
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else {
                specialChars++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialChars);

        //Ques4: count number of spaces in a string
        String str4 = "Hello World! Welcome to Java.";
        int spaceCount = 0;
        for (char ch : str4.toCharArray()) {
            if (ch == ' ') {
                spaceCount++;
            }
        }
        System.out.println("Number of spaces: " + spaceCount);

        //Ques5: convert even index characters to uppercase and odd index characters to lowercase
        String str5 = "hello world";
        StringBuilder modifiedStr = new StringBuilder();
        for (int i = 0; i < str5.length(); i++) {
            char ch = str5.charAt(i);
            if (i % 2 == 0) {
                modifiedStr.append(Character.toUpperCase(ch));
            } else {
                modifiedStr.append(Character.toLowerCase(ch));
            }
        }
        System.out.println("Modified String: " + modifiedStr.toString());   

        //Ques 6:remove spaces from string
        String str6 = " H e l l o   W o r l d ";
        String noSpaceStr = str6.replace(" ", "");          
        System.out.println("String without spaces: " + noSpaceStr);
    }
}