# help

## ubuntu

### node 调试

命令行调试

```bash
    node inspect --port=[port] file.js
```

```bash
    node --inspect file.js  //chorme 调试
```

### 查看占用端口

```bash
    lsof -i:port
```

### webpack

热更新 
更新观测文件数量，否则无法开启修改编译
```bash
echo fs.inotify.max_user_watches=524288 | sudo tee -a /etc/sysctl.conf && sudo sysctl -p
```


### node-gyp

```bash
    npm config set python python.exe 路径
    npm config set msbuild_path msbuild_path路径
```

### npm 
当`npm i `出错，又不知道错误在哪里时。

```bash
    npm cache clean --force
```


#### npm link

本地编写npm module时用到

首先在自己编写的npm module项目目录下执行`npm link`,
然后在需要使用module的项目根目录执行 `npm link xxx`(xx)为npm module的名称

删除link的包 在node modudle项目目录下使用`npm unlink`

#### npm list

查看全局npm包 `npm list -g --depth 0`

### proxy

```bash
sudo apt-get install proxychains

edit \etc\proxychains.conf

socks5 win-ip proxy
```

### docker

根据dockerfile生成docker容器
```bash
docker build - < Dockerfile

docker build . # 在Dockerfile文件目录下
```

### k8s

```bash
kubectl get deployments # 获取deploy应用
```

```bash
# 创建systemd 配置
sudo mkdir -p /etc/systemd/system/docker.service.d

/etc/systemd/system/docker.service.d/proxy.conf


#代理
[Service] 
Environment="HTTP_PROXY=http://proxy.example.com:443/"
Environment="HTTPS_PROXY=http://proxy.example.com:443/"

# 更新
sudo systemctl daemon-reload
sudo systemctl restart docker

# 查看是否生效
systemctl show --property=Environment docker
```

### vim

#### NERDTree

目录和文件窗口切换 `ctl w`

切换到目录 `ctl w h`

切换到窗口 `ctl w l`

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

## mac

### chrome 设置跨域

```bash
    open -n /Applications/Google\ Chrome.app/ --args --disable-web-security --user-data-dir=/tmp/chrome_dev_test
```

### mongodb

```bash
    #启动
    mongod --config /usr/local/etc/mongod.conf
    
    ##手动关闭
    mongod admin --eval "db.shutdownServer()"
    
    ##服务启动
    brew services start mongodb-community
    
    ##服务关闭
    brew services stop mongodb-community
```

```bash
    ## 导出数据库
    mongodump  -h  dbhost[远程数据库ip]  -d dbname[要导出数据库名称]  -o  dbDirectory[本地导出目录]
    ## 还原数据库
    mongorestore  -h  dbhost[要导入数据库ip]  -d dbname[要导入数据库名称] dbDirectory[本地备份数据库目录]
    ## 覆盖还原数据库
    mongorestore  -h  dbhost[要导入数据库ip]  -d dbname[要导入数据库名称] dbDirectory[本地备份数据库目录] --drop

```

```bash
    #配置文件位置
    /usr/local/etc/mongod.con
    
    /usr/lcoal/val/log/mongodb
    
    /usr/local/var/mongodb
```

#### ubuntu 下有systemctl

```bash
    sudo systemctl status mongodb

    sudo systemctl stop mongodb	
    
    sudo systemctl start mongodb
    
    sudo systemctl restart mongodb	
    
    sudo systemctl disable mongodb	
    
    sudo systemctl enable mongodb	
    
    
    systemctl daemon-reload
```

#### scp 

```bash
    scp local_file remote_username@remote_ip:remote_folder
    
    scp -r local_folder remote_username@remote_ip:remote_folder 
```

#### nginx

```bash
    nginx -c config
    
    /usr/local/etc/nginx
    
    nginx -s reload
```