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
