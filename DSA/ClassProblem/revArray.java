public class revArray {
    public static void rev(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void rev2(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int a = arr[l], b = arr[r];
            a = a + b;
            b = a - b;
            a = a - b;

            // store back into array
            arr[l] = a;
            arr[r] = b;

            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        rev2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
