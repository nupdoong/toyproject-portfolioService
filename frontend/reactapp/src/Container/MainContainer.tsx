import * as React from "react";
import { useState } from "react";
import MainPresenter from "../Presenter/Main/MainPresenter";
import axios from "axios";
import cookies from "js-cookie";
import Endpoint from "../config/Endpoint";
import { useHistory } from "react-router";

const MainContainer = () => {
    const history = useHistory();

    const toMyPortfolio = () => {
        history.push("/signup");
    };
    const toStockPrice = () => {
        history.push("/stock");
    };
    
    return(
        <div>
        <MainPresenter
          toMyPortfolio={toMyPortfolio}
          toStockPrice={toStockPrice}
        />
      </div>
    )

};

export default MainContainer;