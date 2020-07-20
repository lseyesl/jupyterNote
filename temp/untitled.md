git clone 

```
    git clone [protoc]://[username@]gitaddress/project.git
    
    // userpwd
```

git flow

```
  /*切到主干*/
  git checkout master
  
  /*新开功能分支*/
  git checkout -b myfeature
  
  /*修改更新 提交*/  
  git add .
  git commit -m "message"  //
  
  /*从远端仓库获取更新*/
  git fetch origin
  
  /*变基更新*/
  git rebase origin/master
  
  /*在新功能分支*/
  git rebase -i origin/master
  
```



```
    git rebase 
    while(存在冲突) {
        git status
        找到当前冲突文件，编辑解决冲突
        git add -u
        git rebase --continue
        if( git rebase --abort )
            break; 
    }
```


```

    git rebase //只在自己的分支使用
    
```


```
    /*在当前项目的根目录*/
    git config --local user.name "用户名"
    git config --local user.email "邮箱"
```



## 总结

```git 
    /*获取代码*/
    git clone [protoc]://[username@]gitaddress/project.git
    
    /*进入项目*/
    cd project
    
    /*查看当前信息  不必做 */
    git config [--global|--local] -l //global 全局  local 当前项目 不加则显示所有配置
    
    /*设置用户信息*/
    git config --local user.name "用户名"
    git config --local user.email "邮箱"
    
    
    /*rebase 方式一  废弃*/
    git checkout -b local
    /*在local分支上提交*/
    /*在master上获取更新*/
    git checkout master
    git fetch 
    git merge
    git checkout local
    git rebase master
    git checkout master
    git merge local
    git push origin master
    
    /*rebase 方式二 不创建分支 直接在master上修改*/
    git fetch
    git rebase origin/master
    
    /*
        出现冲突 代码中显示  CONFILCT merge conflict 等等
        M XX file
        
        修改冲突
    */
    git add .
    git rebase --continue
    
    
    /*rebase 完成后*/
    git push origin master
    
    
    
    /* 问题 如果代码没有完成 如何提交？ */
    
    
    
    /*
        vim 常用命令
        
        w 保存
        q 退出
        
        如果没有显示保存或退出，先进入命令模式--> [shift + :] 然后在输入w 或 q
        
        esc键 从编辑模式退回到命令模式；
        
        进入编辑模式 [ a 在光标所在字母后插入，i 在光标所在字母前前插入]
    
    */
    
    
```