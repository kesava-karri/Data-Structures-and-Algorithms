type JSONValue =
  | null
  | boolean
  | number
  | string
  | JSONValue[]
  | { [key: string]: JSONValue };
type ArrayType = { id: number } & Record<string, JSONValue>;

function join(arr1: ArrayType[], arr2: ArrayType[]): ArrayType[] {
  const res = {};
  for (const ele of [arr1, arr2]) {
    for (const obj of ele) {
      const temp = res[obj["id"]];
      res[obj["id"]] = temp ? { ...temp, ...obj } : obj;
    }
  }
  return Object.values(res);
}
