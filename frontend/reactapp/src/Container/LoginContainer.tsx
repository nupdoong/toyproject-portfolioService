import * as React from "react";
import { useState } from "react";
import LoginPresenter from "../Presenter/Login/LoginPresenter";
import axios from "axios";
import cookies from "js-cookie";
import Endpoint from "../config/Endpoint";
import { useHistory } from "react-router";

const LoginContainer = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const history = useHistory();

  const doLogin = (username: string, password: string) => {
    console.log(username, password);
    console.log(document.cookie);
    axios
      .post(
        Endpoint.portfolioServer+'/user/login',
        {
          username,
          password,
        },
        { withCredentials: true }
      )
      .then((response) => {
        return response.data;
      })
      .then((data) => {
        if (data.response === "success") {
          alert("로그인 성공");
        }
      })
      .catch((error) => {
        alert("로그인 실패");
        console.error(error);
      });
  };

  const doTest = () => {
    history.push("/signup");
  };

  const signUpByNaver = async (id: string, email: string,name : string, type: string) => {
    const response = await axios.post(
        Endpoint.portfolioServer+'/oauth/signup/naver',
      {
        id,
        email,
        name,
        type,
      },
      { withCredentials: true }
    );
    const data = response.data;
    if (data.response === "success") {
      alert("성공적으로 회원가입이 됐습니다.");
    }else console.log(data);
  };

  return (
    <div>
      <LoginPresenter
        username={username}
        setUsername={setUsername}
        password={password}
        setPassword={setPassword}
        doLogin={doLogin}
        doTest={doTest}
        signUpByNaver={signUpByNaver}
      />
    </div>
  );
};

export default LoginContainer;