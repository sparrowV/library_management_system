import React from "react";
import Paper from "@material-ui/core/Paper";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import { connect } from "react-redux";
import { withRouter } from "react-router-dom";
import { hasAuthority } from "../utils";
import UserAvatar from "./UserAvatar";
import AccountCircleIcon from '@material-ui/icons/AccountCircle';


class Header extends React.Component {
  constructor(props) {
    super(props);

    this.onTabChange = this.onTabChange.bind(this);
    this.onAddBookClick = this.onAddBookClick.bind(this);
    this.state = { currentTab: props.selectedTabIndex };
  }

  onTabChange(event, value) {
    console.log("here "+value);  
    this.setState({ currentTab: value });
  }

  onAddBookClick() {
    this.props.history.push("/addBook");
  }

  render() {
    const style = {
      display: "flex",
    };

    return (
      <div>
        <Paper square>
          <Tabs
            value={this.state.currentTab}
            indicatorColor="primary"
            textColor="primary"
            onChange={this.onTabChange}
          >
          <Tab
              label="dashboard"
              onClick={() => {
                this.props.history.push("/dashboard");
              }}
            />  

            {hasAuthority("LIBRARIAN") && (
              <Tab label="add book" onClick={this.onAddBookClick} />
            )}
            
            <UserAvatar />

          </Tabs>
        </Paper>
      </div>
    );
  }
}

export default withRouter(Header);
