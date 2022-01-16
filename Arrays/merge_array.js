// mergeSortedArrays([0,3,4,31], [4,6,30]);
// [0,3,4,31], [4,6,30] should be converted to:
// [0, 3, 4, 4, 6, 30, 31]

const mergeSortedArrays = (array1, array2) => {
  // Check input
  if (!array1.length) return array2; // When array1 is empty, return array2
  if (!array2.length) return array1; // When array2 is empty, return array1

  let mergedArray = [];
  let i = 0;
  let j = 0;
  let array1Item = array1[0];
  let array2Item = array2[0];

  while (array1Item || array2Item) {
    if (array2Item === undefined || array1Item < array2Item) {
      // When array2Item crosses the array2 it becomes undefined so !undefined is true.
      mergedArray.push(array1Item);
      i++;
      array1Item = array1[i];
    } else {
      mergedArray.push(array2Item);
      j++;
      array2Item = array2[j];
    }
  }
  return mergedArray;
};

console.log(mergeSortedArrays([0, 3, 4, 31], [4, 6, 30]));
