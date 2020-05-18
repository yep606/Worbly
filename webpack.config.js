const path = require('path');

const VueLoaderPlugin = require('vue-loader/lib/plugin')

const ROOT = path.resolve(__dirname, 'src/main/resources/static');
const DEST = path.resolve(__dirname, 'src/main/resources/static');

module.exports = {
    entry: path.resolve(ROOT, 'js/code.js'),
    output: {
        filename: 'app.js',
        path: path.resolve(DEST, 'dist'),
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            }
        ]
    },
    plugins: [
        // make sure to include the plugin!
        new VueLoaderPlugin()
    ]

};