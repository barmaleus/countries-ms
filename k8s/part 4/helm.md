Add repo for ingress:
```
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
```

Install/upgrade ingress:
```
helm install countries-ingress ingress-nginx/ingress-nginx -n k8s-program --set controller.replicaCount=2
helm upgrade countries-ingress ingress-nginx/ingress-nginx -n k8s-program --set controller.replicaCount=2
```

Update helm release:
```
 helm upgrade countries-app ./helm -f helm/values-dev.yaml --namespace=k8s-program
```

Check URLs:
```
http://localhost/countries/es
http://localhost/capitals/template/us
```

.../countries/... routes to countries app service
.../capitals/... routes to capitals app service

Return example:
```
{"code":"es","name":"Spain","currency":"Euro","currencySymbol":"€","language":"es-ES","capital":"Madrid","population":"undefined","port":80}
{"code":"us","name":"United States","capital":"Washington","port":80}
```
