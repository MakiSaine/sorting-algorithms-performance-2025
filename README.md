# Sorting Algorithms Performance 2025

This project explores the design, implementation, and performance of four core sorting algorithms — Bubble Sort, Insertion Sort, Merge Sort, and Quick Sort — implemented in Java.  
The algorithms were applied to real latitude data extracted from the World Cities dataset to analyze efficiency, complexity, and practical behavior.  
The work includes both the full source code and the final exam report that explains the results and methodology in detail.

---

## Table of Contents
- [About the Project](#about-the-project)
- [Algorithms Included](#algorithms-included)
  - [Bubble Sort](#bubble-sort)
  - [Insertion Sort](#insertion-sort)
  - [Merge Sort](#merge-sort)
  - [Quick Sort](#quick-sort)
- [Dataset](#dataset)
- [Files](#files)
- [How to Run](#how-to-run)
- [Performance Insights](#performance-insights)
- [Download and View](#download-and-view)
- [Reflection](#reflection)
- [Contact](#contact)

---

## About the Project
The goal of this project was to understand how different sorting algorithms behave when tested on real-world data rather than random test arrays.  
Each algorithm was implemented from scratch in Java and applied to latitude values extracted from the World Cities dataset.  
By running and comparing execution times, merge counts, and partition efficiency, the project highlights how algorithmic strategy affects performance.

---

## Algorithms Included

### Bubble Sort
Bubble Sort works by repeatedly comparing and swapping adjacent elements until the array is sorted.  
This project includes both optimized and non-optimized versions.  
The optimized version stops early if no swaps are made in a pass, which reduces runtime for nearly sorted arrays.  

**Time Complexity**  
- Best Case (Optimized): O(n)  
- Average and Worst Case: O(n²)  

---

### Insertion Sort
Insertion Sort builds a sorted array one element at a time by inserting each element into its correct position.  
It performs efficiently on small or partially sorted datasets.  

**Time Complexity**  
- Best Case: O(n) (when already sorted)  
- Average and Worst Case: O(n²)

---

### Merge Sort
Merge Sort follows a divide-and-conquer strategy, splitting the dataset recursively and merging sorted halves.  
It is stable, consistent, and efficient for larger datasets.

**Time Complexity**  
- All Cases: O(n log n)

**Key Property**  
The number of merge operations grows linearly with the recursive divisions, averaging around 2n - 1 for an array of size n.

---

### Quick Sort
Quick Sort partitions the array around a chosen pivot and recursively sorts the subarrays.  
Three pivot strategies were tested:
1. First Element as Pivot  
2. Last Element as Pivot  
3. Random Element as Pivot  

**Findings:**  
The random pivot produced the best balance between partitions and the fewest comparisons.  
It is generally the most efficient and robust approach.

**Time Complexity**  
- Average Case: O(n log n)  
- Worst Case: O(n²) (if partitions are unbalanced)

---

## Dataset
The dataset used for this project is a subset of the **World Cities Database**, focusing on unique latitude values.  
These real numbers simulate natural variation and randomness in real-world data.

---

## Files
| File | Description |
|------|--------------|
| `BubbleSort.java` | Implementation of optimized and non-optimized Bubble Sort |
| `InsertionSort.java` | Implementation of Insertion Sort |
| `MergeSort.java` | Implementation of Merge Sort using recursive merging |
| `QuickSort.java` | Implementation of Quick Sort with three pivot strategies |
| `worldcities.csv` | Dataset used for sorting (unique latitude values) |
| `PG4200 - Final Exam Report.pdf` | Full academic report with analysis and comparison |

---

## How to Run
You can compile and run each file individually using the terminal or any IDE such as IntelliJ or Eclipse.

### Example (Command Line)
```bash
javac BubbleSort.java
java BubbleSort
```

Repeat the same steps for:
```
InsertionSort.java
MergeSort.java
QuickSort.java
```

Make sure the file `worldcities.csv` is located in the same directory if required by the algorithm.

---

## Performance Insights
The algorithms were compared based on the number of comparisons and execution time.  
Results from the report (dataset of 1000 latitudes):

| Algorithm | Comparisons | Execution Time |
|------------|--------------|----------------|
| Bubble Sort (Optimized) | 240,000 | 18.2 ms |
| Insertion Sort | 220,000 | 16.7 ms |
| Merge Sort | 12,000 | 5.6 ms |
| Quick Sort (Random Pivot) | 9,000 | 4.8 ms |

**Conclusion:**  
Quick Sort with a random pivot provided the best performance due to its balanced partitioning and reduced comparison count.

---

## Download and View
📄 [Open Full Report (PDF)](docs/PG4200%20-%20Final%20Exam%20Report.pdf)  
📂 [Download worldcities.csv](https://github.com/MakiSaine/sorting-algorithms-performance-2025/raw/main/worldcities.csv)  
📘 [View QuickSort.java](https://github.com/MakiSaine/sorting-algorithms-performance-2025/blob/main/QuickSort.java)

---

## Reflection
This project demonstrates both programming and analytical skills through practical implementation and performance testing.  
It shows how theoretical complexity directly translates into measurable execution differences.  
The exercise strengthened my understanding of algorithm optimization, data structures, and performance evaluation.

---

© 2025 Mahamed-Maki Saine  
Cybersecurity and IT Project Management
