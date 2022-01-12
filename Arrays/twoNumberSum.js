// Naive approach (Brute-force)
function twoNumberSum(array, targetSum) {
	// console.log('array', array);
	// console.log('targetSum', targetSum);
	const arrayLength = array.length;
	for (i = 0; i < arrayLength; i++) {
		for (j = i+1; j < arrayLength; j++) {
			if (array[i] === targetSum - array[j]) {
				return [array[i], array[j]]
			}
		}
	}
	return [];
}


// Using Hash Table
function twoNumberSum(array, targetSum) {
	let obj = {};
	for (let i = 0; i < array.length; i++) {
		let y = targetSum - array[i];
    
    // Check if element is present in the object
		if (y in obj) {
			return [array[i], y];
		} else {
			obj[array[i]] = true; // Pushing the element to the object with true
		}
	}
	return [];
}

// Using two pointer
function twoNumberSum(array, targetSum) {
	array.sort((a, b) => a - b);

	let leftPointer = 0;
	let rightPointer = array.length - 1;
	// loop until left is less than right
	while(leftPointer < rightPointer) {
		// Decrease the right pointer when the sum is greater than target sum
		if (array[leftPointer] + array[rightPointer] > targetSum) {
			rightPointer--;
		} else if (array[leftPointer] + array[rightPointer] < targetSum) {
			leftPointer++;
		} else {
			return [array[leftPointer], array[rightPointer]];
		}
	}
	return [];
}

twoNumberSum([1,2,3,-1], 3);