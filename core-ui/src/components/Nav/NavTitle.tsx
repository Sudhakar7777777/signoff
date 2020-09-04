import React from "react";

import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Navbar from "react-bootstrap/Navbar";

import superman from "../../public/images/super";

const NavTitle = () => (
  <Navbar bg="dark" variant="dark">
    <Navbar.Brand href="#home">
      <img
        alt=""
        src={superman}
        width="30"
        height="30"
        className="d-inline-block align-top"
      />{" "}
      React Bootstrap Template
    </Navbar.Brand>
    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
    <Navbar.Collapse className="justify-content-end"></Navbar.Collapse>

    <Navbar.Text>
      <span>&nbsp;&nbsp;&nbsp;</span>
      Signed in as: <a href="#login">SBK</a>
      <span>&nbsp;&nbsp;&nbsp;</span>
    </Navbar.Text>
    <Form inline>
      <Button variant="secondary">Logout</Button>
    </Form>
  </Navbar>
);

export default NavTitle;
