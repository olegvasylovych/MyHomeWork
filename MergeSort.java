package com.company;

public class MergeSort {
    // Обєднуємо два підмасиви arr[].
    // перший підмасив є arr[l..m]
    // другий підмасив є arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // знаходимо розміри двох підмасивів для об'єднання
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Створюємо тимчасові підмасиви */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Копіюємо відсортовані масиви в тимчасові*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Ітератори містять поточний індекс тимчасового підмасива
        int i = 0, j = 0;

        // Ітератор який містить поточний індекс відсортованого масиву
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

        /* Копіюємо елементи, що залишилися з лівого підмасива */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Копіюємо елементи, що залишилися з правого підмасива*/
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Основна функція що сортує arr[l..r] використовуючи
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // шукаємо середину
            int m = l + (r - l) / 2;

            // Сортуємо першу і другу половинки
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // об'єднуємо відсортовані половинки
            merge(arr, l, m, r);
        }
    }

    /* Функція для друку масива розміром n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
