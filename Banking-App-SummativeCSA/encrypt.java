// Taken from an earlier project (written by Luyu tho)

public class encrypt {

    private int shift;

    // Apparently, there's no way to turn a hash code of a char back into a char, therefore I just wrote out this reference table.
    private char[] hashTable = {
        'A',
        'B',
        'C',
        'D',
        'E',
        'F',
        'G',
        'H',
        'I',
        'J',
        'K',
        'L',
        'M',
        'N',
        'O',
        'P',
        'Q',
        'R',
        'S',
        'T',
        'U',
        'V',
        'W',
        'X',
        'Y',
        'Z',
    };
    private char[] hashLowerTable = {
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z',
    };

    public encrypt(int newShift) {
        // Fix extra
        if (newShift < 0) {
            shift = 26 + (newShift % 26);
        } else {
            shift = newShift;
        }
    }

    // Method to change shift value
    public void newShift(int newShift) {
        if (newShift < 0) {
            shift = 26 + (newShift % 26);
        } else {
            shift = newShift;
        }
    }

    // Method to encode a string given the object's shift property
    public String encode(String message) {
        char[] list = message.toCharArray();

        // Iterate through the characters of the string
        StringBuilder shiftedString = new StringBuilder();
        for (char i : list) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    // calculate the new hash code
                    int newHashCode = (Character.hashCode(i) - 65 + shift) % 26;

                    // apply the caesar shift char
                    shiftedString.append(hashTable[newHashCode]);
                } else {
                    // calculate the new hash code
                    int newHashCode = (Character.hashCode(i) - 97 + shift) % 26;

                    // apply the caesar shift char
                    shiftedString.append(hashLowerTable[newHashCode]);
                }
            } else {
                // If the char is not a letter, just append the character
                shiftedString.append(i);
            }
        }
        return shiftedString.toString();
    }

    public void decode(String decodeString) {
        // Save the original value of the shift
        int restoreShift = shift;

        // Loop through caesar shift values.
        for (int i = 1; i < 26; i++) {
            System.out.print(i);
            shift = i;
            System.out.println(" Deciphered Text : " + encode(decodeString));
        }

        // Return the encode shift to its original value
        shift = restoreShift;
    }
}
