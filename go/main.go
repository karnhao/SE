package main

import (
	"errors"
	"fmt"

	"ku.cs/week1/point"
)

var (
	ErrInvalidNumber = errors.New("invalid number")
	ErrUnexpected    = errors.New("unexpected error")
)

func foo(a int, b int64) (int64, int64) {
	return int64(a) + b, int64(a) - b
}

func boo(x int) (int, error) {
	if x < 0 {
		return x, ErrUnexpected
	} else if x != 5 {
		return -1, ErrInvalidNumber
	}

	return x, nil
}

func main() {
	for i := range 5 {
		a, _ := foo(i, int64(i+1))
		fmt.Println(a)
	}

	if x, err := boo(6); err != nil {
	L:
		switch err {
		case ErrInvalidNumber:
			fmt.Println("Number", err)
			break L
		case ErrUnexpected:
			fmt.Println(err)
			break L
		default:
			fmt.Printf("err: %v\n", err)
		}
	} else {
		fmt.Println("No Error", x)
	}

	arr := []int{2, 4, 6}
	arr[2] = 5
	arr = append(arr, 1)
	fmt.Println(arr, len(arr))

	// Pointer

	x := 5

	var xPtr *int = &x
	*xPtr = 2

	fmt.Println(x)

	var point1 *point.Point = point.NewPoint(3, 4)
	var point2 *point.Point = point.NewPoint(0, 0)

	fmt.Println("Distance = ", point.CalculateDistance(point1, point2))

}
