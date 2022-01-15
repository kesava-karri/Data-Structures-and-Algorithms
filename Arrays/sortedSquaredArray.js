// Naive approach (Brute-force)
// Time Complexity: O(nlog(n)); Space Complexity: O(1)
function sortedSquaredArray(array) {
	for (let i = 0; i < array.length; i++) {
		array[i] = (array[i])**2;
	}
	return array.sort((a, b) => a - b);
}

// Using Two pointer approach
// Time Complexity: O(n); Space Complexity: O(n)
function sortedSquaredArray(array) {
	let leastIdx = 0;
	let largestIdx = array.length - 1;
	let newArray = [];

	for (let i = array.length - 1; i >= 0; i--) {
		if (Math.abs(array[leastIdx]) > Math.abs(array[largestIdx])) {
			newArray[i] = array[leastIdx] ** 2;
			leastIdx++;
		} else {
			newArray[i] = array[largestIdx] ** 2;
			largestIdx--;
		}
	}
	return newArray;
}

console.log(sortedSquaredArray([-5,1,3,4]));
