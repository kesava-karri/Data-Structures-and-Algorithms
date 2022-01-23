// Optimal, Two pointer approach
// Time Complexity: O(n); Space Complexity: O(1)
function moveElementToEnd(array, toMove) {
  console.log("array", array);
  let left = 0;
  let right = array.length - 1;
  while (left < right) {
    while (left < right && array[right] === toMove) right--;
    if (array[left] === toMove) {
      // Swap left num with right
      let temp = array[right];
      array[right] = array[left];
      array[left] = temp;
    }
    left++;
  }
  return array;
}

console.log(moveElementToEnd([2, 1, 2, 2, 2, 3, 4, 2], 2));
