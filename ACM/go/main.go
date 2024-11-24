package main

import (
	"fmt"
)

func main() {
	fmt.Println("Hello, World!")
}

func uniquePaths(m int, n int) int {
	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)

	}
}
