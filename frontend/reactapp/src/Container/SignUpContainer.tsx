import { useState } from 'react';
import SignUpPresenter from '../Presenter/SignUp/SignUpPresenter';
import Axios from 'axios';
import Endpoint from '../config/Endpoint';
import {useHistory} from 'react-router';

export type RequestSignUp = {
  username : string,
  password : string,
  name : string,
  email : string,
  address : string,
}

const SignUpContainer = () => {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const history = useHistory();

  const handleSignUp = (signUpRequest : RequestSignUp) => {
    console.log("하위^^");
    Axios.post(Endpoint.portfolioServer+'/user/signup',
    {
      username : signUpRequest.username,
      password : signUpRequest.password,
      name : signUpRequest.name,
      email : signUpRequest.email,
      address : signUpRequest.address
    })
    .then(response=>response.data)
    .then(data=> {
      if(data.response === "success"){
        alert("회원가입이 완료됐습니다.");
        Axios.post(Endpoint.portfolioServer+'/user/verify', {name : signUpRequest.name})
        history.push("/");
      }
      console.log(data);
    })
    .catch(error=>{
      alert("회원가입이 실패했습니다.");
    })
  };

  return (
    <div>
      <SignUpPresenter
        username = {username}
        password = {password}
        name = {name}
        email = {email}
        address = {address}
        setUsername = {setUsername}
        setPassword = {setPassword}
        setName = {setName}
        setEmail = {setEmail}
        setAddress = {setAddress}
        handleSignUp = {handleSignUp}
      />
    </div>
  )
}

export default SignUpContainer