import * as React from "react";
import { Input, Button, Form, Result } from "antd";
import "./MainPresenter.scss";
import styled from "styled-components";

type MainPresenterProps = {
    toMyPortfolio: Function;
    //toLeaderBoard: Function;
    //toPublishList: Function;
    //toStockPrice: Function;
  };
  
  
  const MainPresenter = ({
    toMyPortfolio,
    //toLeaderBoard,
    //toPublishList,
    //toStockPrice,
  }: MainPresenterProps) => {
    return (
      <div className={"background"}>
        <Form
          className={"main-container"}
        >
          <div className={"mainForm"}>
            <span className="buttonForm">
              <Button
                type="primary"
                style={{
                  marginLeft: "auto",
                  marginRight: "10px",
                }}
                onClick={(e) => {
                  toMyPortfolio();
                }}
              >
                나의 포트폴리오
              </Button>
              <Button
                type="primary"
                style={{
                  marginLeft: "auto",
                  marginRight: "10px",
                }}
                onClick={(e) => {
                  //toLeaderBoard();
                  toMyPortfolio();
                }}
              >
                포트폴리오 수익률 랭킹
              </Button>
              <Button
                type="primary"
                style={{
                  marginLeft: "auto",
                  marginRight: "10px",
                }}
                onClick={(e) => {
                  //toPublishList();
                  toMyPortfolio();
                }}
              >
                포트폴리오 구독
              </Button>
              <Button
                type="primary"
                style={{
                  marginLeft: "auto",
                  marginRight: "10px",
                }}
                onClick={(e) => {
                  //toStockPrice();
                  toMyPortfolio();
                }}
              >
                주식 시세 조회
              </Button>
            </span>
          </div>
        </Form>
      </div>
    );
  };

export default MainPresenter;