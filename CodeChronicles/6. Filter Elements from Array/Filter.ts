type Fn = (n: number, i: number) => any;

function filter<T>(arr: T[], fn: (n: T, i: number) => unknown): T[] {
  return arr.filter(fn);
}
