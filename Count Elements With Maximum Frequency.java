class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> temp=new HashMap<>();
        for(int i:nums){
            temp.put(i,temp.getOrDefault(i,0)+1);
        }
        int max=0;
        for(Map.Entry<Integer,Integer> i:temp.entrySet()){
            max=Math.max(max,i.getValue());
        }
        int c=0;
        for(Map.Entry<Integer,Integer> i:temp.entrySet()){
            if(i.getValue()==max){
                c+=i.getValue();
            }
        }
        return c;
    }
}