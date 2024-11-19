
class Pair {
    int key, value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().key;
        }

        return ans;
    }
}
