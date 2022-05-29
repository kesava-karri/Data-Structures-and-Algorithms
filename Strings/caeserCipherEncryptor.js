// Time Complexity: O(n); Space Complexity: O(n)
function caesarCipherEncryptor(string, key) {
  console.log("string:", string, "\nkey:", key);
  let encryptedString = '';
  const newKey = key % 26; // bringing key within the range of alphabets

  for (let i = 0; i < string.length; i++) {
    // console.log(string[i].charCodeAt());
    let value = string[i].charCodeAt() + newKey;
    if (value >= 123) {
      value = 97 + (value % 123); // 97 is the ascii code for 0 in decimal
      encryptedString += String.fromCharCode(value);
    } else {
      encryptedString += String.fromCharCode(value);
    }
  }
  return encryptedString;
}

console.log(caesarCipherEncryptor("xyz", 2));
