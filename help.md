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

### wsl

```bash
    netsh interface portproxy add v4tov4 listenport=监听端口 connectaddress=wsl_ip connectport=监听端口 listenaddress=* protocol=tcp
```
如果不用转发了可以执行删除命令
```bash
netsh interface portproxy delete v4tov4 listenport=8080 protocol=tcp
```


## http proxy

由于接口分块传输导致http-proxy-middle无法接收数据
```javascript
onProxyRes(proxyRes, req, res) {
    var chunked = /chunked/.test(
        proxyRes.headers["transfer-encoding"]
    );
    if (chunked) {
        // If chunked, then gather all chunks and pass it on unchunked. Remove transfer-encoding header.
        proxyRes.headers["transfer-encoding"] = "";
        res.write = (function (override) {
            return function (chunk, encoding, callback) {
                override.call(
                    res,
                    chunk,
                    "binary",
                    callback
                );
            };
        })(res.write);
        res.end = (function (override) {
            return function (chunk, encoding, callback) {
                override.call(
                    res,
                    chunk,
                    "binary",
                    callback
                );
            };
        })(res.end);
    }
}

```