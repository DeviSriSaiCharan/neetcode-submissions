class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<String> strings = new ArrayList<String>(Arrays.asList(strs));

        int n = strings.size();

        for (int i = 0; i < n; i++) {
            List<String> arr = new ArrayList<>();
            arr.add(strings.get(i));
            for (int j = i + 1; j < n; j++) {
                int[] alphabets = new int[32];
                String str1 = strings.get(i);
                int total = 0;

                for (int k = 0; k < str1.length(); k++) {
                    int idx = str1.charAt(k) - 'a';
                    alphabets[idx]++;
                    total++;
                }

                String str2 = strings.get(j);
                if (str1.length() != str2.length()) {
                    continue;
                }
                for (int k = 0; k < str2.length(); k++) {
                    int idx = str2.charAt(k) - 'a';
                    if (alphabets[idx] > 0) {
                        alphabets[idx]--;
                        total--;
                    }
                }

                if(total == 0) {
                    arr.add(str2);
                    strings.remove(j);
                    n--;
                    j--;
                }
            }

            res.add(arr);
        }

        return res;
    }
}
