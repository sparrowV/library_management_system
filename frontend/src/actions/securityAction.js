import axios from "axios";
import { SET_USER, ERRORS } from "./types";

export const loginAction = (user, history) => async (dispatch) => {
  try {
    var form_data = new FormData();

    for (var key in user) {
      form_data.append(key, user[key]);
    }
    const res = await axios({
      method: "post",
      url: "api/users/login",
      data: form_data,
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
    });
    console.log(res.data);

    dispatch({
      type: SET_USER,
      payload: res.data,
    });
    dispatch({
        type: ERRORS,
        payload: {},
      });
    history.push("/dashboard");
  } catch (err) {
      console.log(err);
    dispatch({
      type: ERRORS,
      payload: err.response.data,
    });
  }
};

export const register = (user, history) =>async(dispatch)=> {
  try {
    const res = await axios.post("api/users/add", user);
    dispatch({
        type: ERRORS,
        payload: {},
      });
    history.push("/login");
  }catch(err){
      dispatch({
          type: ERRORS,
          payload:err.response.data
      })
  }
};
