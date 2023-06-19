const getDefaultState = () => {
  return {
    activeIndex: 'index'
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_ACTIVE_INDEX: (state, token) => {
    state.token = token
  }
}

const actions = {
  resetActiveIndex({ commit }) {
    return new Promise(resolve => {
      commit('RESET_STATE')
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

