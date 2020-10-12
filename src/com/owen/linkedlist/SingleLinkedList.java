package com.owen.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleLinkedList {

    public static void main(String[] args) {
        int[] array = new int[] { 5, 12, 6, 3, 9, 2, 1, 7 };
        int sum = 13;

        System.out.println(twoSumV2(array, sum));

    }

    public static ArrayList<ArrayList<Integer>> twoSum(int[] array, int sum) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < array.length; i++) {
            numMap.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            if (numMap.containsKey(sum - array[i])) {
                ArrayList<Integer> matchIndexList = new ArrayList<>(2);
                matchIndexList.add(i);
                matchIndexList.add(numMap.get(sum - array[i]));
                numMap.remove(array[i]);
                resultList.add(matchIndexList);
            }
        }

        return resultList;
    }

    public static List<List<Integer>> twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                resultList.add(Arrays.asList(map.get(other), i));
            }
            map.put(nums[i], i);
        }
        return resultList;
    }

}
