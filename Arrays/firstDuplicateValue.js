// Time Complexity: O(n); Space Complexity: O(n)
function firstDuplicateValue(array) {
	const obj = {};
	for (let i = 0; i < array.length; i++) {
		if (obj[array[i]] === undefined) {
			obj[array[i]] = true;		
		} else {
			return array[i];
		}
	}
	return -1;
}

// console.log(firstDuplicateValue([2,1,5,2,3,3,4]));
// console.log(firstDuplicateValue([2,1,5,3,3,2,4]));
console.log(firstDuplicateValue([2,1,5,3,4]));
