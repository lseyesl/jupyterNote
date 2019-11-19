# react hooks

hooks

## useState

```[key,fn] = useState(initState)```

`key` 是 `state` 里的值

`fn` 是 `state.key` 的更改方法  `fn`的参数是`key` 应该变更的值

`initState` 是 `key` 的初始值

## useEffect

`useEffect` 可以看作 `componentDidMount`,`componentDidUpdate`,`componentWillUnmount`的组合。
针对有副作用的操作。

`useEffect(()=>{
    fn();
    return clear();
},[shoudUpdataKey])` 
`useEffect` 执行函数中，可以返回一个`clear`方法，用于清除副作用操作。`[shoudUpdataKey]`是根据当前值变动来判断是否执行此`useEffect`方法。