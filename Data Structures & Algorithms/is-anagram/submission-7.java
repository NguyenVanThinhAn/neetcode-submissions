class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> charMap = new HashMap<>();
        HashMap<Character,Integer> charMapT = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            charMap.put(s.charAt(i),charMap.getOrDefault(s.charAt(i),0) + 1);
            charMapT.put(t.charAt(i),charMapT.getOrDefault(t.charAt(i),0) + 1);
        }
        return charMap.equals(charMapT);
    }
}

// racecar carrace

// carrace