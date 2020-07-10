import React from 'react';
import Paper from '@material-ui/core/Paper';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import {connect} from 'react-redux';
import { withRouter } from 'react-router-dom';

class Header extends React.Component{

    constructor(){
        super();

        this.onTabChange = this.onTabChange.bind(this);
        this.onAddBookClick = this.onAddBookClick.bind(this);
        this.state = {'currentTab':0}    
    }

    onTabChange(event,value){
        console.log(value);
        this.setState({'currentTab':value});
    }

    onAddBookClick(){
            this.props.history.push('/addBook');
    }

    render(){
        return(
            <Paper square>
            <Tabs
              value={this.state.currentTab}
              indicatorColor="primary"
              textColor="primary"
              onChange={this.onTabChange}
              aria-label="disabled tabs example"
            >
              <Tab label="add book" onClick={this.onAddBookClick} />
              <Tab label="second"  />
              <Tab label="third" />
            </Tabs>
          </Paper>
        );
    }

}

const headerWithRouter = withRouter(Header);
export default connect(null,null)(headerWithRouter);