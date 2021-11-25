import * as React from "react";
import "./MyPortfolioPresenter.scss";
import { Button, Input, Form } from "antd";
import Item from "antd/lib/list/Item";
type MyPortfolioPresenterProps = {
    toConstructPortfolio: Function
    mylist: {
        username: string
        ticker: string
        avgprice: number
        stockEA: number
    }[];
    loadQuotesForStock: Function
};
const MyPortfolioPresenter = ({
    toConstructPortfolio,
    mylist,
    loadQuotesForStock,
    //toLeaderBoard,
    //toPublishList,
    //toStockPrice,
  }: MyPortfolioPresenterProps) => {
    return (
      <div className={"background"}>
        <table>
          <tbody>
            <tr>
            <td width="100">Ticker</td> 
            <td width="100">AvgPrice</td> 
            <td width="100">EA</td>
            <td width="100">Total Buy</td>
            <td width="100">Stock Price</td>
            <td width="100">Yield</td>

              </tr>
           {mylist.map(portfolio => (
           <tr>
             <td>{portfolio.ticker}</td>
             <td>${portfolio.avgprice}</td>
             <td>{portfolio.stockEA}</td>
             <td>${portfolio.avgprice*portfolio.stockEA}</td>
             <td>yet...</td>
             <td>yet...</td>
             </tr>
         ))}
         </tbody>
         </table>
      </div>
    );
  };

export default MyPortfolioPresenter;