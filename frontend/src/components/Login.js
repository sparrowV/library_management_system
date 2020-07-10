import React from "react";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import { spacing } from "@material-ui/system";
import Box from "@material-ui/core/Box";
import { connect } from "react-redux";
import { loginAction } from "../actions/securityAction";
import Alert from "@material-ui/lab/Alert";
import Header from "./Header";

class Login extends React.Component {
  constructor() {
    super();
    this.onSubmit = this.onSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
    this.state = {
      username: "",
      password: "",
    };
  }

  async onSubmit(e) {
    e.preventDefault();
    const user = {
      username: this.state.username,
      password: this.state.password,
    };

    await this.props.loginAction(user, this.props.history);
  }

  

  onChange(e) {
    e.persist();
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    return (
      <div>
        {Object.entries(this.props.errors).length > 0 && 
          <Alert severity="error">{this.props.errors.username + " / "+this.props.errors.password}</Alert>
        }
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

          <Box m={2}>
            <Button variant="contained" color="primary" type="submit">
              Login
            </Button>
          </Box>
        </form>
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  errors: state.errors,
});

export default connect(mapStateToProps, { loginAction })(Login);
