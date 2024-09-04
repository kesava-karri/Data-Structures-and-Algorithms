/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunkJS = function (arr, size) {
  const result = [];
  // iterate over the input arr
  // inner loop -> iterate till size
  // push to result array after inner loop ends
  let i = 0;
  while (i < arr.length) {
    const temp = [];
    for (let j = 0; j < size && i < arr.length; j++) {
      temp.push(arr[i]);
      i++;
    }
    result.push(temp);
  }
  return result;
};
