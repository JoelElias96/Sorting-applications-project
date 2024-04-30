# Sorting applications project

## Description
This Java application benchmarks various sorting algorithms to evaluate their performance across different array sizes. The project provides detailed performance insights for algorithms such as quick sort, merge sort (both recursive and iterative), and radix sort. Built-in Java `Arrays.sort` method is also tested for comparison.

## Features
- **Multiple Sorting Algorithms**: Includes quick sort (two versions: class and recitation), merge sort (recursive and iterative), and radix sort.
- **Performance Benchmarking**: Measures execution time for sorting arrays of various sizes from 10,000 to 1,000,000 elements.
- **Flexible Threshold Adjustment**: Allows the setting of a naive sort threshold to optimize sorting for smaller arrays.

## Requirements
- Java 8 or higher
- IDE that supports Java (e.g., IntelliJ IDEA, Eclipse)

## Usage
To run the sorting algorithm benchmarks, compile the Java files and run the `Main` class:
```bash
javac Main.java Sort.java
java Main
```

## Sorting Algorithms
- **Quick Sort (Class & Recitation)**: Two versions of quick sort demonstrating different partition techniques.
- **Merge Sort (Recursive & Iterative)**: Implements both recursive and iterative approaches to merge sort.
- **Radix Sort**: Utilizes a base-dependent sorting method ideal for large integers.
- **Java Built-In Sort**: Benchmarks against Java's native `Arrays.sort` to provide a performance baseline.

## Contributing
Contributions to improve the efficiency and accuracy of the sorting benchmarks are welcome. Please fork the repository and submit a pull request with your proposed changes.

## Authors
- Joel Elias

 
