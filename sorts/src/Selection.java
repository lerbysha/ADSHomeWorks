import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] numbers = {3,5,4,1,6,23,51,64};
        int[] newNumbers = selectionSort(numbers);

        System.out.println(Arrays.toString(newNumbers));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int position = -1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    position = j;
                }
                if ((min != array[i])) {
                    array[position] = array[i];
                    array[i] = min;
                }
            }
        }
        return array;
    }
}
