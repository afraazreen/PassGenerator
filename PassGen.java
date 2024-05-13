// This class will be used to develop all the backend aspects of the password
// Essentially this class will handle the actual generation of the password. 


// Here, I am importing the Random class as this will help me create the passwords.
import java.util.Random;


public class PassGen {
	
	// First, I am creating character pools:
	// One for uppercase letters
	// One for lowercase letters
    // One for symbols
	// One for numbers.
	
    // We are going to use these to randomly generate the passwords. 
    public static final String LOW_CHAR = "abcdefghijklmnopqrstuvwxyz";
    public static final String UP_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUM = "012345679";
    public static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

   // The random class can allow us to generate random numbers, and we will use this to randomly choose the characters we want to use in the password..
    private final Random random;

    // Here, I am creating the constructor. 
    public PassGen(){
    	random = new Random();
    	
    }

    // The length of the password will be generated by the user, and must be at least 7 characters long, to ensure that it is somewhat strong.
    // The includeUp and etc are parameters which indicate whether the user wants those elements to be included in the password. 
    
    
    
    
    
    // includeUppercase and etc... considers if the password should include uppercase, lowercase, etc... (taken from the user)
    public String generatePassword(int length, boolean includeUp, boolean includeLow, boolean includeNum, boolean includeSym){
        
    	
    	// Here, we will use StringBuilder to help us build the password efficiently.
        StringBuilder passBuilder = new StringBuilder();

        // This allows us to store the valid character states one by one.
        // So, if the user decides to include a specific character, we store the boolean value and add some characters from that pool to the String.
        String validCharacters = "";
        if(includeUp) validCharacters += UP_CHAR;
        if(includeLow) validCharacters += LOW_CHAR;
        if(includeNum) validCharacters += NUM;
        if(includeSym) validCharacters += SYMBOLS;

        // That building part is done here, through the use of this for loop.
        for(int i = 0; i < length; i++){
        	
            // This will generate a random index
            int index = random.nextInt(validCharacters.length());

            // Then, it will select the char at that random index, and then store it into the password builder. 
            // It will do this until it reaches the end of the loop (the length specified at that index). 
            char randomChar = validCharacters.charAt(index);
            passBuilder.append(randomChar);

   
        }

        // In the end, we will return the result to the user. 
        return passBuilder.toString();
    }
}
