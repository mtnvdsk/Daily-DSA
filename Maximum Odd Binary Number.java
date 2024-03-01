class Solution {
    public String maximumOddBinaryNumber(String s) {
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') c++;
        }
        int zeros=s.length()-c;
        String str="";
        for(int i=0;i<c-1;i++){
            str+="1";
        }
        while(zeros>0){
            str+="0";
            zeros--;
        }
        str+="1";
        return str;
    }
}