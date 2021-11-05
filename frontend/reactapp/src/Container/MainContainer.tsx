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

    /*
    const toLeaderBoard = () => {
        history.push("/leaderboard");
    };

    const toPublishList = () => {
        history.push("/publishlist");
    };
    
    const toStockPrice = () => {
        history.push("/stockprice");
    };
    */

    return(
        <div>
        <MainPresenter
          toMyPortfolio={toMyPortfolio}
          //toLeaderBoard={toLeaderBoard}
          //toPublishList={toPublishList}
          //toStockPrice={toStockPrice}
        />
      </div>
    )

};

export default MainContainer;