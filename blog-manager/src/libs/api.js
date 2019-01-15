import env from '../../build/env';
import axios from 'axios';

let api = {
	login: "/ajax/manager/login.json",
	logout: "ajax/manager/logout.json",

	getBlogList: "/ajax/blog/list.json",
    getBlogInfo: "/ajax/blog/get.json",
    saveBlogInfo: "/ajax/blog/save",

    getBlogTypeList: "ajax/blog/type/list.json",
    
    getTopicList: "/ajax/topic/list.json",

	getSystemInfo: "/ajax/system/getInfo.json",
}

const ajaxUrl = env === 'development' ? 'http://127.0.0.1:8001' : 'http://127.0.0.1:8001';

api.ajax = axios.create({
    baseURL: ajaxUrl,
    timeout: 5000,
    headers: {
        "Content-Type" : "application/json;charset=UTF-8",
        "Authorization" : localStorage.getItem('token')
    }
});

// api.ajax.interceptors.request.use(function (config) {
//     const token = localStorage.getItem('token');
//     if(config.method === 'post') {
//         config.params = { token: token}
//     } else if(config.method === 'get') {
//         config.params = { token: token, ...config.params }
//     }
//     return config;
// }, function (error) {
//     return Promise.reject(error);
// });

// /* 过滤请求 */
// axiosWrap.interceptors.request.use((config) => {
//     return config
// })
// /* 过滤响应 */
// axiosWrap.interceptors.response.use((result) => {
//     /* 假设当code为0时代表响应成功 */
//     if (result.data.code != 0) {
//         return Promise.reject(result)
//     }
//     return result.data.data
// }, result => {
//     return Promise.reject(result)
// })

export default api;