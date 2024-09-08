/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */

// Using .reduce()
var filterUsingReduce = function (arr, fn) {
  let i = 0;
  return arr.reduce((res, element, index) => {
    const temp = fn(element, index);
    if (temp) {
      res[i++] = element;
    }
    return res;
  }, []);
};

// It's code smell when we repeatedly call push, map can be used instead
var filterCodeSmell = function (arr, fn) {
  const res = [];
  for (const [i, element] of arr.entries()) {
    if (fn(element, i)) {
      res.push(element);
    }
  }
  return res;
};

var filterUsingBuiltIn = function (arr, fn) {
  return arr.filter(fn);
};
