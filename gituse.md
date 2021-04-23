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

在需要获取更新的分支获取其他分支的提交
cherry-pick
```git
   git cherry-pick <commitHash>
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

创建分支：跟随远程分支
```git
    git checkout -b localBranch origin/remoteBranch
```
本地所有修改的。没有的提交的，都返回到原来的状态
```git
git checkout . 
```

只提交单个修改文件中的部分内容
```git
    git add -p[--patch] xx
```

修改上一条commit 作者信息
```git
    git commit --amend --author="John Doe <john@doe.org>"
```


撤销操作
```git
    git add . //添加修改文件
    
    git reset HEAD <file> //撤销暂存文件
    
    git checkout -- <file> //撤销对文件的修改
```

撤销上次commit 
```git
    git reset --soft HEAD^
```


git commit header 描述:

Header 部分只有一行，包括三个字段：type（必需）、scope（可选）和subject（必需）。
    type: 用于说明 commit 的类型。一般有以下几种:
        feat: 新增feature
        fix: 修复bug
        docs: 仅仅修改了文档，如readme.md
        style: 仅仅是对格式进行修改，如逗号、缩进、空格等。不改变代码逻辑。
        refactor: 代码重构，没有新增功能或修复bug
        perf: 优化相关，如提升性能、用户体验等。
        test: 测试用例，包括单元测试、集成测试。
        chore: 改变构建流程、或者增加依赖库、工具等。
        revert: 版本回滚
    scope: 用于说明 commit 影响的范围，比如: views, component, utils, test...
    subject: commit 目的的简短描述