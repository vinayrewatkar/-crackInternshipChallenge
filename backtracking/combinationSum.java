class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, ans, target, candidates, new ArrayList<>());
        return ans;
    }

    public void findCombination(int index, List<List<Integer>> ans, int target, int[] candidates,
            ArrayList<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;
            ds.add(candidates[i]);
            findCombination(i + 1, ans, target - candidates[i], candidates, ds);
            ds.remove(ds.size() - 1);
        }
    }
}