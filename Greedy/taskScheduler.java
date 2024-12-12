class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count  = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0) + 1);
        }
        int freqCount = 0;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            freqCount = Math.max(e.getValue(),freqCount);
        }
        for(Map.Entry<Character,Integer>e:map.entrySet())
            if(e.getValue()== freqCount) count+=1;
        return (int)Math.max(((freqCount-1)*(n+1))+count,tasks.length);

    }
}