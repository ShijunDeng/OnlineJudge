package need

import (
	"fmt"
)

type Cat struct {
	MaxAge int
}

func (this *Cat) Sleep() {
	fmt.Println("Cat need sleep.")
}

func (this *Cat) Age() int {
	return this.MaxAge
}

func (this *Cat) Type() string {
	return "cat"
}
