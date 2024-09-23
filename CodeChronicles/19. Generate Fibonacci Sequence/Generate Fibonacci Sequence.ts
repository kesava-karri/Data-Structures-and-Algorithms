// Using Iterator Protocol - w/o Generator
function fibIteratorProtocol(): Iterator<number> {
  return new Fib();
}

class Fib implements Iterator<number> {
  private first = 0;
  private last = 1;
  private res = 0;
  next = () => {
    const obj = {
      done: false,
      value: this.first,
    };
    this.res = this.first + this.last;
    this.first = this.last;
    this.last = this.res;
    return obj;
  };
}

// -----------------------------------------------------------
function* fibGenerator(): Generator<number, any, number> {
  yield 0;
  yield 1;
  yield* f(0, 1);
}

function* f(first: number, last: number): Generator<number, any, number> {
  let res = first + last;
  yield res;
  yield* f(last, res);
}
// -----------------------------------------------------------
function* _fibGenerator(): Generator<number, any, number> {
  let first = 0,
    last = 1,
    res = 0;
  yield first;
  yield last;
  while (true) {
    res = first + last;
    yield res;
    first = last;
    last = res;
  }
}

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
