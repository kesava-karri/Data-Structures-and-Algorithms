package main

import "fmt"

func towersOfHanoiMove(n int, from string, to string, temp string) {
	if n == 1 {
		fmt.Println("Disk", n, "moved from stick", from, "to stick", to)
		return
	}
	towersOfHanoiMove(n-1, from, temp, to)
	fmt.Println("Disk", n, "moved from stick", from, "to stick", to)
	towersOfHanoiMove(n-1, temp, to, from)
}

func towersOfHanoi(n int) {
	towersOfHanoiMove(n, "A", "C", "B")
}

func main() {
	towersOfHanoi(5)
}
