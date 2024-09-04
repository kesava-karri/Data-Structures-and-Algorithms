type JSONValue =
  | null
  | boolean
  | number
  | string
  | JSONValue[]
  | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

/** Generics {@link https://www.typescriptlang.org/docs/handbook/2/generics.html#handbook-content} */
function chunk<T>(arr: readonly T[], size: number): T[][] {
  const result: T[][] = [];
  let temp: T[] = [];

  for (const [index, value] of arr.entries()) {
    temp.push(value);

    if (temp.length === size || index === arr.length - 1) {
      // The 2nd condition is to push the leftover chunk when the last chunk of array exceeds the actual array size & there's no other elements present in arr
      result.push(temp);
      temp = [];
    }
  }
  return result;
}

function chunkBruteForce(arr: Obj[], size: number): Obj[][] {
  const result: Obj[][] = [];
  let i = 0;
  while (i < arr.length) {
    const temp: Obj[] = [];
    for (let j = 0; j < size && i < arr.length; j++) {
      temp.push(arr[i]);
      i++;
    }
    result.push(temp);
  }
  return result;
}
