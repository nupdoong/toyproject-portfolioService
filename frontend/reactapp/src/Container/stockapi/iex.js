import axios from "axios";

const api = axios.create({
  baseURL: "https://cloud.iexapis.com/v1"
});

export const loadQuotesForStock = async symbol => {
  const res = await api.get(`/stock/${symbol}/quote?token=pk_94dfd7dd406f4845be436690da9a87a1`);
  return res.data;
};

export const loadLogoForStock = async symbol => {
  const res = await api.get(`/stock/${symbol}/logo?token=pk_94dfd7dd406f4845be436690da9a87a1`);
  return res.data.url;
};

export const loadRecentNewsForStock = async symbol => {
  const res = await api.get(`/stock/${symbol}/news?token=pk_94dfd7dd406f4845be436690da9a87a1`);
  return res.data;
};

export const loadChartForStock = async (symbol, range) => {
  const res = await api.get(`/stock/${symbol}/chart/${range}?token=pk_94dfd7dd406f4845be436690da9a87a1`);
  return res.data;
};