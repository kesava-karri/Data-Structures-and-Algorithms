/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLengthJS = function (...args) {
  return args.length;
};

function argumentsLengthOmitRestOperator() {
  return arguments.length;
}

/**
 * argumentsLength(1, 2, 3); // 3
 */
