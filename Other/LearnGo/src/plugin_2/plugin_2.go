package plugin_2

import (
	"fmt"
	"need"
)

type Plugin_2 struct {
}

func init() {
	p_2 := Plugin_2{}
	need.Regist("Plugin_2", p_2)
}

func (this Plugin_2) Flag() bool {
	return true
}

func (this Plugin_2) Start() {
	fmt.Println("I am plugin_2")
}
