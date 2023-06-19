const getters = {
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  activeIndex: state => state.router.activeIndex
}
export default getters
