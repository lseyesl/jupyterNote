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