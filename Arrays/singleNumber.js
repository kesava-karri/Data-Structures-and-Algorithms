// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// Input: nums = [4,1,2,1,2]
// Output: 4

/**
 * @param {number[]} nums
 * @return {number}
*/
var singleNumber = function(nums) {
	let single_num = 0;
	for (let i = 1; i < nums.length + 1; i++) {
		single_num = single_num ^ nums[i-1];
	}
	return single_num;
};

console.log(singleNumber([4,1,2,1,2]));
