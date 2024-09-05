/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortByJS = function (arr, fn) {
  return arr.sort((a, b) => fn(a) - fn(b));
};
