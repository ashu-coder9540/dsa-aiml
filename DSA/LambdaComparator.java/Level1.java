import java.util.*;
public class Level1 {
        public static void main(String[] args) {
        /* 1. Sort Integer Array
        👉 Sort array in: a)Ascending b)Descending */
        int[] arr = {5, 2, 9, 1, 3};
        // Sort in Ascending order
        Arrays.sort(arr);
        System.out.println("Ascending order: " + Arrays.toString(arr));
        
        Integer[] arr2 = {5, 2, 9, 1, 3};
        // Sort in Descending order
      /*   Arrays.sort(arr2,(a, b) -> b - a); */
        Arrays.sort(arr2,(a, b) -> Integer.compare(b, a));
        System.out.println("Descending order: " + Arrays.toString(arr2));

        // 2. Sort String Array by Length
        String[] strArr = {"apple", "banana", "kiwi", "grapefruit"};
        Arrays.sort(strArr, (a, b) -> Integer.compare(b.charAt(0), a.charAt(0)));
        System.out.println("Sorted by reverse char order: " + Arrays.toString(strArr));

        // 3. Sort List of Integers
        List<Integer> intList = Arrays.asList(5, 2, 9, 1, 3);
        // intList.sort((a, b) -> Integer.compare(a, b));
        Collections.sort(intList);
        System.out.println("Sorted list: " + intList);
        
        // 4. Sort Based on Last Digit
        Integer[] arr3 = {23, 45, 12, 39, 56};
        Arrays.sort(arr3, (a, b) -> Integer.compare(b % 10, a % 10)); 
        System.out.println("Sorted by last digit: " + Arrays.toString(arr3));

        // 5. Sort list of integers by even first, then odd
        List<Integer> intList2 = Arrays.asList(5, 2, 9, 1, 3, 4);
        intList2.sort((a, b) -> {
            if((a%2 == 0) && (b%2 !=0)){
                return -1; // No swap, a is even and b is odd
            }else if ((a%2 != 0) && (b%2 ==0)){
                return 1; // Swap, a is odd and b is even
            }else{
                return 0; // No swap, both are even or both are odd
            }
        });
        System.out.println("Sorted by even first then odd: " + intList2);    
    }
}
