import React from "react";
import ReactDOM from "react-dom";
import App from "./components/App";

// Importing Sass with Bootstrap CSS
import "./global";

if (module.hot) {
  module.hot.accept();
}

ReactDOM.render(<App />, document.getElementById("root"));
