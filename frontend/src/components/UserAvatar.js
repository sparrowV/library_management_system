import React from "react";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import Menu from "@material-ui/core/Menu";
import MenuItem from "@material-ui/core/MenuItem";
import { connect } from "react-redux";
import { logout } from "../actions/securityAction";
import { withRouter } from "react-router-dom";


class UserAvatar extends React.Component {
  constructor() {
    super();

    this.state = {
      anchorEl: null,
    };
  }

  handleClick = (event) => {
    event.persist();
    this.setState({
      anchorEl: event.currentTarget,
    });
  };

  handleClose = () => {
    console.log("sdsds");
    this.setState({
      anchorEl: null,
    });
  };

  onLogoutClick = async () => {
    await this.props.logout();
    // window.location.href = "/";
    this.props.history.push("/");
  };

  render() {
    return (
      <div style={{marginLeft:'auto',marginRight:'3em'}}>
        <Button
          aria-controls="simple-menu"
          aria-haspopup="true"
          onClick={this.handleClick}
        >
          <Avatar>H</Avatar>
        </Button>
        <Menu
          anchorEl={this.state.anchorEl}
          keepMounted
          open={Boolean(this.state.anchorEl)}
          onClose={this.handleClose}
        >
          <MenuItem onClick={this.onLogoutClick}>Logout</MenuItem>
        </Menu>
      </div>
    );
  }
}
const userAvatarWithRouter = withRouter(UserAvatar);
export default connect(null, { logout })(userAvatarWithRouter);
