import { combineReducers } from "redux";
import {loginReducer} from './securityReduces';
import {errorRedcuer} from './errorReducer';

export default combineReducers({
    user:loginReducer,
    errors:errorRedcuer
});