# Rollback commands

### See history of deployments (last 10 ones):

```kubectl rollout history deployment/countries-service-app -n k8s-program```

### Revision of deployment:

```kubectl get deployment countries-service-app -o yaml -n k8s-program```


### Revision of replicaset:

```kubectl get replicaset -n k8s-program```

### Rollback deployment to previous version:

```kubectl rollout undo deployment/countries-service-app -n k8s-program```

### Rollback deployment to specific version:

```kubectl rollout undo deployment/countries-service-app --to-revision=28 -n k8s-program```