import React from 'react';
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { spacing } from "@material-ui/system";
import Box from "@material-ui/core/Box";
import { connect } from "react-redux";
import {register} from '../actions/securityAction';


class Registration extends React.Component{
    constructor(){
        super();

        this.state = {
            'username':'',
            'password':'',
            'confirmPassword':''
        }
        this.onSubmit = this.onSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    async onSubmit(e) {
        e.preventDefault();
        const user = {
          username: this.state.username,
          password: this.state.password,
          confirmPassword:this.state.confirmPassword
        };
    
        await this.props.register(user, this.props.history);
      }
    
      
    
      onChange(e) {
        e.persist();
        this.setState({ [e.target.name]: e.target.value });
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
                error={this.props.errors && this.props.errors.username}
                helperText={this.props.errors && this.props.errors.username ?
                    this.props.errors.username:"" }
              />
              <br />
              <TextField
                id="standard-basic"
                label="password"
                margin="normal"
                value={this.state.password}
                name="password"
                type="password"
                onChange={this.onChange}
                error={this.props.errors && this.props.errors.password}
                helperText={this.props.errors && this.props.errors.password ?
                    this.props.errors.password:"" }
                autoComplete="off"
              />
              <br />
              <TextField
                id="standard-basic"
                label="confirm password"
                margin="normal"
                value={this.state.confirmPassword}
                error={this.props.errors && this.props.errors.confirmPassword }
                helperText={this.props.errors && this.props.errors.confirmPassword ?
                    this.props.errors.confirmPassword:"" }  
                name="confirmPassword"
                type="password"
                onChange={this.onChange}
                autoComplete="off"
              />
            
              <Box m={2}>
                <Button variant="contained" color="primary" type="submit">
                  SUBMIT
                </Button>
              </Box>
            </form>
          );
    }

}

const mapStateToProps = (state)=>({
    errors:state.errors
})

export default  connect(mapStateToProps,{register})(Registration);