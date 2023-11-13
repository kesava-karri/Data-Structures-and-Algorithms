// Time Complexity: O(n); Space Complexity: O(1);
function isMonotonic(array) {
	// console.log('array', array);
	let p1 = 0;
	let p2 = 1;
	// listed all the four possibilities
	if (array[p1] - array[p2] >= 0 && array[p2] - array[p2 + 1] >= 0) return isNonIncreasing(array, p1, p2);
	else if (array[p1] - array[p2] <= 0 && array[p2] - array[p2 + 1] <= 0) return isNonDecreasing(array, p1, p2);
	else if ((array[p1] - array[p2] <= 0 && array[p2] - array[p2 + 1] >= 0) || (array[p1] - array[p2] >= 0 && array[p2] - array[p2 + 1] <= 0)) return false;
	else return true;
}

function isNonIncreasing(array, p1, p2) {
	while (p2 < array.length) {
		if (array[p1] > array[p2] || array[p1] === array[p2]) {
			p1++;
			p2++;
		} else if (array[p1] < array[p2]) return false;
	}
	return true;
}

function isNonDecreasing(array, p1, p2) {
	while (p2 < array.length) {
		if (array[p1] < array[p2] || array[p1] === array[p2]) {
			p1++;
			p2++;
		} else if (array[p1] > array[p2]) return false;
	}
	return true;
}

// Another simple way
// Time Complexity: O(n); Space Complexity: O(1);
function isMonotonic(array) {
	console.log('array', array);
	let isNonDecreasing = true;
	let isNonIncreasing = true;
	for (let i = 1; i < array.length; i++) {
		if (array[i-1] > array[i]) isNonDecreasing = false; // Make the other one false
		if (array[i-1] < array[i]) isNonIncreasing = false;
	}

	return isNonDecreasing || isNonIncreasing;
}

console.log(isMonotonic([-1, -5, -10, -1100, -1100, -1101, -1102, -9001]));
// console.log(isMonotonic([1, 2, 0]));
// console.log(isMonotonic([-1, -5, -10, -1100, -900, -1101, -1102, -9001]));