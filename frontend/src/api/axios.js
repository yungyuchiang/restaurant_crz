import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/json'
axios.defaults.headers.get['Content-Type'] = 'application/json'

axios.defaults.baseURL = process.env.VUE_APP_BASE_API
// 请求拦截
axios.interceptors.request.use(function (config) {
    // config.headers['Content-Type'] = 'application/x-www-form-urlencoded'
    return config
}, function (error) {
    console.log(error)
    return Promise.reject(error)
})

// 响应拦截
axios.interceptors.response.use(
    function (response) {
        // Do something with response data
        // console.log(response)

        return response
    },
    function (error) {
      if (error.response) {
        switch (error.response.status) {
          case 401:
              this.$message({
                  message: '您无权访问该页面！',
                  type: 'error'
              })
            break;
          case 404:
              this.$message({
                  message: '访问路径不存在！',
                  type: 'error'
              })
            break;
          case 500:
              this.$message({
                  message: '服务器出错了：',
                  type: 'error'
              })
            // router.push({name:'home'})
            break;
        }
      }
      return Promise.reject(error)
    }
)

export default axios
