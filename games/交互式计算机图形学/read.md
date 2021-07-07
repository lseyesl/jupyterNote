# read

我们可以把整个图形系统看作一个状态机(state machine)

## 照相机

- 位置
- 方向
- 焦距
- 胶片平面

```
    lookAt(cop,at,up);
    perspective(fieldOfView,aspectRatio,near,far);
```

## 成像

四个主要步骤
- 顶点处理
- 裁剪和图元组装
- 光栅化
- 片元处理


## webgl

点(gl.POINTS)
线段(gl.LINES)
折线(gl.LINE_STRIP,gl.LINE_LOOP)

三角形(gl.TRIANGLES)
三角形条带和三角形扇(gl.TRIANGLE_STRIP,gl.TRIANGLE_FAN)


## 映射方法

- 纹理映射
- 凹凸映射
- 环境映射
