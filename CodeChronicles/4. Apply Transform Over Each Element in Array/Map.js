/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */

var mapJS = function (arr, fn) {
  const res = [];
  for (const [index, value] of arr.entries()) {
    res.push(fn(value, index));
  }
  return res;
};
