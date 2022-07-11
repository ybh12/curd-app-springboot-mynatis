package com.travel.form.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class yangbohai {
    public static int[] twoSum(int[] nums, int target) {
        ArrayList numList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            numList.add(nums[i]);
            int j = numList.indexOf(a);
            if(j!=-1 && j !=i){
                return new int[] {i,j};
              }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
//测试合并
    public static void main(String[] args){
        int[] nums = {2,3,7,10};
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println("result:"+ Arrays.toString(result));
    }
}

