type F = (x: number) => number;

function compose(functions: F[]): F {
  return function (x) {
    for (let i = functions.length - 1; i >= 0; i--) {
      x = functions[i](x);
    }
    return x;
  };
}

function composeUsingReduce(functions: F[]): F {
  functions.reverse();
  return function (x) {
    return functions.reduce((x, curr) => curr(x), x);
  };
}

function composeUsingRightReduce(functions: F[]): F {
  return function (x) {
    return functions.reduceRight((x, curr) => curr(x), x);
  };
}

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
