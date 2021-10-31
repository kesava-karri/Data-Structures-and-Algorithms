// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead. [for this just mention return without anything after it]
 */

// 
 var rotate = function(nums, k) {
    const temp = nums.splice(nums.length - k);
    nums.unshift(...temp);
    return nums
  };
  
  console.log(rotate([1,2,3,4,5,6,7], 3));