# help

## ubuntu

### webpack

热更新 
更新观测文件数量，否则无法开启修改编译
```bash
echo fs.inotify.max_user_watches=524288 | sudo tee -a /etc/sysctl.conf && sudo sysctl -p
```


### node-gyp

```
    npm config set python python.exe 路径
    npm config set msbuild_path msbuild_path路径
```

## win10 

### 端口问题

```bash
 #the workaround worked for me, the steps are:

 #Disable hyper-v (which will required a couple of restarts)
 dism.exe /Online /Disable-Feature:Microsoft-Hyper-V

 #When you finish all the required restarts, reserve the port you want so hyper-v doesn't reserve it back
 netsh int ipv4 add excludedportrange protocol=tcp startport=10800 numberofports=1

 #Re-Enable hyper-V (which will require a couple of restart)
 dism.exe /Online /Enable-Feature:Microsoft-Hyper-V /All

 #when your system is back, you will be able to bind to that port successfully.
```