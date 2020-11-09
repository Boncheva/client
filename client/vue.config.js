const webpack = require('webpack')
module.exports = {
  publicPath: './',
  css: {
    extract: true,
    sourceMap: false,
    // css预设器配置项
    // 启用 CSS modules for all css / pre-processor files.
    modules: false,
    loaderOptions: {
      sass: {}
    }
  },
  runtimeCompiler: true,

  lintOnSave: true, // default false
  // 打包时不生成.map文件
  productionSourceMap: false,
  devServer: {
    proxy: ''
  }
}
