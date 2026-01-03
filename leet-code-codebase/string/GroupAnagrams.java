class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String , List<String>> map  =new HashMap<>();
         for(String i : strs){
            char[] ch= i.toCharArray();
            Arrays.sort(ch);
            String sortedW = new String(ch);
            if(!map.containsKey(sortedW)){
                map.put(sortedW , new ArrayList<>());
            }
            map.get(sortedW).add(i);
         }
         return new ArrayList<>(map.values());

    }
}