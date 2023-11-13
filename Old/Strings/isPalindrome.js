// Time Complexity: O(n); Space Complexity: O(1)
function isPalindrome(string) {
	// console.log(string);
	string_length = string.length;
	let start = 0;
	let end = string_length - 1;
	// if (string_length % 2 !== 0) { // odd string length
	for (let i = 0; i < Math.ceil(string_length / 2); i++) {
		if (string[start] !== string[end]) {
			return false;
		} else if (string[start] === string[end]) {
			start += 1;
			end -= 1;
		}
	}
	return true;
}

console.log("abcdcba", isPalindrome("abcdcba"));
console.log("abcddcbaa", isPalindrome("abcddcbaa"));
console.log("abcdcbb", isPalindrome("abcdcbb"));
