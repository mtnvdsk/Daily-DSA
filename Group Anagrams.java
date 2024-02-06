
//solution1
class Solution {
    public List<List<String>> rec(String[] strs, int[] vis) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length; // Add this line
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            if (vis[i] == -1) {
                temp.add(strs[i]);
                HashMap<Character, Integer> chr = hash(strs[i].toCharArray());
                for (int j = i + 1; j < n; j++) {
                    if (vis[j] == -1 && hash(strs[j].toCharArray()).equals(chr)) {
                        temp.add(strs[j]);
                        vis[j] = 1;
                    }
                }
            }
            if (!temp.isEmpty()) ans.add(temp);
        }
        return ans;
    }

    public HashMap<Character, Integer> hash(char[] a) {
        HashMap<Character, Integer> chr = new HashMap<>();
        for (char c : a) {
            chr.put(c, chr.getOrDefault(c, 0) + 1);
        }
        return chr;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        return rec(strs,vis);
    }
}

//solution2
class Solution {
    public List<List<String>> rec(String[] strs, int[] vis) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            if (vis[i] == -1) {
                temp.add(strs[i]);
                char[] charArray = strs[i].toCharArray();
                Arrays.sort(charArray);
                String s = new String(charArray);

                for (int j = i + 1; j < n; j++) {
                    if (vis[j] == -1) {
                        char[] charArray2 = strs[j].toCharArray();
                        Arrays.sort(charArray2);
                        if (new String(charArray2).equals(s)) {
                            temp.add(strs[j]);
                            vis[j] = 1;
                        }
                    }
                }
            }
            if (!temp.isEmpty()) ans.add(temp);
        }
        return ans;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        return rec(strs,vis);
    }
}

//solution3


class Solution {
    public String getSignature(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
        }

        result.addAll(groups.values());

        return result;
    }
}



//solution 4


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            if (mp.containsKey(sortedStr)) {
                ans.get(mp.get(sortedStr)).add(str);
            } else {
                mp.put(sortedStr, ans.size());
                ans.add(new ArrayList<>(Arrays.asList(str)));
            }
        }

        return ans;
    }
}

