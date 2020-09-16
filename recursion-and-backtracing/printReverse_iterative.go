package main

import "fmt"

func main() {
	printReverse(10)
}

func printReverse(n int) {
	if n == 0 {
		fmt.Println(0)
	}

	for i := n; i > 0; i-- {
		fmt.Println(i)
	}
}
