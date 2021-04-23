# react-wrap-fn 

 作用： 包裹child 覆盖其方法
 
 重点学习内容 cloneElement
 
```javascript
// warp.js
import React , {useState, useEffect, useRef} from 'react';

const Warp = (props)=>{
  const {children, ...rest} = props
  const [active,setActive] = useState(false)

  const [sonRef,setSonRef] = useState(null)

  useEffect(()=>{
    //console.log('btnref',BtnRef,active);
    if(sonRef){
      if(active){
        sonRef.classList.add('cus')
      }else {
        sonRef.classList.remove('cus')
      }
    }
  },[active,sonRef])

  const handleRef = node=>{
    console.log('ref',node)
    setSonRef(node);
  }

  //const child = React.Children.only(children)
  const child = children;
  //console.log('props',child,child.props);
  const childProps = {
    ...child.props,
    //className:active?'gray '+child.props.className:child.props.className,
    onClick:()=>{
      if(!active){
        child.props.onClick(setActive);
      }
    },
    ref:handleRef
  }

  return React.cloneElement(
    child,
    childProps
  )

}

export default Warp;
```
 
```javascript
import "./styles.css";
import Warp from './Warp';

export default function App() {

  const Trig =(setActive)=>{
    console.log('trigger');
    setActive(true);
    setTimeout(function(){
      setActive()
    },1000);
  }

  const a ='xx';

  return (
    <div className="App">
      <span>cc</span>
      <Warp>
        <span className={a} onClick={Trig}>bbb</span>
      </Warp>
    </div>
  );
}


```