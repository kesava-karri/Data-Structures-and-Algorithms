// Time Complexity: O(n); Space Complexity: O(n)
function runLengthEncoding(string) {
	console.log("string:", string, "length:", string.length);
	let count = 1; // as I've started the pointer from 2nd element
	let str_encoded = "";
	for (let i = 1; i < string.length + 1; i++) {
		if (string[i-1] !== string[i]) { // when new run starts
			str_encoded += count.toString() + string[i-1]
			count = 1; // reset count
		}
		
		if (string[i-1] === string[i]) { // count the runs
			count += 1;
			if (count > 9) {
				// when the length has double digits, add to the result string & reset.		
				str_encoded += "9" + string[i-1];
				count = 1; // reset count
			}
		}
	}
	return str_encoded;
}

// console.log(runLengthEncoding("AAABB"));
// console.log(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
console.log(runLengthEncoding("........______=========AAAA   AAABBBB   BBB"));
// console.log(runLengthEncoding("AAAAAAAAAAAAAAAAAAAAABBCCCCDD"));
