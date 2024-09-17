type Fn<T> = (item: T) => string;

interface Array<T> {
  groupBy(fn: Fn<T>): Record<string, T[]>;
  groupByUsingReduce(fn: Fn<T>): Record<string, T[]>;
}

Array.prototype.groupBy = function <T>(fn: Fn<T>) {
  let res: Record<string, T[]> = {};
  for (const ele of this) {
    const curr = fn(ele);
    // Nullish Coalescing Assignment Operator
    res[curr] ??= [];
    res[curr].push(ele);
  }
  return res;
};

Array.prototype.groupByUsingReduce = function <T>(fn: Fn<T>) {
  let res: Record<string, T[]> = {};
  this.reduce((accumulator: Record<string, T[]>, ele: T) => {
    const curr = fn(ele);
    // Nullish Coalescing Assignment Operator
    accumulator[curr] ??= [];
    accumulator[curr].push(ele);
    return accumulator;
  }, res);
  return res;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */
