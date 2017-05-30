package plugin_1

import (
	"fmt"
	"need"
)

type Plugin_1 struct {
}

func init() {
	p_1 := Plugin_1{}
	need.Regist("Plugin_1", p_1)
}

func (this Plugin_1) Flag() bool {
	return true
}

func (this Plugin_1) Start() {
	fmt.Println("I am plugin_1")
}
