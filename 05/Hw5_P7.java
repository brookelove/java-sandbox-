import java.util.Arrays;
import java.util.Random;

class Hw7 {
    // == INSRTION SORT ============================================
    public static void insertionSort(int[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            int cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > cur) { // while j is less than 0 and the data index is one less than j which
                                                 // is less than the current
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }
    }

    // Citation: GoodRich, M., Tamassia, R., &amp; Goldwasser, M. (2014). Data
    // Structures and Algorithims in Java (Sixth). Wiley.
    // ====MERGE SORT
    // ======================================================================
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) { // base case
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) { // traverse the left side of the array
            left[i] = a[i];
        }
        for (int i = mid; i < n; i++) { // traverse the right side of the array
            right[i - mid] = a[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(a, left, right, mid, n - mid);
    }
    // Baeldung. (2022, June 7). Merge sort in Java. Baeldung. Retrieved February
    // 21, 2023, from https://www.baeldung.com/java-merge-sort

    // ====QUICK SORT
    // ======================================================================
    // changes the array to have a temporary to swap the two integers around
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // checks to se if the integers are smaller or greater than eavch other and
    // traces across the array
    static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];

        int i = (low - 1); // right position of the pivot

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // main area of quiick sort that initally calls the left and right side
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }
    }

    // GeeksforGeeks. (2023, February 20). Quicksort. GeeksforGeeks. Retrieved
    // February 21, 2023, from https://www.geeksforgeeks.org/quick-sort/
    // === HEAP SORT
    // =======================================================================
    static void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;
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
        mergeSort(arr, arr.length);
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

    public static void randomArr(int[] arr, int upper) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100000) + 1;
        }
    }

    public static void main(String[] args) {
        int[] num = new int[10];
        int n = 10000;
        System.out.println("The current Algorithm n is: " + n);
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