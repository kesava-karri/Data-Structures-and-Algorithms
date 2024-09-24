type JSONValue =
  | null
  | boolean
  | number
  | string
  | JSONValue[]
  | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>;

function compactObject(obj: Obj): Obj {
  if (Array.isArray(obj)) {
    return obj.filter(Boolean).map((ele) => {
      // This check inlcudes both Array & Object if nested
      if (ele instanceof Object) {
        return compactObject(ele);
      }
      return ele;
    });
  }

  for (const [key, ele] of Object.entries(obj)) {
    if (!ele) {
      delete obj[key];
    } else if (typeof ele === "object" && ele !== null) {
      obj[key] = compactObject(ele);
    }
  }
  return obj;
}
