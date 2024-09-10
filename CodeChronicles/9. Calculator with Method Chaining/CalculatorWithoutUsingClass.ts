// Stretch goal: Avoid using the `class` in your code!

function Calc(value: number) {
  this.value = value;
}

Calc.prototype.add = function (value: number) {
  this.value += value;
  return this;
};

Calc.prototype.subtract = function (value: number) {
  this.value -= value;
  return this;
};

Calc.prototype.multiply = function (value: number) {
  this.value *= value;
  return this;
};

Calc.prototype.divide = function (value: number) {
  if (value === 0) {
    throw new Error("Division by zero is not allowed");
  }
  this.value /= value;
  return this;
};

Calc.prototype.power = function (value: number) {
  this.value = Math.pow(this.value, value);
  return this;
};

Calc.prototype.getResult = function () {
  return this.value;
};
