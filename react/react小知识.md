# 小知识

## react提示 this synthetc event is resued for performance reasons. if you're seeing this, you're accessing the property `target` on a released/nullified synthetic event. this is set to null.

出于性能原因，将重用此合成事件。如果你看到这一点，那么您正在访问已释放/取消的合成事件的属性`target`. 设置为空。如果必须保留原始合成事件，请使用`event.persist()`.
参考[https://fb.me/react-event-pooling](https://fb.me/react-event-pooling);

```javascript react
    //出现这个问题 主要是因为在异步方法里调用了合成事件的引用。
    eventHandle(e){
        e.persist();
        this.setState(state=>({
            value:e.target.value
        }))
    }
```

## react 17 不再使用`Event Pooling`

The SyntheticEvent objects are pooled. This means that the SyntheticEvent object will be reused and all properties will be nullified after the event handler has been called.