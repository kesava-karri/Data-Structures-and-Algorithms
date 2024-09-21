type ToBeOrNotToBe = {
  toBe: (val: any) => boolean;
  notToBe: (val: any) => boolean;
};

enum Throw {
  NotEqual = "Not Equal",
  Equal = "Equal",
}

class expectUsingClass {
  constructor(private val: any) {}
  toBe(num: any): boolean {
    return this.val === num || _throw(Throw.NotEqual);
  }
  notToBe(num: any): boolean {
    return this.val !== num || _throw(Throw.Equal);
  }
}
const expect = (val: any) => new expectUsingClass(val);

// ------------------------------------------------
function expectUsingFlag(val: any): ToBeOrNotToBe {
  let flag: boolean = false;
  const toBe = function (num: any): boolean {
    return val === num ? (flag = true) : _throw("Not Equal");
  };
  const notToBe = function (num: any): boolean {
    return val !== num ? (flag = true) : _throw("Equal");
  };
  return { toBe, notToBe };
}

// ------------------------------------------------
function _expect(val: any): ToBeOrNotToBe {
  const toBe = function (num: any): boolean {
    return val === num || _throw("Not Equal");
  };
  const notToBe = function (num: any): boolean {
    return val !== num || _throw("Equal");
  };
  return { toBe, notToBe };
}

function _throw(str: string): boolean {
  throw new Error(str);
}

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */
