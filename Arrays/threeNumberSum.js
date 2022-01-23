// Naive Approach
// Time Complexity: O(n^3); Space Complexity: O(n)
function threeNumberSum(array, targetSum) {
  // console.log("array", array);
  array.sort((a, b) => a - b);
  // console.log("sortedArray", array);
  let new2DArray = [];
  let arrayLength = array.length;
  for (let i = 0; i < arrayLength; i++) {
    for (let j = i + 1; j < arrayLength; j++) {
      for (let k = j + 1; k < arrayLength; k++) {
        if (array[k] === targetSum - array[j] - array[i]) {
          new2DArray.push([array[i], array[j], array[k]]);
        }
      }
    }
  }
  return new2DArray;
}

// Optimal, Two pointer approach
// Time Complexity: O(n^2); Space Complexity: O(n)
function threeNumberSum(array, targetSum) {
  // console.log('array', array);
  array.sort((a, b) => a - b);
  let new2DArray = [];
  let arrayLength = array.length;
  // console.log('sortedArray', array);
  for (let i = 0; i < arrayLength; i++) {
    let left = i + 1;
    let right = arrayLength - 1;
    while (left < right) {
      let currentSum = array[i] + array[left] + array[right];
      if (currentSum === targetSum) {
        new2DArray.push([array[i], array[left], array[right]]);
        left++;
        right--;
      } else if (currentSum < targetSum) {
        left++;
      } else {
        right--;
      }
    }
  }
  return new2DArray;
}

console.log(threeNumberSum([12, 3, 1, 2, -6, 5, -8, 6], 0));
