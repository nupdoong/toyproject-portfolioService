import * as React from "react";
import "./MyPortfolioPresenter.scss";
import { Button, Input, Form } from "antd";
type MyPortfolioPresenterProps = {

    toConstructPortfolio: Function
    getMyPortfolioList: Function
    mylist: {
        username: string
        ticker: string
        avgprice: number
        stockEA: number
    }[];
};
const MyPortfolioPresenter = ({
    toConstructPortfolio,
    getMyPortfolioList,
    mylist,
    //toLeaderBoard,
    //toPublishList,
    //toStockPrice,
  }: MyPortfolioPresenterProps) => {
      getMyPortfolioList();
    return (
        
      <div className={"background"}>
         
      </div>
    );
  };

export default MyPortfolioPresenter;