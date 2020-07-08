import React from "react";
import { Link } from "react-router-dom";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";

const Home = () => {
  return (
    <div>
      <Box m={2}>
        <div>LIBRARY MANAGEMENT SYSTEM</div>
      </Box>

           <Link to="/login" style={{margin:"1%"}}>LOGIN</Link>


           <Link to="/register">SIGN UP</Link>


    </div>
  );
};
export default Home;
