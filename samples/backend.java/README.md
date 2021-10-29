# WEB+DB PRESS Vol.126 第3章 ハンズオン用コード

コードの解説、利用手順は本誌をご覧ください

[WEB+DB PRESS Vol.126](http://xxx.com)



## Backend Sample using SpringBoot/WebFlux

### Config

```bash
ACR_NAME=xxx.azurecr.io
az acr login --name $ACR_NAME
```

### build

```bash
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=$ACR_NAME/backend:v1.0.0
```

### share

```bash
docker image ls
docker push $ACR_NAME/backend:v1.0.0
```

## Next Step

[deploy to AKS](../manifest/)

