import * as React from "react";
import logo from './logo.svg';
import {Link, Route, BrowserRouter as Router} from "react-router-dom";
import {MainPage, LoginPage, SignUpPage, SocialLoginingPage, MyPortfolioPage} from "./Container";

function App() {
  return (
    <div className="App">
      <Router>
        <Route path="/" exact component={LoginPage}/>
        <Route path="/signup" component={SignUpPage}/>
        <Route path="/main" exact component={MainPage}/>
        <Route path="/login/oauth" component={SocialLoginingPage}/>
        <Route path="/myportfolio" component={MyPortfolioPage}/>
      </Router>
    </div>
  );
}

export default App;