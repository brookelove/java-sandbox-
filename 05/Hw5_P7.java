import java.util.Arrays;
import java.util.Comparator;

class Hw7 {
    // code for insertion sort
    // Citation:
    public static void insertionSort(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            char cur = data[k];
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
    }
    // code for heap sort found on interent

}