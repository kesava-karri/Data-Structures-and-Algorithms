// Brute-force approach
// Time Complexity: O(n^2); Space Complexity: O(1)
function firstNonRepeatingCharacter(string) {
	console.log("Given string:", string);
	let cmp_element;

	loop1: // label
	for (let i = 0; i < string.length; i++) {
		cmp_element = string[i];
		for (let j = 0; j < string.length; j++) {
			let curr_element = string[j];
			if (cmp_element === curr_element && i!==j) continue loop1;
		}
		return i;
	}
	return -1;
}

// Time Complexity: O(n); Space Complexity: O(1); 'cause only lower case alphabets which are constant in number
function firstNonRepeatingCharacter(string) {
	console.log("Given string:", string);
	let string_obj = {};
	
	for (let i = 0; i < string.length; i++) {
		let curr_element = string[i];
		if (string_obj[curr_element]) string_obj[curr_element] += 1;
		else string_obj[curr_element] = 1;
	}
	console.log("obj:", string_obj);
	for (let i = 0; i < string.length; i++) {
		let curr_element = string[i];
		if (string_obj[curr_element] === 1) return i;
	}
	return -1;
}

console.log(firstNonRepeatingCharacter("abcdcaf"));
console.log(firstNonRepeatingCharacter("aabcdcaf"));
