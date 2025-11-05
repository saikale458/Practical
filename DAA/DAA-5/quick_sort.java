// determinstic
public class QuickSortDeterministic {

    // Lomuto partition
    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];    // pivot as last element
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}



import java.util.Random;
import java.util.Arrays;

public class QuickSortRandomized {

    private static final Random rnd = new Random();

    // Randomized partition: pick random pivot and swap with high
    private static int randomizedPartition(int[] a, int low, int high) {
        int pivotIndex = low + rnd.nextInt(high - low + 1);
        swap(a, pivotIndex, high);
        return partition(a, low, high);
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }

    private static void quickSortRand(int[] a, int low, int high) {
        if (low < high) {
            int pi = randomizedPartition(a, low, high);
            quickSortRand(a, low, pi - 1);
            quickSortRand(a, pi + 1, high);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSortRand(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}



