package main.java.medium;

import java.util.*;
import java.util.stream.Collectors;

/*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Example 2:
    Input: strs = [""]
    Output: [[""]]

    Example 3:
    Input: strs = ["a"]
    Output: [["a"]]

    Constraints:
    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
*/

public class _49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> group = resultMap.get(key);
            if(group == null) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                resultMap.put(key, newGroup);
            } else {
                group.add(s);
            }
        }

        List<List<String>> result = new ArrayList<>();
        resultMap.entrySet().forEach(entry -> result.add(entry.getValue()));
        return result;
    }

    public List<List<String>> groupAnagrams_short(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return String.valueOf(chars);
                }))
                .values());
    }
}

/*
    Runtime: 10 ms, faster than 46.58% of Java online submissions for Group Anagrams.
    Memory Usage: 53.5 MB, less than 11.05% of Java online submissions for Group Anagrams.
*/
