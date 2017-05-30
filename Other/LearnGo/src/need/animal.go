package need

type Animal interface {
	Sleep()
	Age() int
	Type() string
}
func Factory(name string) Animal {
	switch name {
	case "dog":
		return &Dog{MaxAge: 20}
	case "cat":
		return &Cat{MaxAge: 10}
	default:
		panic("No such animal")
	}
}