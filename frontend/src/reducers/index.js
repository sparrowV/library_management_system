import { combineReducers } from "redux";
import {loginReducer} from './securityReduces';
import {errorRedcuer} from './errorReducer';
import {LOGOUT} from '../actions/types';

const appReducer =  combineReducers({
    user:loginReducer,
    errors:errorRedcuer
});


export default (state,action) =>{
    if(action.type === LOGOUT){
        state = undefined;
    }

    return appReducer(state,action);

}