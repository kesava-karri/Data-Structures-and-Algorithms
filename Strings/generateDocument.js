// myTry; 3 tests failed.
// It fails when characters string has an extra element which comes before the starting element after sorting the document;
// Eg: characters: 'k exit'; document: 'exit';
function generateDocument(characters, document) {
  console.log("characters:", characters, "\ndocument:", document);

  const char_obj = {};
  const doc_obj = {};

  for (let i = 0; i < characters.length; i++) {
    let current_element;
    current_element = characters[i];
    if (char_obj[current_element]) {
      char_obj[current_element] += 1;
    } else {
      char_obj[current_element] = 1;
    }
  }

  for (let i = 0; i < document.length; i++) {
    let current_element = document[i];
    if (doc_obj[current_element]) {
      doc_obj[current_element] += 1;
    } else {
      doc_obj[current_element] = 1;
    }
  }
  // console.log('characters:', char_obj, '\ndocument:', doc_obj);

  const a = Object.entries(char_obj).sort().toString();
  const b = Object.entries(doc_obj).sort().toString();
  console.log("char_obj:", a, "\ndoc_obj:", b);
  // console.log(Object.entries(char_obj));
  // console.log("\n", Object.entries(char_obj).sort());
  // console.log("\n", Object.entries(char_obj).sort().toString());

  return a === b || a > b;
}

// Brute-force approach
// Time Complexity: O(n * (n + m)); Space Complexity: O(1); where n is the length of doc string & m is char string length
function generateDocument(characters, document) {
  console.log("characters:", characters, "\ndocument:", document);
  let count_doc = 0;
  let count_char = 0;
  for (let i = 0; i < document.length; i++) {
    // for each element in document string
    for (let j = 0; j < document.length; j++) {
      // to check if same element is present in the document string
      if (document[i] === document[j]) count_doc += 1;
    }

    for (let k = 0; k < characters.length; k++) {
      // to check if same element is present in the characters string
      if (document[i] === characters[k]) count_char += 1;
    }

    if (count_doc > count_char) return false;
    count_doc = 0;
    count_char = 0;
  }
  return true;
}

// Time Complexity: O(k* (n+m)); Space Complexity: O(k)
// Here we start storing the element which we've already processed so we don't repeat it which reduces the time complexity; k is the number of unique elements in document string.
function generateDocument(characters, document) {
  console.log("characters:", characters, "\ndocument:", document);
  let count_doc = 0;
  let count_char = 0;
  let counted_elements = {};

  for (let i = 0; i < document.length; i++) {
    // for each element in document string
    if (document[i] in counted_elements) continue;

    for (let j = 0; j < document.length; j++) {
      // to check if same element is present in the document string
      if (document[i] === document[j]) count_doc += 1;
    }

    for (let k = 0; k < characters.length; k++) {
      // to check if same element is present in the characters string
      if (document[i] === characters[k]) count_char += 1;
    }

    if (count_doc > count_char) return false;
    counted_elements[document[i]] += 1;
    count_doc = 0;
    count_char = 0;
  }
  return true;
}

// Time Complexity: O(n + m); Space Complexity: O(k)
function generateDocument(characters, document) {
  console.log("characters:", characters, "\ndocument:", document);
  const obj = {};
  for (let i = 0; i < characters.length; i++) {
    let curr_element = characters[i];
    if (!(curr_element in obj))
      obj[curr_element] = 1; // if element not present then add it to the object
    else obj[curr_element] += 1; // when it's already present increase the count
  }
  console.log("only characters string:", obj);
  for (let i = 0; i < document.length; i++) {
    let curr_element = document[i];
    if (!(curr_element in obj) || obj[curr_element] === 0) return false; // when count reaches zero or element of document not present in characters then return false
    obj[curr_element] -= 1; // In the same object if it's present decrease the count
  }
  console.log("after removing document from characters", obj);
  return true;
}

// console.log(generateDocument("abcabc", "aabbccc"));
console.log(generateDocument("aheaollabbhb", "hello"));
console.log(generateDocument("aheaolab", "hello"));
