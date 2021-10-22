package com.company;

public class MergeSort {
    // combine two subarrays arr[].
    // first subarrays is arr[l..m]
    // second subarrays is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // find the demensions of the two subarrays to merge
        int n1 = m - l + 1;
        int n2 = r - m;

        /* create temporary subarrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*copythe sorted arrays in temporary*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Iterators contain the current index of the temporary subarray 
        int i = 0, j = 0;

        // An iterator that contains the current index of the sorted array 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements from the left array */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy the remaining elements from the right array*/
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // The main function that sorts arr [l..r] using 
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // looking for the middle
            int m = l + (r - l) / 2;

            // We sort the first and second halves 
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // combine sorted halves 
            merge(arr, l, m, r);
        }
    }

    /* Function for printing an array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
