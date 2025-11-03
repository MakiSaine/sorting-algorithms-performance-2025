import java.io.*;
import java.util.*;

public class InsertionSort {

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

    // Insertion Sort implementation
    public static void insertionSort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            double key = arr[i]; // Current element to insert
            int j = i - 1;
            // Shift larger elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // Place key in its correct position
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

        // Run Insertion Sort
        System.out.println("Sorting Unique City Latitudes using Insertion Sort:");
        insertionSort(shuffledLatitudes.clone());
    }
}