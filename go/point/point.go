package point

import (
	"fmt"
	"math"
)

type Point struct {
	x int
	y int
}

func NewPoint(x int, y int) *Point {
	return &Point{
		x: x,
		y: y,
	}
}

func Print(p *Point) {
	fmt.Println("(", p.x, ",", p.y, ")")
}

func CalculateDistance(p1 *Point, p2 *Point) float32 {
	return float32(math.Sqrt(math.Pow(float64(p1.x-p2.x), 2) + math.Pow(float64(p1.y-p2.y), 2)))
}
