// A function that reverses a string
// 'Bose Quiet Comfort 45 Headphones' should be:
// 'senohpdaeH 54 trofmoC teiuQ esoB'
function reverse(str) {
  // Check for valid input
  if(!str || str.length < 2 || typeof str !== 'string'){
    return 'InputError, Please check your input'
  }
  const arr = str.split('');
  let result = '';
  const temp = [];
  for(let i = arr.length - 1; i >= 0; i--) {
    temp.push(arr[i]);
  }
  temp.forEach(item => result += item);
  return result
}

console.log(reverse('Bose Quiet Comfort 45 Headphones'));

function reverse2(str) {
  const result = [];
  for(let i = str.length - 1; i >= 0; i--) {
    result.push(str[i]);
  }
  return result.join('');
}

console.log(reverse2('Bose Quiet Comfort 45 Headphones'));