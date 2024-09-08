/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */

var reduceUsingBuiltIn = function (nums, fn, init) {
  return nums.reduce((accumulator, currentValue) => {
    return fn(accumulator, currentValue);
  }, init);
};
