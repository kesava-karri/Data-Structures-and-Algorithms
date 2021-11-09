// Given two integer arrays nums1 and nums2, return an
// array of their intersection. Each element in the result 
// must appear as many times as it shows in both arrays and 
// you may return the result in any order.

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
*/
var intersect = function(nums1, nums2) {
  nums1.sort((a,b) => a-b);
  nums2.sort((a,b) => a-b);
  let i = 0;
  let j = 0;
  let arrayIntersection = new Array();
  while (i < nums1.length && j < nums2.length) {
    if (nums1[i] < nums2[j]) i++;
    else if (nums1[i] > nums2[j]) j++;
    else {
      arrayIntersection.push(nums1[i]);
      i++;
      j++;
    }
  }
  return arrayIntersection;
};
  
console.log(intersect([9,4,9,8,4], [4,9,5]));
  