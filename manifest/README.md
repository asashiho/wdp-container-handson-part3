# WEB+DB PRESS Vol.126 第3章 ハンズオン用コード

コードの解説、利用手順は本誌をご覧ください

[WEB+DB PRESS Vol.126](http://xxx.com)

フォルダ構成

```bash
 .
├──  backend
│  ├──  application.properties
│  ├──  deployment.yaml
│  └──  service.yaml
├──  frontend
│  ├──  application.properties
│  ├──  deployment.yaml
│  └──  service.yaml
└──  README.md
```

## Deply to AKS Cluster

### config
```bash
az login
az aks get-credentials \
    -g spring-aks  \
    -n aks

kubectl get node
```

### backend using Go

```bash
cd backend

kubectl apply -f service.yaml 
kubectl apply -f deployment.yaml 
```

### backend using Java

```bash
cd backend

kubectl apply -f service.yaml 
kubectl create configmap \
    back-configmap \
    --from-file=application.properties
kubectl apply -f deployment.yaml 
```

### frontend

```bash
cd frontend

kubectl apply -f service.yaml 
kubectl  create configmap \
    front-configmap \
    --from-file=application.properties
kubectl  apply -f deployment.yaml 
```

## Check

```bash
kubectl get svc
```

acccess using web browser

http://`<External IP>`/


```
kubectl logs -f <pod name>
```

## Next Step

[delete AKS Cluster](../xxx/)

