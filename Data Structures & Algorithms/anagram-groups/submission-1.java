class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<String>,Integer> stringMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            ArrayList<String> convertedString = new ArrayList<>(Arrays.asList(strs[i].split("")));
            convertedString.sort(null);

            if(!(stringMap.containsKey(convertedString))){
                stringMap.put(convertedString,result.size());
                List<String> group = new ArrayList<>(Arrays.asList());
                result.add(group);
            }
            int index = stringMap.get(convertedString);
            result.get(index).add(strs[i]);
        }

        return result;
    }   
}