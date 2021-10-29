# WEB+DB PRESS Vol.126 第3章 ハンズオン用コード

コードの解説、利用手順は本誌をご覧ください

[WEB+DB PRESS Vol.126](http://xxx.com)


## Backend Sample using SpringBoot/WebFlux

### config

```bash
ACR_NAME=xxx.azurecr.io
az acr login --name $ACR_NAME
```

### build

```bash
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=$ACR_NAME/frontend:v1.0.0
```

### share

```bash
docker image ls $ACR_NAME/frontend:v1.0.0
docker push $ACR_NAME/frontend:v1.0.0
```

chenge source=>

```bash
mvn clean
./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=$ACR_NAME/frontend:v2.0.0
```

```bash
docker image ls $ACR_NAME/frontend:v2.0.0
docker push $ACR_NAME/frontend:v2.0.0
```

## Next Step

[deploy to AKS](../manifest/)

