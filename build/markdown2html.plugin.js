// const pluginName = 'MarkdownToHtmlPlugin'

class MarkdownToHtmlPlugin {
  constructor (options) {
    this.options = options
  }
  apply (compiler) {
    compiler.hooks.compile.tap('MarkdownToHtmlPlugin', params => {
      console.log('以同步方式触及 compile 钩子。')
    })
  }
}

module.exports = MarkdownToHtmlPlugin
