
import java.util.Random;

public class Main1 {
    public static void main(String[] args) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int j = 0; j < 4; j++) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int shift = random.nextInt(15);
            int length = 5;
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(alpha.length());
                char randomChar = alpha.charAt(index);
                sb.append(randomChar);
            }
            String message = sb.toString();
            System.out.println("The plain text is: " + message);
            System.out.println("Enter the key shift number: " + shift);
            String encryptedMessage = encryptM(message, shift);
            System.out.println("Encrypted text: " + encryptedMessage);
            String decryptedMessage = decryptM(encryptedMessage,shift);
            System.out.println("Decrypted text: " + decryptedMessage);
        }
    }

    public static String encryptM(String message, int shift) {
        StringBuilder encryptMessage = new StringBuilder();
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) ((c - 'a' + shift + 26) % 26 +'a');
            }
            encryptMessage.append(c);
        }
        return encryptMessage.toString();
    }
     public static String decryptM(String message, int shift) {
        StringBuilder decryptmessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) ((c - 'a' - shift + 26) % 26 +'a');
            }
            decryptmessage.append(c);
        }
        return decryptmessage.toString();
    }
}
