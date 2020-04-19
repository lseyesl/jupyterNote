# jupyterhub

## swapfile

```bask
sudo swapon -s

free -m

df -h

sudo dd if=/dev/zero of=/swapfile bs=1G count=4 #看格式化文件 bs=1M

ls -lh /swapfile

sudo chmod 600 /swapfile

sudo mkswap /swapfile

sudo swapon /swapfile

sudo swapon -s

```

## jupyterhub

```bash

pip install git+https://github.com/jupyterhub/jupyterhub.git@master #最新jupyterhub

python3 -m pip install jupyterhub #这个现阶段有问题 2019.11.18
npm install -g configurable-http-proxy
pip install juputerlab

```


### jupyterhub service systemctl

```bash
Unit]
Description=Jupyterhub
After=syslog.target network.target

[Service]
User=root
Environment="PATH=/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/opt/anaconda3/bin"
ExecStart=/usr/local/bin/jupyterhub -f /etc/jupyterhub/jupyterhub_config.py

[Install]
WantedBy=multi-user.target
```

```bash

systemctl daemon-reload
systemctl start jupyterhub

systemctl status jupyterhub

systemctl stop jupyterhub
```

## jupyterlab

```bash
jupyter kernelspec list
```

## nodejs

```bash

#nodejs 问题  权限不足
--unsafe-perm

#或

You can run this as root

npm config set user 0
npm config set unsafe-perm true
```

## java

```bash
sudo apt install default-jre

sudo apt install default-jdk

```

## ubuntu

```bash
    usermod
    useradd
    userdel
```

## latex

中文不显示，可能是字体原因。
查看配置文件中的中文字体在系统中是否存在。

```bash
    fc-list :lang=zh #显示中文字体
    
    apt install fonts-XX #安装字体
    
    fc-cache -f -s -v #字体缓存清理
```
