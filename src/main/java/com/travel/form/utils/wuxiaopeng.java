package servlets;

import java.util.HashMap;

class A{
    public static void main(String[] args) {
        int[] nums=new int[] {2,7,11,15};
        int[] solution = solution(nums, 9);
        for(int num:solution) {
            System.out.print(num+" ");
        }
    }
    public static int[] solution(int[] nums,int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int index=-1;

        for(int num:nums) {
            int count=map.getOrDefault(num, 0)+1;
            map.put(num, count);
        }


        for(int i=0;i<nums.length;i++) {
            int key=target-nums[i];
            int count=map.getOrDefault(key, 0);
            if(count>0) {
                if(nums[i]==key)
                {
                    if(count<=1) {
                        continue;
                    }
                }

                for(int j=0;j<nums.length;j++) {
                    if(nums[j]==key && i!=j) {
                        index=j;
                        break;
                    }
                }
                return new int[] {i,index};
            }
        }

        return null;
    }


}