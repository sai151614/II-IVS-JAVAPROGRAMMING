import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5}; // Example array with duplicates
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] unique = new int[set.size()];
        int i = 0;
        for (int num : set) {
            unique[i++] = num;
        }
        System.out.println("Array after removing duplicates: " + Arrays.toString(unique));
    }
}