# WEB+DB PRESS Vol.126 第3章 ハンズオン用コード

コードの解説、利用手順は本誌をご覧ください

[WEB+DB PRESS Vol.126](http://xxx.com)


## AKSクラスタへのアプリケーションデプロイ

AKSクラスタにアプリケーションをデプロイします

### クラスタの作成

azコマンドでAzureにログインします。

```bash
az login
```

次のコマンドでAKSクラスタを作成します。

```bash
RG_NAME=aks-sample
AKS_NAME=aks-sample
az group create -n $RG_NAME -l japaneast

az aks create \
    -g $RG_NAME \
    -n $AKS_NAME \
    --node-count 2 \
    --enable-addons monitoring \
    --generate-ssh-keys
```

AKSクラスタへのアクセスに必要なクレデンシャルを取得し、Nodeの構成情報を確認します。
```bash
az aks get-credentials \
    -g spring-aks  \
    -n aks

az aks install-cli
kubectl get node
```


### バックエンド(Golang版)のデプロイ 

`backend`のデプロイをします。

```bash
cd backend

kubectl apply -f service.yaml 
kubectl apply -f deployment.yaml 
```

### バックエンド(Java版)のデプロイ 


`backend`のデプロイをします。

```bash
cd backend

kubectl apply -f service.yaml 
kubectl create configmap \
    back-configmap \
    --from-file=application.properties
kubectl apply -f deployment.yaml 
```

### フロントエンドのデプロイ 

`frontend`のデプロイをします。

```bash
cd frontend

kubectl apply -f service.yaml 
kubectl  create configmap \
    front-configmap \
    --from-file=application.properties
kubectl  apply -f deployment.yaml 
```

## 動作確認

ロードバランサのIDアドレスを確認します。

```bash
kubectl get svc
```

Webブラウザで以下のURLにアクセスします。


http://`<External IP>`/


Podのログを確認します。

```
kubectl logs -f <pod name>
```

## クリーンアップ

確認が終わったら、次のコマンドでクラスタのリソースグループを削除します。

```bash
az group delete --name $RG_NAME 
```
