import Vue from 'vue'
import Axios from "axios";


const API_URL = process.env.API_URL || 'http://localhost:8080';

const axios= Axios.create({
    baseURL: API_URL,
    headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.token
    }
})
Vue.use(axios);
export default axios;
