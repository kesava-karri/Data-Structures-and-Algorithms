// Given an integer array nums, move all 0's to the end of it while 
// maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.
// Example:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(nums) {
	if (nums.length === 1) return ;
	// console.log(nums);
	const numsLength = nums.length;
	let j = 0;
	for (let i = 0; i < numsLength; i++) {
		if (nums[i] !== 0) {
			[nums[i], nums[j]] = [nums[j], nums[i]]; // Swap elements
			j++;
		}
	}
	// console.log(nums);
	return ;
}

moveZeroes([1, 0]);
moveZeroes([0]);
moveZeroes([0,1,0,3,12]); // Output: [1,3,12,0,0]