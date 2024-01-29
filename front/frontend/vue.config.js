module.exports = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080'
      }
    }
  },

  pluginOptions: {
    vuetify: {
			// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
		}
  }
}
