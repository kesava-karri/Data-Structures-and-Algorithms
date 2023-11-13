function boooo(n) {
  for (let i = 0; i < n.length; i++) {
    console.log('booooooo');
  }
}

boooo([1,2,3,4,5]) 
//Space Complexity: O(1) ; As we only used memory while 
//assigning variable i

function sayHiNTimes(n) {
  let hiArray = [];
  for (let i = 0; i < n; i++) {
    hiArray[i] = 'hi';
  }
  return hiArray;
}

console.log(sayHiNTimes(6)); 
//Space Complexity: O(n); Following the rules, 
//ignoring constant time we get O(n)