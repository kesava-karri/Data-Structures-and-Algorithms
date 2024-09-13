/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flatJS = Function.prototype.call.bind(Array.prototype.flat);

var flatBuiltIn = function (arr, n) {
  return arr.flat(n);
};
