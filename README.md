# TODO describe project


How to update image in docker hub:
1. Run ```mvn clean install``` for new .jar file generation
2. Build docker image ``` docker build -f docker/Dockerfile -t countries-service . ```
3. Add tag to image ```docker tag countries-service barmaleus/countries-service:1.3.0``` \
Check local images ```docker images```
4. Push image to hub ```docker push barmaleus/countries-service:1.3.0```


### Scale down deployments and statefulsets:

```kubectl scale statefulset postgres -n k8s-program --replicas=0```

```kubectl scale deployment capitals-service-app -n k8s-program --replicas=0```

```kubectl scale deployment countries-service-app -n k8s-program --replicas=0```


### Apply new manifest for kubernetes:
```kubectl apply -f k8s/"part 2"/"task 2"/countries_manifest.yaml```

### Check if liveness works
See pods:
```kubectl get pods```
See if liveness works:
```kubectl describe pod countries-service-app-7999d66758-89q9j -n k8s-program ```



Port forward for db:
```kubectl port-forward postgres-0 5432:5432 -n k8s-program```
Get into db console:
```kubectl exec -it postgres-0 -n k8s-program -- /bin/bash```
Run psql:
```psql -U countriesuser -d countriesdb```
Exit console:
```Ctrl + D```