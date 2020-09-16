package main

import "fmt"

func main() {
	fmt.Println(factorialIterative(5))
}

func factorialIterative(n int) int {
	if n == 0 || n ==1 {
		return 1
	}
	var a int = 1
	for i := 2; i<=n; i++ {
		a = a*i
	}
	return a
}
