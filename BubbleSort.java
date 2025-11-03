import java.io.*;
import java.util.*;

public class BubbleSort {

    // Utility method to swap elements
    private static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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
            swap(arr, i, j);
        }
    }

    // Non-Optimized Bubble Sort
    public static void nonOptimizedBubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) { // Fixed loop bound
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Optimized Bubble Sort
    public static void optimizedBubbleSort(double[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
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

        // Shuffle array for testing
        double[] shuffledLatitudes = latitudes.clone();
        shuffleArray(shuffledLatitudes);

        // Run Bubble Sort algorithms
        System.out.println("Sorting Unique City Latitudes:");
        nonOptimizedBubbleSort(shuffledLatitudes.clone());
        optimizedBubbleSort(shuffledLatitudes.clone());
    }
}