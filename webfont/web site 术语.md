# web site 术语

- pv page view 页面浏览量  用户每一次对网站中的每个页面访问均被记录1次。用户对同一页面的多次刷新，访问量累计。
- uv unique visitor 独立访客    通过客户端的cookies实现。即同一页面，客户端多次点击只计算一次，访问量不累计。
- ip internet protocol 本意本是指网络协议，在数据统计这块指通过ip的访问量。    即同一页面，客户端使用同一个IP访问多次只计算一次，访问量不累计。
- tps  transactions per second 每秒处理的事务数目。一个事务是指一个客户机向服务器发送请求然后服务器做出反应的过程。客户机在发送请求时开始计时，收到服务器响应后结束计时，以此来计算使用的时间和完成的事务个数，最终利用这些信息作出的评估分。
- qps queries per second 每秒能处理查询数目。是一台服务器每秒能够相应的查询次数，是对一个特定的查询服务器在规定时间内所处理流量多少的衡量标准。
- rps requests per second 每秒能处理的请求数目。等效于QPS
- ops Operates Per Second，一般是操作次数，与qps区别不大。


## 几个概念

- 响应时间(RT) 响应时间是指系统对请求作出响应的时间
- 吞吐量(Throughput)  吞吐量是指系统在单位时间内处理请求的数量
- 并发用户数 并发用户数是指系统可以同时承载的正常使用系统功能的用户的数量。
