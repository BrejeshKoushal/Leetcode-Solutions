package binarysearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[]arr = {4,5,6,7,8,1,2,3};
        System.out.println(search(arr,8 ));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int min = 0;
        int max = n-1;
        while(min<=max){
            int mid = (min+max)/2;
            if(nums[mid]==target) return mid;
            if (nums[mid]>=nums[min]){
                if (nums[min]<=target && nums[mid]>=target) max=mid-1;
                else min=mid+1;
            }
            else{
                if (nums[max]>=target && nums[mid]<=target) min=mid+1;
                else max=mid-1;
            }
        }
        return -1;
    }
}
