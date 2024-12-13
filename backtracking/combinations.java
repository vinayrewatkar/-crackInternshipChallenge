class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        solve(1, k, n, list, new ArrayList<>());
        return list;
    }

    public void solve(int index, int k, int n, List<List<Integer>> list, ArrayList<Integer> arr) {
        if (k == 0) {
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int i = index; i < n; i++) {
            arr.add(i);
            solve(i + 1, k - 1, n, list, arr);
            arr.remove(arr.size() - 1);
        }

    }
}