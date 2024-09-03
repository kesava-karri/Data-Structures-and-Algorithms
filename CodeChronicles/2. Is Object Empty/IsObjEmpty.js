/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmptyJS = function (obj) {
  // `Object` dataType doesn't have length property
  // Since it's given that given input can be considered as output of JSON.parse
  // Stringifying the given input makes it a `String` which has the length property
  const convertedObj = JSON.stringify(obj);
  // When an empty Object or Array is passed, the stringified output gives the length 2
  // So if the length is 2 then it's an empty otherwise not empty
  return convertedObj.length === 2;
};

// -----------------------------------------------------------------------------
var isEmptyUsingObjEntries = function (obj) {
  // Object.entries() returns an `Array` consisting of Arrays for each key-pair value
  // When empty obj is given, it returns an empty `Array`

  return Object.entries(obj).length === 0;
};

// -----------------------------------------------------------------------------
