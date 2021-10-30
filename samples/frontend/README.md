# WEB+DB PRESS Vol.126 第3章 ハンズオン用コード

コードの解説、利用手順は本誌をご覧ください

[WEB+DB PRESS Vol.126](http://xxx.com)


## フロントエンドアプリの開発/共有

ここでは、 SpringBoot/WebFluxで実装したフロントエンドアプリのコンテナイメージを作成します。


環境変数にコンテナレジストリ名を設定します。

```bash
ACR_NAME=xxx.azurecr.io
az acr login --name $ACR_NAME
```

### build

アプリケーションのビルドとイメージの作成を行います。

```bash
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=$ACR_NAME/frontend:v1.0.0
```

### share

コンテナイメージをレジストリで共有します。

```bash
docker image ls $ACR_NAME/frontend:v1.0.0
docker push $ACR_NAME/frontend:v1.0.0
```

## 次のステップ

[AKSクラスタへのデプロイ](../../manifest/README.md)
