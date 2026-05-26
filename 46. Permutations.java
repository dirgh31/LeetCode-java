class Solution {
    public void helper(int[] nums,
                   List<Integer> temp,
                   List<List<Integer>> ans,
                   boolean[] used){

            // base case 
            if(temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i< nums.length; i++){
            // used elements
            if(used[i]) {
                continue;
            }

            //choose
            used[i] = true;
            temp.add(nums[i]);

            // explore
            helper(nums,temp, ans, used);

            // backtrack
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans =  new ArrayList<>();
        boolean[] used =  new boolean[nums.length];
        helper(nums, new ArrayList<>(), ans, used);
        return ans;
    }
}
