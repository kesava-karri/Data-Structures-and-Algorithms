// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

var removeDuplicates = function(nums) {
		let j = 0;
		nums.forEach(item => {
			if (nums[j] !== item) {
				j++;
				nums[j] = item;
			}
		})
		return j+1;
	};
	
	
	console.log(removeDuplicates([1,1,1,2,3]));