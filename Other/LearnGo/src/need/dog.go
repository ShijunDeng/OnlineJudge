package need

import (
	"fmt"
)

type Dog struct {
	MaxAge int
}

func (this *Dog) Sleep() {
	fmt.Println("Dog need sleep.")
}

func (this *Dog) Age() int {
	return this.MaxAge
}

func (this *Dog) Type() string {
	return "dog"
}
