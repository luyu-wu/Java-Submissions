public class Cipher {
    private int shift;
    
    // Apparently, there's no way to turn a hash code of a char back into a char, therefore I just wrote out this reference table.
    private char[] hashTable = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	public Cipher(int newShift) {
	    // Fix extra
	    if (newShift<0){
	        shift = 26+(newShift%26);
	    } else {
	        shift = newShift;
	    }
	}

    // Method to change shift value
	public void newShift (int newShift) {
	    if (newShift<0){
	        shift = 26+(newShift%26);
	    } else {
	        shift = newShift;
	    }
	}
	
	// Method to encode a string given the object's shift property
	public String encode (String message){
		char [] list = message.toCharArray();
		
		// Iterate through the characters of the string
		StringBuilder shiftedString = new StringBuilder();
		for (char i : list) {
		    if (Character.isUpperCase(i)){
		        // calculate the new hash code
		        int newHashCode = (Character.hashCode(i) - 65 + shift)%26;
		        
		        // apply the caesar shift char
		        shiftedString.append(hashTable[newHashCode]);
		    } else {
		        // If the char is not a capital, just append the character
		        shiftedString.append(i);
		    }
		}
		return shiftedString.toString();
	}
	
	public void decode(String decodeString) {
	    // Save the original value of the shift
	    int restoreShift = shift;
	    
	    // Loop through caesar shift values.
	    for (int i=1; i < 26; i++) {
            System.out.print(i);
            shift = i;
            System.out.println(" Deciphered Text : "+encode(decodeString));
        }
        
        // Return the encode shift to its original value
        shift = restoreShift;
	}
}
