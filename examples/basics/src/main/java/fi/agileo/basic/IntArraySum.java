package fi.agileo.basic;

import java.util.Arrays;
import java.util.Comparator;

public class IntArraySum {

    static String arrayToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length-1; i++) {
            str += arr[i] + ",";
        }
        return str + arr[arr.length-1] + "]";
    }

    static int countSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int countSumVariableLength(int... arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    public static void main(String args[]) {
        int[] t = {10, 20, 30, 40, 50, 60, 100};

        System.out.println("Counting sum for " + arrayToString(t));

        System.out.println("1st sum: " + countSum(t));
        System.out.println("2nd sum: " + countSumVariableLength(t));
    }
}
