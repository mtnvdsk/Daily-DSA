class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l=0,r=tokens.length-1;
        int max=0,s=0;
        while(l<=r){
            if(tokens[l]<=power){
                power-=tokens[l];
                l++;
                s++;
                max=Math.max(max,s);
            }else if(s>0){
                power+=tokens[r];
                r--;
                s--;
            }
            else{
                break;
            }
        }
        return max;
    }
}