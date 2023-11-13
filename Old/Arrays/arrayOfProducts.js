// Brute-force Approach
// Time Complexity: O(n^2); Space Complexity: O(n)
function arrayOfProducts(array) {
	let resultArray = [];
	const arrayLength = array.length;
	for (let i = 0; i < arrayLength; i++) {
		let temp = 1;
		for (let j = 0; j < arrayLength; j++) {
			if (i !== j) {
				temp = temp * array[j];
			}
		}
		resultArray.push(temp);
	}
	return resultArray;
}

console.log(arrayOfProducts([5,1,4,2]));
