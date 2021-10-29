package product

import (
	"encoding/json"
	"fmt"
	"math/rand"
	"time"
)

type Item struct {
	ID     int    `json:"id"`
	Name   string `json:"name"`
	Detail string `json:"detail"`
	Price  int    `json:"price"`
}

func NewItem(id int, name string, detail string, price int) *Item {
	return &Item{
		ID:     id,
		Name:   name,
		Detail: detail,
		Price:  price,
	}
}

// 意図的にカオスを挿入しているので、データが正常に帰らないケースもある
func GetItem(items []*Item) string {
	rand.Seed(time.Now().UnixNano())

	i := rand.Intn(9)
	data, err := json.Marshal(items)
	fmt.Println("i =", i)

	if err != nil || i < 5 {
		for {
			time.Sleep(10 * time.Second)
			panic(err)
		}
	}
	fmt.Println(string(data))
	return string(data)
}
