class Pair {
    char c;
    int freq;

    Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}

class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char car = entry.getKey();
            int freq = entry.getValue();
            pq.add(new Pair(car, freq));
        }
        StringBuilder ans = new StringBuilder();
        while (pq.size() > 1) {
            Pair p = pq.poll();
            Pair q = pq.poll();
            ans.append(p.c);
            ans.append(q.c);
            if (p.freq > 1) {
                pq.add(new Pair(p.c, p.freq - 1));
            }
            if (q.freq > 1) {
                pq.add(new Pair(q.c, q.freq - 1));
            }
        }

        if (!pq.isEmpty()) {
            Pair last = pq.poll();
            if (last.freq > 1) {
                return "";
            }
            ans.append(last.c);
        }

        return ans.toString();
    }
}