interface Array<T> {
  last(): T | -1;
}

Array.prototype.last = function () {
  const lastIndex = this.length - 1;
  return lastIndex < 0 ? -1 : this[lastIndex];
};

Array.prototype.last = function () {
  const lastElement = this.at(-1);
  return lastElement === undefined ? -1 : lastElement;
};

Object.defineProperty(Array.prototype, "last", {
  value: function () {
    const lastIndex = this.length - 1;
    return lastIndex < 0 ? -1 : this[lastIndex];
  },
});

Object.assign(Array.prototype, {
  last() {
    const lastIndex = this.length - 1;
    return lastIndex < 0 ? -1 : this[lastIndex];
  },
});

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
