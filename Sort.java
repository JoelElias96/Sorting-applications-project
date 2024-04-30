import java.lang.reflect.Array;

public class Sort <T extends Comparable<T>> {

    /**
     * Sort  object constructure
     */
    public Sort() {
        this.threshold = 0;
    }

    private int threshold;

    /**
     * This is the standard, unmodified version of Quicksort. This version of Quicksort should use the
     * partition routine you saw in the lecture.
     *
     * @param array
     */
    public void quickSortClass(T[] array) {
        quickSortClass(array, 0, array.length - 1);
    }


    /**
     * This is the standard, unmodified version of Quicksort. This version of Quicksort should use the
     * partition routine you saw in the recitation.
     *
     * @param array
     */
    public void quickSortRecitation(T[] array) {
        quickSortRecitation(array, 0, array.length - 1);
    }

    /**
     * This is the standard, unmodified version of the radix sort which gets as an input the base to be
     * used by the algorithm.
     *
     * @param array
     * @param base
     */
    public static void radixSort(int[] array, int base) {
        int n=findMaxDigit(array,base);
        for (int i=0;i<n;i++)
        {
            countingSortInt(array,i,base);
        }

    }

    /**
     * This function sorts an array using recursive stable merge sort
     *
     * @param array
     */
    public void mergeSortRecursive(T[] array) {
        mergeSortRecursive(array, 0, array.length - 1);
    }

    /**
     * This function sorts an array using non-recursive stable merge sort.
     *
     * @param array
     */
    public void mergeSortIterative(T[] array) {
        int n = array.length;
        int q,r;
        for (int i = 1; i < n; i *= 2)
            for (int j = 0; j< n-1; j += i * 2)
            { q=Math.min(i+j-1,n-1);
                r=Math.min(j + 2 * i-1 ,n-1);
                merge(array, j, q , r );
            }
    }

    /**
     * This function updates the value of a private data member that controls the size of inputs below
     * which a naïve sorting algorithm will be applied (i.e., the base case for all the sorting algorithms
     * supported by the class). This method allows the user to set the threshold size during runtime,
     * offering better flexibility in controlling the sorting behavior.
     *
     * @param threshold
     */
    public void setNaiveSortThreshold(int threshold) {
        this.threshold = threshold;
    }


    /**
     * overloading of quicksort
     *
     * @param array
     * @param p
     * @param r
     */
    private void quickSortClass(T[] array, int p, int r) {
        if (r - p > threshold) {
            int pivot = partitionClass(array, p, r);
            quickSortClass(array, p, pivot - 1);
            quickSortClass(array, pivot + 1, r);
        } else simpleSort(array, p, r);
    }

    /**
     * overloading od quickSortRecitation
     *
     * @param array
     * @param p
     * @param r
     */
    private void quickSortRecitation(T[] array, int p, int r) {
        if (r - p > threshold) {
            int pivot = partitionRecitation(array, p, r);
            quickSortRecitation(array, p, pivot - 1);
            quickSortRecitation(array, pivot + 1, r);
        } else if (p>=r) {
            return;
        } else simpleSort(array,p,r);
    }


    /**
     * sorts like a bubble sort
     *
     * @param array
     * @param p
     * @param r
     */
    private void simpleSort(T[] array, int p, int r) {
        for (int i = 0; i <= r-p; i++) {
            int swap = 0;
            for (int j = p + 1; j <= r - i; j++) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    swap++;
                    swap(array, j - 1, j);
                }
            }
            if (swap == 0)
                return;
        }
    }

    /**
     * A function that sorts an array which is in a max size of 3
     *
     * @param array
     * @param p
     * @param r
     */
    private void simpleSort3(T[] array, int p, int r) {
        if (p == r)
            return;
        if (p + 1 == r) {
            if (array[p].compareTo(array[r]) > 0) {
                T temp = array[p];
                array[p] = array[r];
                array[r] = temp;
                return;
            }
        }
        if (p + 2 == r) {
            if (array[p].compareTo(array[r]) > 0)
                swap(array, p, r);
            if (array[p].compareTo(array[r - 1]) > 0)
                swap(array, p, r - 1);
            else if (array[r - 1].compareTo(array[r]) > 0)
                swap(array, r - 1, r);
        }
    }

    /**
     * help function which returns the index of the pivot for the quick sort like implemented in class.
     *
     * @param array
     * @param p
     * @param r
     * @return
     */
    private int partitionClass(T[] array, int p, int r) {
        T x = array[r];
        int j = r - 1;
        int i = p;
        while (j >= p && i <= r) {
            if (array[i].compareTo(x) > 0 && array[j].compareTo(x) <= 0) {
                if (i < j) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else {
                    T temp = array[j + 1];
                    array[j + 1] = array[r];
                    array[r] = temp;
                    return j + 1;
                }
            } else {
                if (array[j].compareTo(x) > 0)
                    j--;
                else
                    i++;
            }
        }
        if (i > r)
            return r;
        else {
            T temp = array[j + 1];
            array[j + 1] = array[r];
            array[r] = temp;
            return j + 1;
        }


    }


    /**
     * help function which returns the index of the pivot for the quick sort like implemented in the recitation
     *
     * @param array
     * @param p
     * @param r
     * @return the pivot
     */
    private int partitionRecitation(T[] array, int p, int r) {
        T x = array[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (array[j].compareTo(x) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    /**
     * switch the i'th place and the j'th place in the given array
     *
     * @param arr
     * @param i
     * @param j
     */
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * merges two sorted arrays into one sorted array
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private void merge(T[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        T[] L = (T[]) Array.newInstance(Comparable.class, n1);
        T[] R = (T[]) Array.newInstance(Comparable.class, n2);
        int indexL = 0;
        int indexR = 0;
        for (int i = p; i <= q; i++) {
            L[indexL] = arr[i];
            indexL++;
        }
        for (int i = q + 1; i <= r; i++) {
            R[indexR] = arr[i];
            indexR++;
        }
        indexL = 0;
        indexR = 0;
        for (int i = p; i <= r; i++) {
            if (indexR >= n2) {
                arr[i] = L[indexL];
                indexL++;
            } else if (indexL >= n1) {
                arr[i] = R[indexR];
                indexR++;
            } else if (L[indexL].compareTo(R[indexR]) <= 0) {
                arr[i] = L[indexL];
                indexL++;
            } else {
                arr[i] = R[indexR];
                indexR++;
            }
        }
    }

    /**
     * overload of mergesortrecursive
     *
     * @param array
     * @param p
     * @param r
     */
    private void mergeSortRecursive(T[] array, int p, int r) {
        if (r - p > threshold) {
            int q = (p + r) / 2;
            mergeSortRecursive(array, p, q);
            mergeSortRecursive(array, q+1, r);
            merge(array, p, q, r);
        }
        else simpleSort(array, p, r);

    }

    /**sorts the array by the given digit
      * @param arr
     * @param digit
     */
    private static void countingSortInt(int[] arr, int digit, int base) {
        int[] counter = new int[base];
        for (int i = 0; i < arr.length; i++) {
            int x = (int) ((arr[i] / Math.pow(base, digit)) % base);
            counter[x%base]++;
        }
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        int[] clone = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = (int) ((arr[i] / Math.pow(base, digit)) % base);
            clone[counter[x%base]-1] = arr[i];
            counter[x%base]--;
        }
        for (int i = 0; i < arr.length; i++)
            arr[i] = clone[i];
    }

    /**Rerturns the numbers of digits in the largest value in the array;
     * @param arr
     * @return the number of the digits
     */
    private static int findMaxDigit(int[] arr, int base){
        int max=arr[0];
        for (int i=1;i<arr.length;i++)
            if (max<arr[i])
                max=arr[i];
        int count=0;
        while (max>0) {
            count++;
            max/=base;
        }
        return count;
    }
}