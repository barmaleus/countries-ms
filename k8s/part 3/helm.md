## Helm tips and commands used

Install scoop:
```
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
mkdir scoop
cd scoop
irm get.scoop.sh | iex
```

Install helm:
```
scoop install helm
helm repo add bitnami https://charts.bitnami.com/bitnami
```

Inside of project run command for creating helm template in newly created helm folder:
```
helm create helm
```

Delete all resources because they will be recreated by Helm and will have different properties installed by it:
```
kubectl delete service -n k8s-program countries-service
kubectl delete deployment -n k8s-program countries-service-app
kubectl delete service -n k8s-program postgres-service
kubectl delete service -n k8s-program postgres-statefulset
kubectl delete statefulset -n k8s-program postgres
kubectl delete service -n k8s-program capitals-service  
kubectl delete deployment -n k8s-program capitals-service-app
kubectl delete configmap -n k8s-program countries-configmap 
kubectl delete configmap -n k8s-program capitals-configmap
kubectl delete configmap -n k8s-program postgres-configmap
kubectl delete configmap -n k8s-program sql-configmap
```

Create resources by Helm:
```
helm install countries-app ./helm --namespace=k8s-program
```
Or upgrade already existed release:
```
helm upgrade countries-app ./helm --namespace=k8s-program
```

Upgrade release with external values from values-dev.yaml file:
```
helm upgrade countries-app ./helm -f helm/values-dev.yaml --namespace=k8s-program
```

Get generated manifests in terminal:
```
helm get all countries-app -n k8s-program
```