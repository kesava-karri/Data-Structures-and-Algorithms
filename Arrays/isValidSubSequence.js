// Using while loop;
// Time Complexity: O(n); Space Complexity: O(1)
function isValidSubsequence(array, sequence) {
  let arrIdx = 0;
  let seqIdx = 0;
  while (arrIdx < array.length && seqIdx < sequence.length) {
    if (array[arrIdx] === sequence[seqIdx]) {
      seqIdx++;
    }
    arrIdx++;
  }
  return seqIdx === sequence.length;
}

// Using for loop;
// Time Complexity: O(n); Space Complexity: O(1)
function isValidSubsequence(array, sequence) {
	let seqIdx = 0;
	for (let arrIdx = 0; arrIdx < array.length && sequence.length; arrIdx++) {
		if (seqIdx === sequence.length) break;
		if (array[arrIdx] === sequence[seqIdx]) {
			seqIdx++;
		}
	}
	return seqIdx === sequence.length;
}