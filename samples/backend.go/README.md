# WEB+DB PRESS Vol.126 第3章 ハンズオン用コード

コードの解説、利用手順は本誌をご覧ください

[WEB+DB PRESS Vol.126](http://xxx.com)


* samples/backend.go
  =>[第2章](https://github.com/ToruMakabe/wdp-container-handson-part2)を参考に作成


## バックエンドアプリ(Go)の開発/共有

ここでは、Goで実装したバックエンドAPIのコンテナイメージを作成します。

環境変数にコンテナレジストリ名を設定します。

```bash
ACR_NAME=xxx.azurecr.io
az acr login --name $ACR_NAME
```

### build

アプリケーションのビルドを行います。
```bash
go build server.go
```

### share

コンテナイメージを作成し、レジストリで共有します。

```
docker build -t $ACR_NAME/backend:v1.0.0 .

docker image ls $ACR_NAME/backend:v1.0.0
docker push $ACR_NAME/backend:v1.0.0
```

## 次のステップ

[AKSクラスタへのデプロイ](../../manifest/README.md)

