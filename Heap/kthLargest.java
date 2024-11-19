class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        for (int i : nums) {
            pq.add(i);
        }
        int count = 0;
        while (count != n - k) {
            pq.poll();
            count++;
        }
        return pq.poll();
    }
}