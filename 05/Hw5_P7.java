import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class Hw7 {
    // code for insertion sort
    // Citation:
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

    // code for merge sort
    // Citation:
    // merge contents of the arrays S1 ans S2 into properly sized array S
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0;
        int j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
    }

    // Citation:
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2)
            return;
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        merge(S1, S2, S, comp);
    }

    // code for quick sort
    // Citation
    public static <K> void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b) {
        if (a > -b)
            return;
        int left = a;
        int right = b - 1;
        K pivot = S[b];
        K temp;
        while (left <= right) {
            // scan until reach value that is equal or greater than the pivot/right marker
            while (left <= right && comp.compare(S[left], pivot) < 0) {
                left++;
            }
            while (left <= right && comp.compare(S[right], pivot) < 0) {
                left++;
                right--;
            }
            if (left <= right) {
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }

        }
        temp = S[left];
        S[left] = S[right];
        S[b] = temp;

        quickSortInPlace(S, comp, a, left - 1);
        quickSortInPlace(S, comp, left + 1, b);
    }
    // heap sort
    // Citation

    // create random integers
    public static void randomArr(int[] arr, int upper) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(1000000) + 1;
        }
    }

    public static void insertionTime(int arr[]) {
        // 3. create start time
        long startTime = System.nanoTime();
        // 4. Run interstion sort and calc the elapsted time.
        insertionSort(arr);
        // 5. create end time
        long endTime = System.nanoTime();
        // 6. subtract the two
        long elapsedTime = endTime - startTime;
        System.out.println("The elapsed time for insertion sort is" + elapsedTime);
    }

    public static void mergeTime(int arr[]) {
        // 3. create start time
        long startTime = System.nanoTime();
        // 4. Run interstion sort and calc the elapsted time.
        mergeSort(null, null);
        ;
        // 5. create end time
        long endTime = System.nanoTime();
        // 6. subtract the two
        long elapsedTime = endTime - startTime;
        System.out.println("The elapsed time for merge sort is" + elapsedTime);
    }

    public static void quickTime(int arr[]) {
        // 3. create start time
        long startTime = System.nanoTime();
        // 4. Run interstion sort and calc the elapsted time.
        // quickSortInPlace(null);
        // 5. create end time
        long endTime = System.nanoTime();
        // 6. subtract the two
        long elapsedTime = endTime - startTime;
        System.out.println("The elapsed time for hash sort is" + elapsedTime);
    }

    // code for heap sort found on interent
    /*
     * Citation:
     * Parewa Labs Pvt.Ltd.(2023,February 20).
     * Heap sort
     * algorithm. Heap Sort
     * Algorithm. Retrieved February 20,2023,
     * from https:// www.programiz.com/dsa/heap-sort
     */

    public void sort(int arr[]) {
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

    void heapify(int arr[], int n, int i) {
        // Find largest among root, left child and right child
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[10];
        int n = 10000;
        // 1. create random array that is 10
        randomArr(num, 1000000);
        System.out.println(Arrays.toString(num));
        // // 2. create a copy the random array
        // int[] copyOne = Arrays.copyOf(num, 10)
        // // 3. run the insertion sort time
        // insertionTime();
        // // 4. create a copy the random array
        // int[] copyTwo = Arrays.copyOf(num, 10)
        // // 5. run the merge sort sort time
        // mergeTime(null);
        // // 6. create a copy the random array
        // int[] copyThree = Arrays.copyOf(num, 10)
        // // 7. runn the quick sort time
        // quickTime(num);
        // // 8. create a copy the random array
        // int[] copyFour = Arrays.copyOf(num, 10)

        // // 9. runn the heap sort time

    }

}