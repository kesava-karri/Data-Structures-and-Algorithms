// Time Complexity: O(n^3); Space Complexity: O(n)
function longestPalindromicSubstring(string) {
	console.log("Given string:", string);
	let longest = '';
	for (let currIdx = 0; currIdx < string.length; currIdx++) {
		for (let cmpIdx = currIdx; cmpIdx < string.length; cmpIdx++) {
			const substring = string.slice(currIdx, cmpIdx + 1); //
			console.log(substring);
			if (substring.length > longest.length && isPalindrome(substring)) {
				longest = substring;
			}
		}
	}
	return longest;
}

function isPalindrome(string) {
	string_length = string.length;
	let start = 0;
	let end = string_length - 1;
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

// Time Complexity: O(n^2); Space Complexity: O(n)
function longestPalindromicSubstring(string) {
	console.log("Given string:", string);
	let currentLongest = [0, 1];
	for (let i = 1; i < string.length; i++) {
		const odd = getLongestPalindromeFrom(string, i - 1, i + 1);
		const even = getLongestPalindromeFrom(string, i - 1, i);
		const longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
		currentLongest = currentLongest[1] - currentLongest[0] > longest [1] - longest[0] ? currentLongest : longest;
	}
	return string.slice(currentLongest[0], currentLongest[1]);
}

function getLongestPalindromeFrom(string, leftIdx, rightIdx) {
	while (leftIdx >= 0 && rightIdx < string.length) {
		if (string[leftIdx] !== string[rightIdx]) break;
		leftIdx--;
		rightIdx++;
	}
	return [leftIdx + 1, rightIdx];
}

console.log(longestPalindromicSubstring("abaxyzzyxf"));
// console.log(longestPalindromicSubstring("abaxyzzyx"));
