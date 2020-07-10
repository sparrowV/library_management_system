import { ADD_BOOK,ERRORS } from "./types";
import axios from "axios";

export const addBook = (book) =>  async (dispatch) => {
  try {

    console.log(book);
    // const res =await axios.post("api/ssbooks/add", book);
    await axios({
        method: "post",
        url: "api/books/add",
        data: book,
        headers: {
            "Content-Type": "application/json",
          },
       
      });
    dispatch({
        type:ERRORS,
        payload:{}
    })
  }catch(err){
    dispatch({
        type:ERRORS,
        payload:err.response.data
    })
  }
};
