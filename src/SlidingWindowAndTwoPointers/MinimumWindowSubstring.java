package SlidingWindowAndTwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        if (t.length()>s.length()) return "";
        int[] freqA = new int[128];
        int[] freqB = new int[128];
        for (char ch : s.toCharArray()){
            freqA[ch-'A']++;
        }
        for (char ch: t.toCharArray()){
            freqB[ch-'A']++;
        }
        if (Arrays.equals(freqA,freqB)) return s;
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int i = 0;
        int j = 0;
        int minLen = 0;
        int startIdx = -1;
        int count = 0;
        while(j<s.length()){
            if (map.containsKey(s.charAt(j))&&map.get(s.charAt(j))>0)  count++;
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)-1);
            while (count==t.length()){
                if (j-i+1 < minLen){
                    minLen=j-i+1;
                    startIdx = i;
                }
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
                if (map.get(s.charAt(i))>0) count--;
                i++;
            }
            j++;
        }
        return startIdx==-1?"":s.substring(startIdx,startIdx+minLen);
    }
}
