import React from "react";
import Paper from "@material-ui/core/Paper";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import { connect } from "react-redux";
import { withRouter } from "react-router-dom";
import { logout } from "../actions/securityAction";

class Header extends React.Component {
  constructor() {
    super();

    this.onTabChange = this.onTabChange.bind(this);
    this.onAddBookClick = this.onAddBookClick.bind(this);
    this.onLogoutClick = this.onLogoutClick.bind(this);
    this.state = { currentTab: 0 };
  }

  async onLogoutClick() {
    await this.props.logout();
    window.location.href="/";
  }

  onTabChange(event, value) {
    console.log(value);
    this.setState({ currentTab: value });
  }

  onAddBookClick() {
    this.props.history.push("/addBook");
  }

  render() {
    return (
      <Paper square>
        <Tabs
          value={this.state.currentTab}
          indicatorColor="primary"
          textColor="primary"
          onChange={this.onTabChange}
   
        >
          <Tab label="add book" onClick={this.onAddBookClick} />
          <Tab label="logout" onClick={this.onLogoutClick} />
          <Tab label="dashboard" onClick={()=>{this.props.history.push("/dashboard")}}/>
        </Tabs>
      </Paper>
    );
  }
}



const headerWithRouter = withRouter(Header);
export default connect(null, {logout})(headerWithRouter);
