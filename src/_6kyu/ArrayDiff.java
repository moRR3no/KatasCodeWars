package _6kyu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns
 * the result.
 *
 * It should remove all values from list a, which are present in list b keeping their order.
 *
 * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
 * If a value is present in b, all of its occurrences must be removed from the other:
 *
 * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */


//Level of difficulty: 6kyu
public class ArrayDiff {

    public static void main(String[] args) {

        int[] arrayOne = new int[] {1,2,4,6,2,1};
        int[] arrayTwo = new int[] {4,6,3};
        List<Integer> listOne = Arrays.stream(arrayOne).boxed().toList();
        List<Integer> listTwo = Arrays.stream(arrayTwo).boxed().toList();


        Arrays.stream(arrayDiff(new int [] {1,2,2}, new int[] {})).forEach(System.out::println);


    }

    public static int[] arrayDiff(int[] a, int[] b) {
        return Arrays.stream(a).boxed().toList().stream()
                .filter(x -> !Arrays.stream(b).boxed().toList().contains(x))
                .toList()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    //best practice
    public static int[] arrayDiff1(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }

}
