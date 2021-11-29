import * as React from 'react';
import {useEffect, useState} from 'react';
import styled from 'styled-components';
import qs from 'query-string';
import Axios from 'axios';
import Endpoint from "../config/Endpoint";
import MyPortfolioPresenter from "../Presenter/MyPortfolio/MyPortfolioPresenter";
import {Portfolio} from "./dto/Portfolio"
import { useHistory } from "react-router";
import axios from 'axios';


const MyPortfolioContainer = () => {
    
    const [mylist, setMylist] = useState<Array<Portfolio>>([]);
    const history = useHistory();

    const toConstructPortfolio = () => {
        history.push("/signup");
    };

    const api = axios.create({
        baseURL: "https://cloud.iexapis.com/v1"
      });
      
    const loadQuotesForStock = async (ticker: string) => {
        const res = await api.get(`/stock/${ticker}/quote?token=pk_94dfd7dd406f4845be436690da9a87a1`);
        return res.data.close;
    };

    useEffect(()=>{
        Axios.get(
            Endpoint.portfolioServer+'/portfolio/mylist', {
                params: {
                    username: 'nupdoong'
                }
            }
        )
        .then(function (response){
            console.log(response);
            setMylist(response.data);
        })
        .catch(function (error){
            console.log(error)
        });
    }, []);

        

    return(
        <div>
        <MyPortfolioPresenter
            toConstructPortfolio={toConstructPortfolio}
            mylist={mylist}
            loadQuotesForStock={loadQuotesForStock}
        />
        </div>
    )

}

export default MyPortfolioContainer;