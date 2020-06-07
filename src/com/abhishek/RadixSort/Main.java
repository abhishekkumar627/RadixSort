package com.abhishek.RadixSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[]{4725, 4586, 1330, 8792, 1594, 5729};
        System.out.println("Initial Array : "+Arrays.toString(intArray));
        radixSort(intArray, 4, 10);
        System.out.println(Arrays.toString(intArray));
    }
    private static void radixSort(int[] input, int width, int radix) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }
    private static int getDigit(int inputValue, int position, int radix) {
        return (inputValue / (int) Math.pow(radix, position)) % radix;
    }

    private static void radixSingleSort(int[] input, int position, int radix) {
        int numlengths = input.length;
        int countingArray[] = new int[radix];
        //Calculating count as per digits
        for (int i = 0; i < input.length; i++) {
            countingArray[getDigit(input[i], position, radix)]++;
        }
        System.out.println("Counting digits :  " + Arrays.toString(countingArray));
        // counting on basis of count of digits less than or equal to
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] += countingArray[i - 1];
        }
        System.out.println("Counting digits less than or equal to :" + Arrays.toString(countingArray));
        int tempArray[] = new int[numlengths];
        // setting values at temp array indexes
        //4725, 4586, 1330, 8792, 1594, 5729
        for (int tempIndex = numlengths - 1; tempIndex >= 0; tempIndex--) {
            tempArray[--countingArray[getDigit(input[tempIndex], position, radix)]] = input[tempIndex];
        }
        System.out.println("After inserting into temp array :" + Arrays.toString(tempArray));
        //copying back tempArray to inputArray
        for (int i = 0; i < input.length; i++) {
            input[i] = tempArray[i];
        }
    }
}
