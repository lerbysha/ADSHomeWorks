import java.util.Arrays;

public class bubble {


    public static void main(String[] args) {
        int[] numbers = {3, 5, 4, 1, 6, 23, 51, 64};
        int[] newNumbers = bubbleSort(numbers);
        System.out.println(Arrays.toString(newNumbers));
    }

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }

        return arr;
    }
}
