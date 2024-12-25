class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, result, new ArrayList(), new HashSet<Integer>());
        return result;
    }

    public void solve(int[] nums, List<List<Integer>> result, List<Integer> list, Set<Integer> visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                list.add(nums[i]);
                solve(nums, result, list, visited);
                list.remove(list.size() - 1);
                visited.remove(i);
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
                    i++;
            }

        }
    }
}