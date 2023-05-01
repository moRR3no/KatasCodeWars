package six_kyu;

/**
 * You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other
 * items. We want to create the text that should be displayed next to such an item.
 * <p>
 * Implement the function which takes an array containing the names of people that like an item. It must return the
 * display text as shown in the examples:
 * <p>
 * []                                -->  "no one likes this"
 * ["Peter"]                         -->  "Peter likes this"
 * ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
 * ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
 * ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
 * Note: For 4 or more names, the number in "and 2 others" simply increases.
 */

//Level of difficulty: 6kyu
public class LikeClass {
    public static void main(String[] args) {
        String[] arr = {"Alex", "Jacob", "Mark", "Max"};
        System.out.println(whoLikesIt(arr));
    }

    public static String whoLikesIt(String... names) {
        int arrayLength = names.length;
        switch (arrayLength) {
            case 0:
                return "no one likes this";
            case 1:
                return names[0] + " likes this";
            case 2:
                return names[0] + " and " + names[1] + " like this";
            case 3:
                return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default:
                return names[0] + ", " + names[1] + " and " + (arrayLength - 2) + " others like this";
        }
    }
}