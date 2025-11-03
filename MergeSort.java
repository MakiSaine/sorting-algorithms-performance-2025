import java.io.*;
import java.util.*;

public class MergeSort {
    private static int mergeCount = 0;

    // Method to load unique latitude values from CSV
    public static Set<Double> loadUniqueLatitudes(String filePath) {
        Set<Double> latitudes = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 2) {
                    String latStr = values[2].trim().replaceAll("^\"|\"$", "");
                    if (!latStr.isEmpty()) {
                        latitudes.add(Double.parseDouble(latStr));
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return latitudes;
    }

    // Utility method to shuffle array
    public static void shuffleArray(double[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            double temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Merge Sort implementation
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Avoid integer overflow
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(double[] arr, int left, int mid, int right) {
        mergeCount++; // Increment merge count
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] L = new double[n1];
        double[] R = new double[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void main(String[] args) {
        // Load unique latitudes
        Set<Double> latitudeSet = loadUniqueLatitudes("worldcities.csv");
        if (latitudeSet.isEmpty()) {
            System.out.println("No latitudes loaded. Check file path or format.");
            return;
        }
        double[] latitudes = latitudeSet.stream().mapToDouble(Double::doubleValue).toArray();

        // Reset merge count
        mergeCount = 0;

        // Shuffle array for testing
        double[] shuffledLatitudes = latitudes.clone();
        shuffleArray(shuffledLatitudes);

        // Run Merge Sort
        System.out.println("Sorting Unique City Latitudes using Merge Sort:");
        mergeSort(shuffledLatitudes, 0, shuffledLatitudes.length - 1);
        System.out.println("Number of merges: " + mergeCount);
    }
}