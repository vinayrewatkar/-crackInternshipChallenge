class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int low = Integer.MIN_VALUE;
        int high = 0;
        if (k > arr.length)
            return -1;
        for (int i = 0; i < arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(mid, arr) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int isPossible(int mid, int[] arr) {
        int studentPages = 0;
        int students = 1;
        for (int i = 0; i < arr.length; i++) {
            if (studentPages + arr[i] <= mid) {
                studentPages += arr[i];
            } else {
                students++;
                studentPages = arr[i];
            }
        }
        return students;
    }
}