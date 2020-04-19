# minikube

## 命令

启动minikube集群
```zsh
    sudo minikube start --vm-driver=none --image-mirror-country cn
```

停止minikube集群
```zsh
    sudo minikube stop
```

删除minikube集群
```zsh
    sudo minikube delete
```


启动dashboard
```zsh
    sudo minikube dashboard --url
```

启动外部端口访问
```zsh
    sudo kubectl proxy --address='0.0.0.0' --disable-filter=true
```

删除服务
```zsh
    sudo kubectl delete services xxx
```

删除部署
```zsh
    sudo kubectl delete deployment xxx
```