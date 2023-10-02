import java.util.Arrays;

public class MaximumSumSubArray {

    public static void main(String[] args)
    {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Arrays.stream(maxSubArray(nums)).forEach(System.out::println);
        // expected result = {4,-1,2,1}
    }

    public static int[] maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return new int[0];

        int sumOfSubArray = Arrays.stream(nums).sum();
        int tempSumOfSubArray = sumOfSubArray;
        int newSumSubArray;
        int startIndex = 0;
        int endIndex = len;
        for (int i=1; i<len; i++)
        {
            newSumSubArray = tempSumOfSubArray - nums[i-1];
            tempSumOfSubArray = newSumSubArray;
            if (newSumSubArray >= sumOfSubArray)
            {
                startIndex = i;
                sumOfSubArray = newSumSubArray;
            }
        }

        tempSumOfSubArray = sumOfSubArray;
        for (int i=len-1; i>startIndex; i--)
        {
            newSumSubArray = tempSumOfSubArray - nums[i];
            tempSumOfSubArray = newSumSubArray;
            if (newSumSubArray > sumOfSubArray)
            {
                endIndex = i;
                sumOfSubArray = newSumSubArray;
            }
        }

        return Arrays.copyOfRange(nums, startIndex, endIndex);
    }
}
