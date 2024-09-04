function map<TIn, TOut>(
  arr: readonly TIn[],
  fn: (n: TIn, i: number) => TOut
): TOut[] {
  // With reduce we are eventually left w one value and here we're expecting it to be our answer, so let's have an empty array as the initialValue, which will be updated in the callback function.
  return arr.reduce((res: TOut[], n, i) => {
    res.push(fn(n, i));
    return res;
  }, []);
}

function mapSol1(
  arr: number[],
  fn: (n: number, i: number) => number
): number[] {
  const res: number[] = [];
  for (const [index, value] of arr.entries()) {
    res.push(fn(value, index));
  }
  return res;
}
