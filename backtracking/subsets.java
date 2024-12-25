class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, result, new ArrayList<>());
        return result;
    }

    public void solve(int index, int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        solve(index + 1, nums, result, list);
        list.remove(list.size() - 1);
        solve(index + 1, nums, result, list);
    }
}