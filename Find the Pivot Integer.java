class Solution {
    public int pivotInteger(int n) {
        int sum=(n)*(n+1)/2;
        int temp=0;
        for(int i=1;i<=n;i++){
            temp+=i;
            if(temp==(sum-temp)+i){
                return i;
            }
        }
        return -1;
    }
}