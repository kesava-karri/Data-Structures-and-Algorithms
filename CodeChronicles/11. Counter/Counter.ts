function createCounter(n: number): () => number {
  const gen = generator(n);
  return function () {
    return gen.next().value;
  };
}

function* generator(n: number): Generator<number, number, void> {
  while (true) {
    yield n++;
  }
}
/**
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
