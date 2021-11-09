import * as React from 'react';
import {useEffect, useState} from 'react';
import styled from 'styled-components';
import qs from 'query-string';
import Axios from 'axios';
import Endpoint from "../config/Endpoint";
import MyPortfolioPresenter from "../Presenter/MyPortfolio/MyPortfolioPresenter";
import { useHistory } from "react-router";
import axios from 'axios';


const MyPortfolioContainer = () => {
    
    const [mylist, setMylist] = useState([]);
    const history = useHistory();

    const toConstructPortfolio = () => {
        history.push("/signup");
    };

    const getMyPortfolioList = () => {
        /*useEffect(() => {
            axios.get(
                Endpoint.portfolioServer+'/portfolio/mylist', {
                    params: {
                        id: 'nupdoong'
                    }
                }
            )
            .then(function (response){
                console.log(response);
                setMylist(response.data.data);
            })
            .catch(function (error){
                console.log(error)
            })
            .then(function(){

            });
        }, []);
        */
    };

    return(
        <div>
        <MyPortfolioPresenter
            toConstructPortfolio={toConstructPortfolio}
            getMyPortfolioList={getMyPortfolioList}
            mylist={mylist}
        />
        </div>
    )

}

export default MyPortfolioContainer;