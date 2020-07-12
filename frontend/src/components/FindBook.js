import React from "react";
import TextField from "@material-ui/core/TextField";
import Box from "@material-ui/core/Box";
import axios from "axios";
import Button from "@material-ui/core/Button";
import CustomDialog from "./CustomDialog";

export default class FindBook extends React.Component {
  constructor() {
    super();

    this.state = {
      bookTitle: "",
      authorName: "",
    };
    this.onSubmit = this.onSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
  }

  async onSubmit(e) {
    e.preventDefault();
  
   const res =  await axios.get('api/books/',{
       params: {
            title:this.state.bookTitle,
            authorName:this.state.authorName
        }
    });
    console.log(res);
  }

  onChange(e) {
    e.persist();
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    return (
      <div style={{ "textAlign": "left",'margin':'1%' }}>
        <form
          onSubmit={this.onSubmit}
          className="login-form"
          noValidate
          autoComplete="off"
        >
          <TextField
            id="standard-basic"
            label="title"
            margin="normal"
            value={this.state.bookTitle}
            name="bookTitle"
            onChange={this.onChange}
          />
          <br />
          <TextField
            id="filled-basic"
            label="author name"
            margin="normal"
            value={this.state.authorName}
            name="authorName"
            onChange={this.onChange}
            autoComplete="off"
          />

          <Box m={2}>
            <Button variant="contained" color="primary" type="submit">
              FIND
            </Button>
          </Box>
        </form>

      </div>
    );
  }
}
