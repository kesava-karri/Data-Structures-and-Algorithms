class MyArray {
  constructor() {
    this.length = 0;
    this.data = {};
  }

  get(index) {
    return this.data[index];
  }

  push(item) {
    this.data[this.length] = item;
    this.length++;
    return this.length;
  }

  pop() {
    const item = this.data[this.length - 1];
    delete this.data[this.length - 1];
    this.length--;
    return item;
  }

  deleteAtIndex(index) {
    const item = this.data[index];
    this.shiftingItems(index);
    return item;
  }

  shiftingItems(index) {
    for (let i = index; i < this.length - 1; i++) {
      this.data[i] = this.data[i + 1];
    }
    delete this.data[this.length - 1];
    this.length--;
  }
}

const newArray = new MyArray();
newArray.push('Martin Garrix');
newArray.push('EDM');
console.log(newArray.get(0));
newArray.push('So Far Away');
console.log(newArray);
newArray.pop();
console.log(newArray);
newArray.push('Scared to be lonely');
newArray.push('There for you');
console.log(newArray);
newArray.deleteAtIndex(1);
console.log(newArray);
