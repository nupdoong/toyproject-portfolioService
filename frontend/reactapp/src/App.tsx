import React, {Component} from "react";
import logo from './logo.svg';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import {MainPage, LoginPage, SignUpPage, SocialLoginingPage, MyPortfolioPage} from "./Container";
import StockPresenter from "./Container/StockPresenter";

function App() {
  return (
    <div className="App">
      
      <Router>
        <Route path="/" exact component={LoginPage}/>
        <Route path="/signup" component={SignUpPage}/>
        <Route path="/main" exact component={MainPage}/>
        <Route path="/login/oauth" component={SocialLoginingPage}/>
        <Route path="/myportfolio" component={MyPortfolioPage}/>
        <Route path="/stock" component={StockPresenter}/>
      </Router>
      
    </div>
  );
}

export default App;