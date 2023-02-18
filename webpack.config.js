const path = require('path');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const CopyPlugin = require('copy-webpack-plugin');

module.exports = {
    entry: [
        './src/main/resources/assets/css/styles.css',
        './src/main/resources/assets/js/main.js',
    ],
    output: {
        filename: 'js/main.js',
        path: path.resolve('src/main/resources/static'),
        publicPath: '',
        clean: false,
    },
    mode: 'development',
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: 'babel-loader',
            },
            {
                test: /\.css$/,
                use: [
                    MiniCssExtractPlugin.loader,
                    { loader: 'css-loader', options: { url: false } },
                    'postcss-loader',
                ],
            },
        ],
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: 'css/styles.css',
        }),
        new CopyPlugin({
            patterns: [
                {
                    from: './node_modules/tinymce',
                    to: 'vendors/tinymce'
                }
            ]
        }),
    ],
    devtool: 'source-map',
};
