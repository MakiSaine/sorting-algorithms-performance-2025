import java.util.*;

public class QuickSort {
    private static int comparisonsFirst = 0;
    private static int comparisonsLast = 0;
    private static int comparisonsRandom = 0;

    // QuickSort using First element as Pivot
    public static void quickSortFirst(double[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionFirst(arr, low, high);
            quickSortFirst(arr, low, pi - 1);
            quickSortFirst(arr, pi + 1, high);
        }
    }

    private static int partitionFirst(double[] arr, int low, int high) {
        double pivot = arr[low];
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            comparisonsFirst++;
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    // QuickSort using Last element as Pivot
    public static void quickSortLast(double[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionLast(arr, low, high);
            quickSortLast(arr, low, pi - 1);
            quickSortLast(arr, pi + 1, high);
        }
    }

    private static int partitionLast(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisonsLast++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // QuickSort using Random element as Pivot
    public static void quickSortRandom(double[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionRandom(arr, low, high);
            quickSortRandom(arr, low, pi - 1);
            quickSortRandom(arr, pi + 1, high);
        }
    }

    private static int partitionRandom(double[] arr, int low, int high) {
        Random rand = new Random();
        int randomPivotIndex = low + rand.nextInt(high - low + 1);
        swap(arr, randomPivotIndex, high); // Move random pivot to end
        double pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisonsRandom++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Load unique latitudes (assumed method from BubbleSort)
        Set<Double> latitudeSet = BubbleSort.loadUniqueLatitudes("worldcities.csv");
        double[] latitudes = latitudeSet.stream().mapToDouble(Double::doubleValue).toArray();

        double[] firstPivotArray = latitudes.clone();
        double[] lastPivotArray = latitudes.clone();
        double[] randomPivotArray = latitudes.clone();

        // Quick Sort with First Element as Pivot
        comparisonsFirst = 0; // Reset counter
        long startTimeFirst = System.nanoTime();
        quickSortFirst(firstPivotArray, 0, firstPivotArray.length - 1);
        long endTimeFirst = System.nanoTime();
        System.out.println("QuickSort (First Pivot) Execution Time: " + (endTimeFirst - startTimeFirst) / 1e6 + " ms");
        System.out.println("Comparisons (First Pivot): " + comparisonsFirst);

        // Quick Sort with Last Element as Pivot
        comparisonsLast = 0; // Reset counter
        long startTimeLast = System.nanoTime();
        quickSortLast(lastPivotArray, 0, lastPivotArray.length - 1);
        long endTimeLast = System.nanoTime();
        System.out.println("QuickSort (Last Pivot) Execution Time: " + (endTimeLast - startTimeLast) / 1e6 + " ms");
        System.out.println("Comparisons (Last Pivot): " + comparisonsLast);

        // Quick Sort with Random Element as Pivot
        comparisonsRandom = 0; // Reset counter
        long startTimeRandom = System.nanoTime();
        quickSortRandom(randomPivotArray, 0, randomPivotArray.length - 1);
        long endTimeRandom = System.nanoTime();
        System.out
                .println("QuickSort (Random Pivot) Execution Time: " + (endTimeRandom - startTimeRandom) / 1e6 + " ms");
        System.out.println("Comparisons (Random Pivot): " + comparisonsRandom);

        // Analysis of best pivot strategy
        System.out.println("\nAnalysis:");
        System.out
                .println("Does the number of comparisons change? Yes, due to pivot selection affecting partitioning.");
        int minComparisons = Math.min(comparisonsFirst, Math.min(comparisonsLast, comparisonsRandom));
        String bestStrategy = (minComparisons == comparisonsFirst) ? "First Pivot"
                : (minComparisons == comparisonsLast) ? "Last Pivot" : "Random Pivot";
        System.out.println(
                "Best pivot strategy for this dataset: " + bestStrategy + " with " + minComparisons + " comparisons.");
    }
}