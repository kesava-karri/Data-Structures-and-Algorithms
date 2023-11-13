package main

import "fmt"

func isArraySorted(arr []int) bool {
	if len(arr) == 1 {
		return true
	}
	if arr[len(arr) - 1] < arr[len(arr) - 2] {
		return false
	}
	return isArraySorted(arr[:len(arr) - 1])
}

func main() {
	A := []int{1, 2, 1}
	fmt.Println(isArraySorted(A))
	A = []int{10,21,32,43,54}
	fmt.Println(isArraySorted(A))
}
