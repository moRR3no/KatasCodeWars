package eight_kyu;

/**
 * Alex just got a new hula hop, he loves it but feels discouraged because his little brother is better than him
 *
 * Write a program where Alex can input (n) how many times the hoop goes round and it will return him an encouraging message :)
 *
 * If Alex gets 10 or more hoops, return the string "Great, now move on to tricks".
 * If he doesn't get 10 hoops, return the string "Keep at it until you get it".
 */

//Level of difficulty: 8kyu
public class KeepUpTheHoop {
    public static void main(String[] args) {
        System.out.println(hoopCount(7));
    }

    public static String hoopCount(int n){
        if (n<10) return "Keep at it until you get it";
        return "Great, now move on to tricks";
    }

    public static String hoopCountBestPractice(int n){
        return n<10?"Keep at it until you get it":"Great, now move on to tricks";
    }
}
