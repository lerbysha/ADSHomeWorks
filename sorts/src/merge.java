import java.util.Arrays;

public class merge {public static void main (String[] args) {
    int[] numbers = {4,7,3,6,-2,6,1,2};
    int[] newNumbers = mergeSort(numbers);
    System.out.print(Arrays.toString(newNumbers)) ;
}

    public static int[] mergeSort(int[] array) {
        int size = array.length;
        if (size < 2) return array;
        int middle = size / 2;
        return mergeSortHelper(mergeSort(Arrays.copyOfRange(array, 0, middle)), mergeSort(Arrays.copyOfRange(array, middle, size)));
    }

    public static int[] mergeSortHelper(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int a = 0;
        int b = 0;
        int sumSize = size1 + size2;
        int[] result = new int[sumSize];
        for (int i = 0; i < sumSize; i++) {
            if (b < size2 && a < size1) {
                if (array1[a] > array2[b]) result[i] = array2[b++];
                else result[i] = array1[a++];
            } else if (b < size2) {
                result[i] = array2[b++];
            } else {
                result[i] = array1[a++];
            }
        }
        return result;
    }
}
