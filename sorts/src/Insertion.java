import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] numbers = {3,5,4,1,6,44,23,31};
        int[] newNumbers = insertionSort(numbers);

        System.out.println(Arrays.toString(newNumbers));
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            while ((j > -1) && (array[j] > temp)) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
        return array;
    }

}
