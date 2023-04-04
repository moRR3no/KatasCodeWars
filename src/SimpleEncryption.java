import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Implement a pseudo-encryption algorithm which given a string S and an integer N concatenates all the odd-indexed
 * characters of S with all the even-indexed characters of S, this process should be repeated N times.
 * <p>
 * Examples:
 * <p>
 * encrypt("012345", 1)  =>  "135024"
 * encrypt("012345", 2)  =>  "135024"  ->  "304152"
 * encrypt("012345", 3)  =>  "135024"  ->  "304152"  ->  "012345"
 * <p>
 * encrypt("01234", 1)  =>  "13024"
 * encrypt("01234", 2)  =>  "13024"  ->  "32104"
 * encrypt("01234", 3)  =>  "13024"  ->  "32104"  ->  "20314"
 * Together with the encryption function, you should also implement a decryption function which reverses the process.
 * <p>
 * If the string S is an empty value or the integer N is not positive, return the first argument without changes.
 */


//Level of difficulty: 6kyu
public class SimpleEncryption {

    public static void main(String[] args) {
        String str = "abcdefg";

        String encrypted = encrypt(str, 1);
        System.out.println(encrypted);

        String decrypted = decrypt(encrypted, 1);
        System.out.println(decrypted);


    }

    public static String encrypt(final String text, final int n) {
        if (text.isEmpty() || n < 0) return text;
        StringBuilder stringBuilder = new StringBuilder();
        if (n >= 1) {
            List<Character> oddChars = new ArrayList<>();
            List<Character> evenChars = new ArrayList<>();

            for (int i = 0; i < text.length(); i++) {
                if (i % 2 == 0) evenChars.add(text.charAt(i));
                else oddChars.add(text.charAt(i));
            }

            for (char c : oddChars) {
                stringBuilder.append(c);
            }
            for (char c : evenChars) {
                stringBuilder.append(c);
            }
            return encrypt(stringBuilder.toString(), n - 1);
        }
        return text;


    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText.isEmpty() || n < 0) return encryptedText;
        StringBuilder stringBuilder = new StringBuilder();
        if (n >= 1) {
            String oddPart = encryptedText.substring(0, encryptedText.length() / 2);
            String evenPart = encryptedText.substring(encryptedText.length() / 2);
            Queue<Character> oddQueue = new LinkedList<>();
            Queue<Character> evenQueue = new LinkedList<>();

            for (char c : oddPart.toCharArray()) oddQueue.offer(c);
            for (char c : evenPart.toCharArray()) evenQueue.offer(c);


            while (true) {
                if (evenQueue.size() == 1) {
                    stringBuilder.append(evenQueue.poll());
                    break;
                }
                stringBuilder.append(evenQueue.poll());
                stringBuilder.append(oddQueue.poll());
            }
            return decrypt(stringBuilder.toString(), n-1);
        }
        return encryptedText;
    }

}