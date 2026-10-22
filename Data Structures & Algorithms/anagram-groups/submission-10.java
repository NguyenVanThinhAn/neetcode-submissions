class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] count = new char[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            map.computeIfAbsent(new String(count), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}