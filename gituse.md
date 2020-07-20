# 常用git 命令


查看某以文件的历史
```git log --pretty=oneline '文件名'```

查看某次提交的更改内容
```git show commit-id ```

拉取线上版本覆盖本地
```git
    git fetch --all
    git reset --hard origin/master
    git pull
```

删除分支
```git 
    git branch -d xx
```

修改分支名称
```git
    git branch -m old-name new-name
```

按提交作者筛选
```git
    git log --author="XX"
```

查看某一文件的修改
```git
    git blame -L startLine:endLine file
    //endLine [realy line number, +/- line number];
```

修改log日期
```git
    git config --global log.date local
```

远程覆盖本地
```git
    git fetch --all
    git reset --hard origin/master 
    git pull 
```