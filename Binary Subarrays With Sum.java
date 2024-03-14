class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        int []arr=new int [nums.length+1];
        int res=0;
        arr[0]=1;
        int c=0;

        for(int i=0;i<nums.length;i++){
            c+=nums[i];
            if(c>=k){
                res+=arr[c-k];
            }
            arr[c]++;
        }
        return res;
    }
}