package printer

import "fmt"

type InkjetPrinter struct {
	Name string
}

// class InkjetPrinter implements Printer
func NewInkjetPrinter(name string) *InkjetPrinter {
	return &InkjetPrinter{
		Name: name,
	}
}

func (i *InkjetPrinter) Print() {
	fmt.Println("Hello")
}
