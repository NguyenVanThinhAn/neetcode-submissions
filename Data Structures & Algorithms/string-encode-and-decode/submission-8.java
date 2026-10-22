class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(int i = 0; i < strs.size(); i++){
            result += strs.get(i).length() + "#" + strs.get(i);
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            int endLength = str.indexOf("#",i);
            int strLength = Integer.parseInt(str.substring(i,endLength));
            if(strLength == 0){
                result.add("");
            }else{
                result.add(str.substring(endLength+1,endLength+1+strLength));
            }
            i = endLength + strLength;
        }
        return result;
    }
}
