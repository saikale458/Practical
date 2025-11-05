import java.util.*;

public class QuickSort {
    private int[] array;

    // Constructor
    public QuickSort(int[] array) {
        this.array = array;
    }

    // Deterministic partition method (last element as pivot)
    private int partition(int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap pivot to correct position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Randomized partition method
    private int partitionRandom(int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;

        // Swap pivot with last element
        int temp = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = temp;

        return partition(low, high);
    }

    // Deterministic quicksort
    public void sortDeterministic(int low, int high) {
        if (low < high) {
            int pivot = partition(low, high);
            sortDeterministic(low, pivot - 1);
            sortDeterministic(pivot + 1, high);
        }
    }

    // Randomized quicksort
    public void sortRandomized(int low, int high) {
        if (low < high) {
            int pivot = partitionRandom(low, high);
            sortRandomized(low, pivot - 1);
            sortRandomized(pivot + 1, high);
        }
    }

    // Utility method to print array
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Press Ctrl + C to exit...");
                System.out.print("Enter array elements (space-separated): ");
                String[] input = sc.nextLine().trim().split(" ");
                int[] arr = new int[input.length];
                for (int i = 0; i < input.length; i++) {
                    arr[i] = Integer.parseInt(input[i]);
                }

                // Deterministic QuickSort
                System.out.println("Deterministic variant of sort:");
                int[] arrDet = Arrays.copyOf(arr, arr.length);
                QuickSort sort1 = new QuickSort(arrDet);
                sort1.sortDeterministic(0, arrDet.length - 1);
                sort1.printArray();

                // Randomized QuickSort
                System.out.println("Randomized variant of sort:");
                int[] arrRand = Arrays.copyOf(arr, arr.length);
                QuickSort sort2 = new QuickSort(arrRand);
                sort2.sortRandomized(0, arrRand.length - 1);
                sort2.printArray();

                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Program terminated.");
        }

        sc.close();
    }
}
