# readme

## eigen

mac 下安装 *eigen* 到 `/usr/local/Cellar/eigen/3.3.9/include`
cmake file 无法找到 ，所以要手动修改引入路径

```cmake
    include_directories(/usr/local/Cellar/eigen/3.3.9/include)
```