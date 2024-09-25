// Using Iterator Protocol - w/o Generator
function fibIteratorProtocol(): Iterator<number> {
  return new Fib();
}

class Fib implements Iterator<number> {
  private first = 0;
  private last = 1;
  next = () => {
    const obj = {
      done: false,
      value: this.first,
    };
    [this.first, this.last] = [this.last, this.first + this.last];
    return obj;
  };
}

// -----------------------------------------------------------
function* fibGenerator(): Generator<number, any, number> {
  yield* f(0, 1);
}

function* f(first: number, last: number): Generator<number, any, number> {
  yield first;
  first = first + last;
  last = first - last;
  yield* f(first, last);
}
// -----------------------------------------------------------
function* _fibGenerator(): Generator<number, any, number> {
  let first = 0,
    last = 1;
  while (true) {
    yield first;
    [first, last] = [last, first + last];
  }
}

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
