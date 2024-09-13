type Counter = {
  increment: () => number;
  decrement: () => number;
  reset: () => number;
};

function createCounter(init: number): Counter {
  this.init = init;
  this.number = init;
  let counter: Counter = {
    increment: () => ++this.number,
    decrement: () => --this.number,
    reset: () => {
      this.number = init;
      return this.init;
    },
  };
  return counter;
}

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
