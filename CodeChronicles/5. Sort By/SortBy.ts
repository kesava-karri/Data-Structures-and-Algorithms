type JSONValue =
  | null
  | boolean
  | number
  | string
  | JSONValue[]
  | { [key: string]: JSONValue };
type Fn = (value: JSONValue) => number;

function sortByLessNumberOfFnCalls<T>(
  arr: readonly T[],
  fn: (t: T) => number
): T[] {
  return arr
    .map((element) => ({ element, sortKey: fn(element) }))
    .sort((a, b) => a.sortKey - b.sortKey)
    .map(({ element }) => element);
}

function sortBy<T>(arr: readonly T[], fn: (t: T) => number): T[] {
  // In API design perspective, either mutate or return but don't do both
  // Example: return arr.sort((a, b) => fn(a) - fn(b));
  // In this example it does both returning as well as mutating
  // So let's return a new array instead of mutating & returning.
  const sortedArr = Array.from(arr);
  sortedArr.sort((a, b) => fn(a) - fn(b));
  return sortedArr;
}
