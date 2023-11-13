// Optimal, Two pointer approach
// Time Complexity: O(alog(a)) + O(blog(b)); Space Complexity: O(1)
function smallestDifference(arrayOne, arrayTwo) {
  // console.log("arrayOne", arrayOne, "\narrayTwo", arrayTwo);
  arrayOne.sort((a, b) => a - b);
  arrayTwo.sort((a, b) => a - b);
  // console.log("arrayOneSorted", arrayOne, "\narrayTwoSorted", arrayTwo);
  let idxOne = 0;
  let idxTwo = 0;
  let leastDiff = Infinity;
  let currentDiff = Infinity;
  let smallestPair = [];

  while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
    let firstNum = arrayOne[idxOne];
    let secondNum = arrayTwo[idxTwo];
    if (firstNum < secondNum) {
      idxOne++;
      currentDiff = secondNum - firstNum;
    } else if (firstNum > secondNum) {
      idxTwo++;
      currentDiff = firstNum - secondNum;
    } else if (firstNum === secondNum) {
      return [firstNum, secondNum];
    }
    if (currentDiff < leastDiff) {
      leastDiff = currentDiff;
      smallestPair = [firstNum, secondNum];
    }
  }
  return smallestPair;
}

console.log(smallestDifference([-1, 5, 10, 20, 28, 3], [26, 134, 135, 15, 17]));
