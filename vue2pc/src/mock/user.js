import Mock from 'mockjs'
import { getData, getParams } from '@/mock/utils'
const tokens = {
  admin: {
    token: 'admin-token'
  },
  editor: {
    token: 'editor-token'
  }
}

const users = {
  'admin-token': {
    introduction: 'I am a super administrator',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Super Admin'
  },
  'editor-token': {
    introduction: 'I am an editor',
    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    name: 'Normal Editor'
  }
}

export let login = Mock.mock(/\/api\/user\/login/, "post", (data) => {
  console.log("mock请求登录 ===》 ", data)
  let username=getData(data.body,'username')
  let password=getData(data.body,'password')
  const token = tokens[username]
  // mock error
  if (!token) {
    return {
      code: 500,
      message: '账户用户名或密码错误'
    }
  }

  return {
    code: 200,
    message: '操作成功',
    data: token
  }
})

export let getUserInfoByToken = Mock.mock(/\/api\/user\/getUserInfoByToken/, "post", (param) => {
  let token = getData(param.body,'token')
  const info = users[token]

  // mock error
  if (!info) {
    return {
      code: 500,
      message: 'token异常无法获取用户信息'
    }
  }

  return {
    code: 200,
    message: '操作成功',
    data: info
  }
})

export let logout = Mock.mock(/\/api\/user\/logout/, "post", () => {
  return {
    code: 200,
    message: '操作成功',
  }
})
