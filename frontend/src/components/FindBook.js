import React from "react";
import TextField from "@material-ui/core/TextField";
import Box from "@material-ui/core/Box";
import axios from "axios";
import Button from "@material-ui/core/Button";
import CustomDialog from "./CustomDialog";

export default class FindBook extends React.Component {
  constructor(props) {
    super(props);

    this.state={
      'title':'',
      'authorName':''
    }
    // this.onSubmit = this.onSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
    this.onSearchClick = this.onSearchClick.bind(this);
  }

  onSearchClick(){
    this.props.onSearchBook(this.state.title,this.state.authorName);
  }

  async onSubmit(e) {
    e.preventDefault();
  
  //  const res =  await axios.get('api/books/',{
  //      params: {
  //           title:this.state.bookTitle,
  //           authorName:this.state.authorName
  //       }
  //   });
  //   console.log(res);
  }

  onChange(e) {
    e.persist();
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    return (
      <div style={{ "textAlign": "left",'margin':'1%' }}>
       <div>
          <TextField
            id="standard-basic"
            label="title"
            margin="normal"
            name="title"
            onChange={this.onChange}
          />
          <br />
          <TextField
            id="filled-basic"
            label="author name"
            margin="normal"
            name="authorName"
            autoComplete="off"
            onChange={this.onChange}
          />

          <Box m={2}>
            <Button variant="contained" color="primary" onClick={this.onSearchClick}>
              FIND
            </Button>
          </Box>
          </div>

      </div>
    );
  }
}
