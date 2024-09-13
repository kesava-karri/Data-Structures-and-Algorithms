type MultiDimensionalArray = (number | MultiDimensionalArray)[];

var flat = function (
  arr: MultiDimensionalArray,
  n: number
): MultiDimensionalArray {
  return f(arr, n, 0);
};

function f(arr: MultiDimensionalArray, n: number, counter: number) {
  if (counter === n) return arr;
  let res: MultiDimensionalArray = [];

  for (const ele of arr) {
    if (Array.isArray(ele)) {
      res.push(...f(ele, n, counter + 1));
    } else {
      res.push(ele);
    }
  }
  return res;
}
