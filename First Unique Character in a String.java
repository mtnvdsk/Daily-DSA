//solution 1

class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        List<Character> vis=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis.contains(s.charAt(i))) continue;
            char temp=s.charAt(i);
            vis.add(temp);
            boolean present=false;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    present=true;
                }
            }
            if(present==false) return i;
        }
        return -1;
    }
}


//solution2


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char a : s.toCharArray()) {
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (mp.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}

//solution3


class Solution {
    public int firstUniqChar(String s) {
        int temp[] = new int [26];
        Queue<Character> val = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            val.add(ch);
            temp[ch-'a']++;
            while(!val.isEmpty() && temp[val.peek()-'a'] >1){
                val.remove();
            }
        }
        return val.isEmpty()?-1 : s.indexOf(val.peek());
    }
}



