//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    
    // 登录
    wx.login({
      success: function(res) {
        if (res.code) {
          wx.request({
            url: "http://localhost:8080/auth",
            data: {
              code: res.code
            },
            method: "POST",
            header: {
              'content-type': 'application/json',
            },
            success: function (res) {
              console.log(res.data.access_token);
              var token = res.data.access_token;
              
              wx.getUserInfo({
                success: res => {              
                  // 保存用户信息到服务端
                  wx.request({
                    url: "http://localhost:8080/updateConsumerInfo",
                    data: res.userInfo,
                    method: "POST",
                    header: {
                      'Authorization': 'Bearer ' + token,
                      'content-type': 'application/json',
                    },
                    success: function (res) {
                      console.log("success");
                    },
                    fail: function (error) {
                      console.log(error);
                    }
                  })

                  // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
                  // 所以此处加入 callback 以防止这种情况
                  if (this.userInfoReadyCallback) {
                    this.userInfoReadyCallback(res)
                  }
                }
              })

            },
            fail: function (error) {
              console.log(error);
            }
          })
        } else {
          console.log("error code " + res.errMsg);
        }
      }
    })
    
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
        }
      }
    })
  },

  globalData: {
    userInfo: null
  }

})