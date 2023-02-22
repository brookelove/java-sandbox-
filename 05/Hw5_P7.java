import java.util.Arrays;
import java.util.Random;

class Hw7 {
    // code for insertion sort
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            int cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }
    }

    // Citation: GoodRich, M., Tamassia, R., &amp; Goldwasser, M. (2014). Data
    // Structures and Algorithims in Java (Sixth). Wiley.
    // ==========================================================================
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
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

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    // https://www.geeksforgeeks.org/merge-sort/. (2023, February 17). Merge sort
    // algorithm. GeeksforGeeks. Retrieved February 21, 2023, from
    // https://www.geeksforgeeks.org/merge-sort/

    // ==========================================================================
    // quick sort
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // GeeksforGeeks. (2023, February 20). Quicksort. GeeksforGeeks. Retrieved
    // February 21, 2023, from https://www.geeksforgeeks.org/quick-sort/
    // ==========================================================================
    public static void randomArr(int[] arr, int upper) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(1000000) + 1;
        }
    }

    // ==========================================================================
    static void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    /*
     * Citation:
     * Parewa Labs Pvt.Ltd.(2023,February 20).
     * Heap sort
     * algorithm. Heap Sort
     * Algorithm. Retrieved February 20,2023,
     * from https:// www.programiz.com/dsa/heap-sort
     */

    public static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Heapify root element
            heapify(arr, i, 0);
        }
    }
    /*
     * Citation:
     * Parewa Labs Pvt.Ltd.(2023,February 20).
     * Heap sort
     * algorithm. Heap Sort
     * Algorithm. Retrieved February 20,2023,
     * from https:// www.programiz.com/dsa/heap-sort
     */

    public static void insertionTime(int arr[]) {
        // 3. create start time
        long startTime = System.nanoTime();
        // 4. Run interstion sort and calc the elapsted time.
        insertionSort(arr);
        // 5. create end time
        long endTime = System.nanoTime();
        // 6. subtract the two
        long elapsedTime = endTime - startTime;
        System.out.println("The elapsed time for insertion sort is " + elapsedTime);
    }

    public static <K> void mergeTime(int arr[]) {
        long startTime = System.nanoTime();
        // mergeSort();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("The elapsed time for merge sort is " + elapsedTime);
    }

    public static void quickTime(int arr[]) {
        // 3. create start time
        long startTime = System.nanoTime();
        // 4. Run interstion sort and calc the elapsted time
        quickSort(arr, 0, arr.length - 1);
        // 5. create end time
        long endTime = System.nanoTime();
        // 6. subtract the two
        long elapsedTime = endTime - startTime;
        System.out.println("The elapsed time for quick sort is " + elapsedTime);
    }

    public static void heapTime(int arr[]) {
        // 3. create start time
        long startTime = System.nanoTime();
        // 4. Run interstion sort and calc the elapsted time.
        heapSort(arr);
        // 5. create end time
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("The elapsed time for heap sort is " + elapsedTime);
    }

    public static void main(String[] args) {
        int[] num = new int[10];
        int n = 100000;
        // 1. create random array that is 10
        randomArr(num, n);
        // 2. create a copy the random array
        int[] copyOne = Arrays.copyOf(num, 10);
        // 3. run the insertion sort time
        insertionTime(copyOne);
        // 4. create a copy the random array
        int[] copyTwo = Arrays.copyOf(num, 10);
        // 5. run the merge sort sort time
        mergeTime(copyTwo); // need to finish this one
        // 6. create a copy the random array
        int[] copyThree = Arrays.copyOf(num, 10);
        // 7. runn the quick sort time
        quickTime(copyThree); // need to finish this one
        // // 8. create a copy the random array
        int[] copyFour = Arrays.copyOf(num, 10);
        // 9. runn the heap sort time
        heapTime(copyFour);

    }

}