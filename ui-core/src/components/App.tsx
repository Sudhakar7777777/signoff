import React from "react";
import { MemoryRouter, Switch, Route } from "react-router-dom";

import NavFooter from "./Nav/NavFooter";
import NavMenu from "./Nav/NavMenu";
import NavTitle from "./Nav/NavTitle";

import Container from "react-bootstrap/Container";

const App = () => (
  <MemoryRouter>
    <NavTitle />
    <NavMenu />

    <Container fluid>
      {/* Add your project components here */}
      <div>Hello World</div>
    </Container>

    <NavFooter />
  </MemoryRouter>
);

export default App;
