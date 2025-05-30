/**
 * A class for performing Caesar cipher encryption and decryption on text.
 */
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

    /**
     * Constructs an encrypt object with the specified shift value.
     *
     * @param newShift The number of positions to shift characters in the cipher.
     *                 If negative, wraps around to a positive shift value.
     */
    public encrypt(int newShift) {
        // Fix extra
        if (newShift < 0) {
            shift = 26 + (newShift % 26);
        } else {
            shift = newShift;
        }
    }

    /**
     * Updates the shift value used for encryption/decryption.
     *
     * @param newShift The new number of positions to shift characters.
     *                 If negative, wraps around to a positive shift value.
     */
    public void newShift(int newShift) {
        if (newShift < 0) {
            shift = 26 + (newShift % 26);
        } else {
            shift = newShift;
        }
    }

    /**
     * Encrypts a message using the Caesar cipher with the current shift value.
     *
     * @param message The string to encrypt
     * @return The encrypted string with each letter shifted by the shift value.
     *         Non-letter characters remain unchanged.
     */
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

    /**
     * Decrypts a message that was encrypted using the Caesar cipher.
     *
     * @param decodeString The encrypted string to decrypt
     * @return The decrypted string with each letter shifted back by the shift value.
     *         Non-letter characters remain unchanged.
     */
    public String decode(String decodeString) {
        // Save the original value of the shift
        newShift(-shift);
        String decoded = encode(decodeString);
        // Return the encode shift to its original value
        newShift(-shift);
        return decoded;
    }
}
