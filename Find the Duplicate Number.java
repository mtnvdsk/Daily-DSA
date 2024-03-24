class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                ans=nums[i];
                break;
            }
        }
        return ans;
    }
}