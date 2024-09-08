type Fn = (accum: number, curr: number) => number;
// ------------------------------------------------------------------
function reduce(nums: readonly number[], fn: Fn, init: number): number {
  let accumulator: number = init;
  return recursion(accumulator, nums, 0, fn);
}

function recursion(
  accumulator: number,
  nums: readonly number[],
  i: number,
  fn: Fn
): number {
  if (i === nums.length) {
    return accumulator;
  }

  accumulator = fn(accumulator, nums[i]);
  return recursion(accumulator, nums, ++i, fn);
}

// ------------------------------------------------------------------
function reduceIterativeApproach(
  nums: readonly number[],
  fn: Fn,
  init: number
): number {
  let accumulator: number = init;
  for (const element of nums) {
    accumulator = fn(accumulator, element);
  }
  return accumulator;
}
