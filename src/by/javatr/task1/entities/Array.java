package by.javatr.task1.entities;

import by.javatr.exceptions.NullArgumentException;

import java.util.Arrays;

public final class Array {
    private static final int INITIAL_SIZE = 30;
    private int[] array;

    public Array(int[] array) throws NullArgumentException {
        if( array == null ) throw new NullArgumentException( "array couldn't be null" );
        this.array = array;
    }

    public Array(int size) throws NullArgumentException {
        if( size == 0 ) throw new NullArgumentException( "size couldn't be null" );
        this.array = new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] arr) throws NullArgumentException {
        if( arr == null ) throw new NullArgumentException( "array couldn't be null" );
        this.array = arr;
    }

    public int getIndexOf(int key) throws NullArgumentException {
        if( key == 0 ) throw new NullArgumentException( "size couldn't be null" );
        return binarySearch( shellSort(), key );
    }

    public int getMin() {
        int min = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if( array[i - 1] < array[i] ) {
                min = array[i - 1];
            }
        }
        return min;
    }

    public int getMax() {
        int max = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if( array[i - 1] > array[i] ) {
                max = array[i - 1];
            }
        }
        return max;
    }

    public int[] getFibonacci() {
        int[] newArray = new int[INITIAL_SIZE];
        int count = 0;
        int[] fibonachi = ArrayService.getAllFibonacci();
        for (int i = 0; i < INITIAL_SIZE - 1; i++) {
            for (int j = 0; j < INITIAL_SIZE - 1; j++) {
                if( array[i] == array[j] ) {
                    newArray[count++] = array[i];
                    break;
                }
            }
        }
        return newArray;
    }

    public int[] getThreeeDgNumWithNoSameDg() {
        int[] newArray = new int[INITIAL_SIZE];
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if( array[i] > 99 && array[i] < 1000 ) {
                if( (array[i] / 100) != (array[i] / 10) && ((array[i] / 10) != (array[i] % 10))
                        && ((array[i] / 100) != (array[i] % 10)) ) {
                    newArray[count++] = array[i];
                    break;
                }
            }
        }
        return newArray;
    }

    public int[] getAllSimpleNums() {
        int[] simple = new int[INITIAL_SIZE];
        int count = 0;
        boolean key = true;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 2; j < array[i]; j++) {
                if( array[i] % j == 0 ) {
                    key = false;
                    break;
                }
            }
            if( key ) {
                simple[count] = array[i];
                count++;
            }
        }
        return simple;
    }

    public int binarySearch(int[] sortedArray, int key) {
        int index = -1, low = 0, high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if( sortedArray[mid] < key ) {
                low = mid + 1;
            }
            else if( sortedArray[mid] > key ) {
                high = mid - 1;
            }
            else if( sortedArray[mid] == key ) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int[] bubbleSort() {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if( array[j] > array[j + 1] ) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public int[] inseertionSort() {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public int[] shellSort() {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {

                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j - gap];
                array[j] = temp;
            }
        }
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if( o.getClass() != this.getClass() ) return false;
        Array array1 = (Array) o;
        return array == array1.array;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + array.hashCode();
    }

    @Override
    public String toString() {
        return "Array{" +
                "entities=" + Arrays.toString( array ) +
                '}';
    }
}