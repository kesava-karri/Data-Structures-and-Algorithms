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

twoNumberSum([1,2,3,-1], 3);