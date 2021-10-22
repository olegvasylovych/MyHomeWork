package com.company;

import static com.company.MergeSort.printArray;

public class Main {

    public static void main(String[] args) {
        int arr[] = { 1212, 544, 34, 6654, 454, 32, 54, 54 };

        System.out.println("Початковий масив");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nВідсортований масив");
        printArray(arr);
    }
}
