const path = require('path');

const ROOT = path.resolve(__dirname, 'src/main/resources/static');
const DEST = path.resolve(__dirname, 'src/main/resources/static');

module.exports = {
    entry: path.resolve(ROOT, 'js/code.js'),
    output: {
        filename: 'app.js',
        path: path.resolve(DEST, 'dist'),
    },
};