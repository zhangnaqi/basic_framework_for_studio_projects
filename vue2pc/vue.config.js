'use strict'
const path = require('path')
const TerserPlugin = require('terser-webpack-plugin')

function resolve(dir) {
  return path.join(__dirname, dir)
}

const name = 'projectName'

module.exports = {
  publicPath: './',
  outputDir: 'buildName',
  assetsDir: 'static',
  productionSourceMap: false,
  devServer: {
    host: 'localhost'
  },
  configureWebpack: {
    name: name,
    resolve: {
      alias: {
        '@': resolve('src')
      }
    },
    optimization: {
      // 去掉各个页面的console.log()
      minimizer: [
        new TerserPlugin({
          terserOptions: {
            compress: {
              drop_console: true
            }
          }
        })
      ]
    }
  }
}
