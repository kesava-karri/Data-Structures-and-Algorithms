package main

import "fmt"

func printBinary(n int, A []int) {
	for i:= 0; i < n; i++ {
		fmt.Print(A[i])
	}
	fmt.Print("\n")
}

func generateBinaryStrings(n int, A []int, i int) {
	if n == i {
		printBinary(n, A)
		return
	}
	A[i] = 0
	generateBinaryStrings(n, A, i+1)
	A[i] = 1
	generateBinaryStrings(n, A, i+1)
}

func main() {
	n := 2
	arr := make([]int, n)
	generateBinaryStrings(n, arr, 0)
}
