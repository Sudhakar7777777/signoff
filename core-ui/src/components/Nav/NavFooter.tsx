import React from "react";
import Navbar from "react-bootstrap/Navbar";

const NavFooter = () => (
  <Navbar bg="dark" variant="dark" fixed="bottom">
    <Navbar.Collapse className="justify-content-md-center">
      <Navbar.Text>© 2020 SBK Inc</Navbar.Text>
    </Navbar.Collapse>
  </Navbar>
);

export default NavFooter;
