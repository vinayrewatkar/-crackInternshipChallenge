import java.util.*;

public class Chocolate {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt(); // Number of test cases
            sc.nextLine(); // Consume newline

            while (T-- > 0) {
                // Read dimensions
                int m = sc.nextInt();
                int n = sc.nextInt();

                // Read horizontal and vertical cut costs
                int[] hor = new int[m - 1];
                for (int i = 0; i < m - 1; i++) {
                    hor[i] = sc.nextInt();
                }

                int[] ver = new int[n - 1];
                for (int i = 0; i < n - 1; i++) {
                    ver[i] = sc.nextInt();
                }

                // Sort both arrays in descending order
                Arrays.sort(hor);
                Arrays.sort(ver);

                // Reverse to get descending order
                reverse(hor);
                reverse(ver);

                int hCount = 1; // Initial horizontal sections
                int vCount = 1; // Initial vertical sections
                int ans = 0;

                // Use two pointers to traverse the sorted arrays
                int hIndex = 0, vIndex = 0;
                while (hIndex < hor.length && vIndex < ver.length) {
                    if (hor[hIndex] >= ver[vIndex]) {
                        ans += hor[hIndex] * vCount;
                        hCount++;
                        hIndex++;
                    } else {
                        ans += ver[vIndex] * hCount;
                        vCount++;
                        vIndex++;
                    }
                }

                // Add remaining horizontal cuts
                while (hIndex < hor.length) {
                    ans += hor[hIndex] * vCount;
                    hIndex++;
                }

                // Add remaining vertical cuts
                while (vIndex < ver.length) {
                    ans += ver[vIndex] * hCount;
                    vIndex++;
                }

                // Output the result
                System.out.println(ans);
            }
        }
    }

    // Helper function to reverse an array
    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
