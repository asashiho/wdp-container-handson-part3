package main

import (
	"fmt"
	"io"
	"net"
	"net/http"

	"github.com/asashiho/wdp-container-handson-part3/product"
)

func handle(w http.ResponseWriter, r *http.Request) {
	// Hello関数を呼び出し、結果をレスポンスライターに書き込む
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	io.WriteString(w, product.GetItem(items))
}

var items []*product.Item

func main() {

	// サンプルデータの登録
	items = append(items, product.NewItem(1, "りんご", "甘酸っぱくておいしい", 150))
	items = append(items, product.NewItem(2, "バナナ", "完熟でスムージーにおすすめ", 200))
	items = append(items, product.NewItem(3, "マスカット", "皮も食べられます", 1000))

	// リッスンするポート番号を指定する
	portNumber := "8080"
	addr := ":" + portNumber
	l, err := net.Listen("tcp4", addr)
	if err != nil {
		panic(err)
	}
	fmt.Println("Server listening on port ", portNumber)

	// /itemsへのアクセスでhandle関数を呼び出す
	http.HandleFunc("/items", handle)
	srv := http.Server{}
	srv.Serve(l)
}
