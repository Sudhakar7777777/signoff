const path = require("path");
const webpack = require("webpack");
const {resolve} = require("path");
const {CleanWebpackPlugin} = require("clean-webpack-plugin");
const HtmlWebPackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const WebpackBar = require("webpackbar");

// Define Custom Params -- tweak based on your application needs this section
const isDevelopment = process.env.NODE_ENV !== "production";
const DEV_SERVER_PORT = 8080;
const APP_TITLE = "SBK Application";
const APP_VERSION = "0.1";
const FILES = {
  main: "index.tsx",
  template: "index.ejs",
  output_html: "index.html",
  favicon: "favicon.ico",
  dev_filename: "[name].bundle.js",
  prod_filename: "[name].bundle.[hash].js",
};
const PATHS = {
  app: path.join(__dirname, "src"),
  build: path.join(__dirname, "dist"),
  node_modules: path.resolve(__dirname, "node_modules"),
  public: path.join(__dirname, "src/public"),
  public_path: "/assets/",
};

// Define main config -- ideally not required to change this section
const config = {
  context: __dirname,
  entry: {
    app: [path.join(PATHS.app, FILES.main)],
  },
  mode: isDevelopment ? "development" : "production",
  devtool: isDevelopment ? "source-map" : "",
  output: {
    path: PATHS.build,
    // publicPath: PATHS.public_path,	// configure assets folder for images, etc. later
    filename: isDevelopment ? FILES.dev_filename : FILES.prod_filename,
  },
  devServer: {
    contentBase: PATHS.build,
    historyApiFallback: true,
    hot: true,
    inline: true,
    host: "localhost",
    port: DEV_SERVER_PORT,
    proxy: {
      "/api": "http://localhost:3000",
    },
    publicPath: "/",
    stats: "errors-only",
  },
  optimization: {
    runtimeChunk: false,
    // Create a vendors chunk, which includes all code from node_modules.
    splitChunks: {
      cacheGroups: {
        commonStyle: {
          test: /[\\/]node_modules[\\/]/,
          name: "vendors",
          chunks: "all",
        },
      },
    },
  },
  plugins: [
    new CleanWebpackPlugin(),
    new HtmlWebPackPlugin({
      title: APP_TITLE,
      filename: FILES.output_html,
      template: path.join(PATHS.public, FILES.template), // Load a custom template (lodash by default)
      hash: isDevelopment ? false : true,
      inject: true,
      environment: isDevelopment ? "Development" : "Production",
      version: APP_VERSION,
    }),
    new MiniCssExtractPlugin({
      filename: isDevelopment ? "[name].css" : "[name].[hash].css",
      chunkFilename: isDevelopment ? "[id].css" : "[id].[hash].css",
    }),
    new WebpackBar(),
  ],
  module: {
    rules: [
      {
        test: /\.(t|j)sx?$/,
        loader: "babel-loader",
        include: PATHS.app,
        exclude: /node_modules/,
      },
      {
        test: /\.js$/,
        loader: "source-map-loader",
        enforce: "pre",
      },
      {
        test: /\.html$/,
        use: [
          {
            loader: "html-loader",
            options: {minimize: !isDevelopment},
          },
        ],
      },
      {
        test: /\.module\.s(a|c)ss$/,
        loader: [
          isDevelopment ? "style-loader" : MiniCssExtractPlugin.loader,
          {
            loader: "css-loader",
            options: {
              modules: true,
              sourceMap: isDevelopment,
            },
          },
          {
            loader: "sass-loader",
            options: {
              sourceMap: isDevelopment,
            },
          },
        ],
      },
      {
        test: /\.s(a|c)ss$/,
        exclude: /\.module.(s(a|c)ss)$/,
        loader: [
          isDevelopment ? "style-loader" : MiniCssExtractPlugin.loader,
          "css-loader",
          {
            loader: "sass-loader",
            options: {
              sourceMap: isDevelopment,
            },
          },
        ],
      },
      {
        test: /\.(gif|png|jpe?g|svg)$/i,
        use: [
          "file-loader",
          {
            loader: "image-webpack-loader",
            options: {
              mozjpeg: {
                progressive: true,
                quality: 65,
              },
              optipng: {
                enabled: !isDevelopment,
              },
              pngquant: {
                quality: "65-90",
                speed: 4,
              },
              gifsicle: {
                interlaced: false,
              },
              webp: {
                quality: 75,
              },
            },
          },
        ],
      },
    ],
  },
  resolve: {
    extensions: [
      ".js",
      ".jsx",
      ".ts",
      ".tsx",
      ".scss",
      ".gif",
      ".png",
      ".jpg",
      ".jpeg",
      ".svg",
    ],
    modules: [resolve(__dirname, "src"), "node_modules"],
  },
};

module.exports = config;
