import React from 'react';
import  {TextField}  from '@material-ui/core';
import  Button from '@material-ui/core/Button';
import  Box from '@material-ui/core/Box';
import {addBook} from '../actions/bookActions';
import {connect} from 'react-redux';
import Header from './Header';
import axios from 'axios';

class AddBook extends React.Component{
    constructor(){
        super();

        this.state={
            'title':'',
            'location':'',
            'authorName':'',
            'quantity':1
        }
        this.onSubmit = this.onSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    async componentDidMount(){
      const bookId = this.props.match.params.id;
      console.log("book id ="+bookId);
      if(bookId){
          const res = await axios.get(`/api/books/${bookId}`);
            this.setState({...res.data});
            // console.log({...book});
        }
    }

     async onSubmit(e){
        e.preventDefault();
        const book = {
          'title':this.state.title,
          'location':this.state.location,
          'authorName':this.state.authorName,
          'quantity':this.state.quantity
        }
        const bookId = this.props.match.params.id;
        if(bookId){
          book.id = bookId;
        }
         await this.props.addBook(book);
        this.props.history.push('/dashboard');
     }

    onChange(e){
      e.persist();
      this.setState({ [e.target.name]: e.target.value });
    }

    render(){
        return(
          <div>
          <Header/>
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
              value={this.state.title}
              name="title"
              onChange={this.onChange}
              error={this.props.errors && this.props.errors.title}
              helperText={this.props.errors && this.props.errors.title ?
                  this.props.errors.title:"" }
            />
            <br />
            <TextField
              id="filled-basic"
              label="location"
              margin="normal"
              value={this.state.location}
              name="location"
              onChange={this.onChange}
              autoComplete="off"
              error={this.props.errors && this.props.errors.location}
              helperText={this.props.errors && this.props.errors.location ?
                  this.props.errors.location:"" }
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
              error={this.props.errors && this.props.errors.authorName}
              helperText={this.props.errors && this.props.errors.authorName ?
                  this.props.errors.authorName:"" }
            />
            <br />
            <TextField
              id="filled-basic"
              label="quantity"
              margin="normal"
              value={this.state.quantity}
              name="quantity"
              onChange={this.onChange}
              autoComplete="off"
              type='number'
              error={this.props.errors && this.props.errors.quantity}
              helperText={this.props.errors && this.props.errors.quantity ?
                  this.props.errors.quantity:"" }
            />
  
            <Box m={2}>
              <Button variant="contained" color="primary" type="submit">
                ADD
              </Button>
            </Box>
          </form>
          </div>
            
        )
    }

}

const mapStateToProps =(state)=>(
  {errors:state.errors}
);

export default connect(mapStateToProps,{addBook})(AddBook);