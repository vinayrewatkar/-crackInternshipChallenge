import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Use a max-heap to store the k smallest elements
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(matrix[i][j]);
                // If the size exceeds k, remove the largest element
                if (pq.size() > k)
                    pq.poll();
            }
        }

        // The top of the heap will be the kth smallest element
        return pq.peek();
    }
}
