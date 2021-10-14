// Log all pairs of the array
const boxes = [1,2,3,4,5];

function logAllPairs(array) {
  for(let i=0; i<array.length; i++) {
    for(let j=0; j<array.length; j++) {
      if(j!==i) {
        console.log(array[i], array[j]);
      }
    }
  }
}

logAllPairs(boxes);

//As both for loops are of same length O(n*n)
//else it would have been O(a*b)