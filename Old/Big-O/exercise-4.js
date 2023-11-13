// Given 2 arrays, create a function that let's a user know (true/false) whether these two arrays contain any common items

//For Example:
//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'i'];
//should return false.
//-----------
//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'x'];
//should return true.

// 2 parameters - arrays - no size limit
// return true or false

const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'i'];

// Brute force approach
// To pick one element from 1st array & loop through the other array to compare with its elements. 
// Repeating this process for all the elements of the 1st array. This implies we should use nested loops,
// making the time complexity O(a*b).

function containsCommonElements(array1, array2) {
  for (let i = 0; i < array1.length; i++) {
    for (let j = 0; j < array2.length; j++) {
      if(array1[i] === array2[j]) {
        return true
      }
    }
  }
  return false
}
// Time Complexity: O(a*b)
// Space Complexity: O(1)

containsCommonElements(array1, array2);

const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'x'];

// A better approach
// To loop through the first array & create an object with the elements as properties.
// Now looping through the second array & comparing elements with the object we've created.
// As this ain't nested, this makes the time complexity to be O(a + b).

const containsCommonElements2 = (array1, array2) => {
  obj = {};
  for (let i = 0; i < array1.length; i++) {
    obj[array1[i]] = true;
  }
  for (let i = 0; i < array2.length; i++) {
    if (obj[array2[i]]) {
      return true;
    }
  }
  return false
}
// Time Complexity: O(a + b)
// Space Complexity: O(a) ; The obj we created uses the space of the length of first array

containsCommonElements2(array1, array2);

// More readable approach
const containsCommonElements3 = (arr1, arr2) => {
  return arr1.some(item => arr2.includes(item))
}