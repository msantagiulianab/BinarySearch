import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {

        // Input list of integers separated by spaces
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strList = str.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < strList.length; i++) {
            arr.add(Integer.parseInt(strList[i]));
        }

        // Sorting the arraylist in ascending order
        Collections.sort(arr);

        // Setting the number I want to find in the array
        Random r = new Random();
        int target = r.nextInt((arr.get(arr.size() - 1) - arr.get(0)) + 1);
        System.out.println("Randomly generated number to find in the list: " + target);

        // Calling the binarySearch method
        boolean result = binarySearch(target, arr);
        if (result) System.out.println("The target is in the list.");
        else System.out.println("The target is NOT in the list.");

        // Closing the Scanner object
        sc.close();
    }

    // Binary search: halving at each iteration
    public static boolean binarySearch(int target, ArrayList<Integer> arr) {
        // Defining two pointers
        int left = 0;
        int right = arr.size() - 1;
        
        // Looking for the target
        while (left <= right) {
            int midpoint = (left + right) / 2;
            if (arr.get(midpoint) == target) {
                return true;
            } else if (arr.get(midpoint) < target) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return false;
    }
}
