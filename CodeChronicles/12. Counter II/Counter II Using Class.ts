type Counter = {
  increment: () => number;
  decrement: () => number;
  reset: () => number;
};

class createCounterr {
  num: number;
  constructor(private init: number) {
    this.num = this.init;
  }
  reset = () => {
    this.num = this.init;
    return this.init;
  };
  increment = () => ++this.num;
  decrement = () => --this.num;
}

function createCounter(init: number) {
  return new createCounterr(init);
}

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
