# MaximumSumSubArray

# Solution:
- Calculate sum of whole array
- Start a loop from 0 to end of array and keep track of index from where to the end of array the sum is maximum
- Once out of the first loop start another loop. This time remove value from end of the array and keep track of max sum of sub array.
- return the new array where the startIndex is calculated in first loop and endIndex is calculated in second loop.
