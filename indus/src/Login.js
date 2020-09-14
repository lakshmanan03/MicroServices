import React ,{useState} from 'react'
import "./Login.css"
import logo from "./signinlogo.jpeg";
import {Link,useHistory} from "react-router-dom"
import {auth} from "./firebase"

function Login() {
    
    const history=useHistory();

    const [email,setEmail]=useState('');
    const [password,setPassword]=useState('');
    const login= (event)=>
    {
        event.preventDefault();
        
      auth.signInWithEmailAndPassword(email,password).then((auth)=>
      {
          history.push("/");
      }).catch((e)=>alert(e.message));
    };
    const register= (event)=>
    {
        event.preventDefault();
        
      auth.createUserWithEmailAndPassword(email,password).then((auth)=>
      {}).catch((e)=>alert(e.message));
    };
  return (
    <div className="login">
    
           
        
      
      <div className="logincontainer">
      <h1 className="log">indus</h1>
          <form>
          <h5>Email</h5>
          <input  value={email}  onChange={event=>setEmail(event.target.value)}className="logintext" type="text"/>
          <h5>Password</h5>
          <input  value={password} onChange={event=>setPassword(event.target.value)} className="logintext" type="password"/>
          <button className="loginbutton"  onClick={login}>Sign in</button>
           <p><small>Dont have an account? </small></p>
           <button className="registerbutton" onClick={register}>create Account</button>
          </form>
      </div>
    </div>
  )
}

export default Login
