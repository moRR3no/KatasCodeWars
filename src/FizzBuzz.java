/**
 *
 This is slightly more difficult version of the famous FizzBuzz problem which is sometimes given as a first problem
 for job interviews. (See also: FizzBuzz Code.) Consider the series of numbers beginning at start and running up to
 but not including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4. Return a new String[] array
 containing the string form of these numbers, except for multiples of 3, use "Fizz" instead of the number, for
 multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make
 the String form of an int or other type. This version is a little more complicated than the usual version since you
 have to allocate and index into an array instead of just printing, and we vary the start/end instead of just always
 doing 1..100.


 fizzBuzz(1, 6) → ["1", "2", "Fizz", "4", "Buzz"]
 fizzBuzz(1, 8) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
 fizzBuzz(1, 11) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"]
 */


//Exercise from CodingBat.com
public class FizzBuzz {
    public static void main(String[] args) {
        for (Object i : fizzBuzz(1, 6)) {
            System.out.println(i);
        }
    }

    public static String[] fizzBuzz(int start, int end) {
        int arrLength = end - start;
        int[] ints = new int[arrLength];
        String[] endArray = new String[arrLength];

        //definiowanie tabeli intów
        int count = 0;
        for (int i = start; i < end; i++) {
            ints[count] = i;
            count++;
        }

        count=0;
        for (int j : ints) {
            if (j % 3 == 0 && j % 5 == 0) endArray[count] = "FizzBuzz!";
            else if (j % 3 == 0) endArray[count] = "Fizz!";
            else if (j % 5 == 0) endArray[count] = "Buzz!";
            else endArray[count] = String.valueOf(j);
            count++;
        }
        return endArray;
    }
}