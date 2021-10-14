function compareTwoBoxes(boxes, boxes2) {
  boxes.forEach((boxes) => { //O(a)
    console.log(boxes);
  });

  boxes2.forEach((boxes) => { //O(b)
    console.log(boxes);
  });
}

//O(a + b)
/*
Cause  the lengths of the arrays (can be any 
other datatype as well) might be different & 
number of operations required would be different,
So it's a good way to assign different terms for
different inputs
*/