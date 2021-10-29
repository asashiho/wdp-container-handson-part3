# WEB+DB PRESS Vol.126 第3章 ハンズオン用コード

コードの解説、利用手順は本誌をご覧ください

[WEB+DB PRESS Vol.126](http://xxx.com)

```bash
 .
├──  CREDITS
├──  Dockerfile
├──  go.mod
├──  LICENSE
├──  product
│  ├──  product.go
│  └──  product_test.go
├──  README.md
├──  server
└──  server.go
```


* samples/backend.go
  =>[第2章](https://github.com/ToruMakabe/wdp-container-handson-part2)を参考に作成


## Backend Sample using Golang

### config

```bash
ACR_NAME=xxx.azurecr.io
az acr login --name $ACR_NAME
```

### build

```bash
go build server.go
```

### share

```
docker build -t $ACR_NAME/backend:v1.0.0 .

docker image ls $ACR_NAME/backend:v1.0.0
docker push $ACR_NAME/backend:v1.0.0
```

## Next Step

[deploy to AKS](../manifest/)

