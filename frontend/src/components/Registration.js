import React from 'react';
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { spacing } from "@material-ui/system";
import Box from "@material-ui/core/Box";
import { connect } from "react-redux";

class Registration extends React.Component{
    constructor(){
        super();

        this.state = {
            'username':'',
            'password':'',
            'confirmPassword':''
        }
    }

    render(){
        return (
            <form
              onSubmit={this.onSubmit}
              className="login-form"
              noValidate
              autoComplete="off"
            >
              <TextField
                id="standard-basic"
                label="username"
                margin="normal"
                value={this.state.username}
                name="username"
                onChange={this.onChange}
              />
              <br />
              <TextField
                id="filled-basic"
                label="password"
                margin="normal"
                value={this.state.password}
                name="password"
                type="password"
                onChange={this.onChange}
                autoComplete="off"
              />
              <br />
              <TextField
                id="filled-basic"
                label="confirm password"
                margin="normal"
                value={this.state.confirmPassword}
                name="confirmPassword"
                type="password"
                onChange={this.onChange}
                autoComplete="off"
              />
            
              <Box m={2}>
                <Button variant="contained" color="primary" type="submit">
                  Login
                </Button>
              </Box>
            </form>
          );
    }

}