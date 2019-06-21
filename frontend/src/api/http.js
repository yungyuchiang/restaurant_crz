import axios from './axios'

export default {
    /**
     * 通用post请求
     * @param  {String}   url      请求地址
     * @param  {Object}   data     请求参数
     * @param  {Function} callback 请求成功回调函数
     * @param  {Function} failCallback 请求失败回调函数
     */
    postAjax(url, data, callback, failCallback) {
        axios({
            method: 'post',
            url: url,
            data: data,
            baseURL: process.env.VUE_APP_BASE_API
        }).then((response) => {
            callback(response.data)
        }).catch((err) => {
        })
    },
    /**
     * 通用patch请求
     * @param  {String}   url      请求地址
     * @param  {Object}   data     请求参数
     * @param  {Function} callback 请求成功回调函数
     * @param  {Function} fialCallback 请求失败回调函数
     */
    patchAjax(url, data, callback, fialCallback) {
        axios({
            method: 'patch',
            url: url,
            data: data,
            baseURL: process.env.VUE_APP_BASE_API
        }).then((response) => {
            callback(response.data)
        }).catch((err) => {
            console.log(err)
        })
    },

    /**
     * 通用get请求
     * @param  {String}   url      请求地址
     * @param  {Object}   data     请求参数
     * @param  {Function} callback 请求成功回调函数
     * @param  {Function} fialCallback 请求失败回调函数
     */
    getAjax(url, data, callback, fialCallback) {
        // 为get请求增加一个随机数 避免IE浏览器的缓存机制导致显示数据与数据库不一致
        data.randomTime = new Date().getTime() / 1000
        axios({
            method: 'get',
            url: url,
            params: data,
            baseURL: process.env.VUE_APP_BASE_API
        }).then((response) => {
            callback(response.data)
        }).catch((err) => {
            console.log("why", err)
        })
    },
    /**
     * 通用删除请求
     * @param  {String}   url      请求地址
     * @param  {Object}   data     请求参数
     * @param  {Function} callback 请求成功回调函数
     * @param  {Function} fialCallback 请求失败回调函数
     */
    delAjax(url, data, callback, fialCallback) {
        // 为get请求增加一个随机数 避免IE浏览器的缓存机制导致显示数据与数据库不一致
        data.randomTime = new Date().getTime() / 1000
        axios({
            method: 'delete',
            url: url,
            params: data,
            baseURL: process.env.VUE_APP_BASE_API
        }).then((response) => {
            callback(response.data)
        }).catch((err) => {
            console.log("why", err)
        })
    },
    /**
     * 登陆请求/4A系统的请求
     * @param  {String}   url      请求地址
     * @param  {Object}   data     请求参数
     * @param  {Function} callback 请求成功回调函数
     * @param  {Function} fialCallback 请求失败回调函数
     */
    postAjaxPerson(url, data, callback, fialCallback) {
        axios({
            method: 'post',
            url: url,
            data: data,
            baseURL: process.env.VUE_APP_BASE_LOGIN_URL
        }).then((response) => {
            callback(response.data)
        }).catch((err) => {
            console.log("why", err)
        })
    }
}
