# service worker

## 生命周期

![sw-life](./img/sw-lifecycle.png)

## 支持事件

![sw-events](./img/sw-events.png)

## 重要事情

![sw-important-notes](./img/sw-important-notes.png)

important:

- service worker 只能抓取在 service worker scope 里从客户端发出的请求。
- 最大的 scope 是 service worker 所在的地址
- 如果你的 service worker 被激活在一个有 Service-Worker-Allowed header 的客户端，你可以为service worker 指定一个最大的 scope 的列表。

## 响应

![fetch](./img/sw-fetch.png)