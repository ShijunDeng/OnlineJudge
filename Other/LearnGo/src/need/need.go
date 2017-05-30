package need

import (
	"fmt"
)

var Plugins map[string]Need

func init() {
	Plugins = make(map[string]Need)
}

type Need interface {
	Flag() bool
	Start()
}

func Start() {
	for name, plugin := range Plugins {
		if plugin.Flag() {
			go plugin.Start()
			fmt.Println("start plugin " + name + " .")
		} else {
			fmt.Println("plugin " + name + " occurs unknown error.")
		}
	}
}

func Regist(name string, plugin Need) {
	Plugins[name] = plugin
}
