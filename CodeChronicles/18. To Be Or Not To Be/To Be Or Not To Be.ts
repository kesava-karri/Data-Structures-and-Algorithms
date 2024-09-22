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
  toBe(ele: any): boolean {
    return this.val === ele || _throw(Throw.NotEqual);
  }
  notToBe(ele: any): boolean {
    return this.val !== ele || _throw(Throw.Equal);
  }
}
const expect = (val: any) => new expectUsingClass(val);

// ------------------------------------------------
function expectUsingFlag(val: any): ToBeOrNotToBe {
  const toBe = (ele: any): boolean => callThis(ele, false);
  const notToBe = (ele: any): boolean => callThis(ele, true);
  const callThis = (ele: any, flag: boolean): boolean => {
    if (flag === (val === ele)) {
      flag ? _throw(Throw.Equal) : _throw(Throw.NotEqual);
    }
    return true;
  };
  return { toBe, notToBe };
}

// ------------------------------------------------
function _expect(val: any): ToBeOrNotToBe {
  const toBe = function (ele: any): boolean {
    return val === ele || _throw("Not Equal");
  };
  const notToBe = function (ele: any): boolean {
    return val !== ele || _throw("Equal");
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
