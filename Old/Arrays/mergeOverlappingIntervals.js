// Time Complexity: O(nlog(n)); Space Complexity: O(n)
function mergeOverlappingIntervals(array) {
	array.sort((a, b) => a[0] - b[0]);
	
	const newArr = [];
	currentInterval = array[0];
	newArr.push(currentInterval);

	for (const nextInterval of array) {
		let [currentIntervalStart, currentIntervalEnd] = currentInterval;
		let [nextIntervalStart, nextIntervalEnd] = nextInterval;
		
		if (currentIntervalEnd >= nextIntervalStart) {
			currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
		} else {
			currentInterval = nextInterval;
			newArr.push(currentInterval);
		}
	}
	return newArr;
}
console.log(mergeOverlappingIntervals([[1,2], [3,5], [4,7], [6,8], [9,10]]));
