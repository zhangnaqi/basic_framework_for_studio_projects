import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/user/login',
    method: 'POST',
    data: {
      username,
      password
    }
  })
}

export function getUserInfoByToken(token) {
  return request({
    url: '/user/getUserInfoByToken',
    method: 'POST',
    data: {
      token
    }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'POST'
  })
}
