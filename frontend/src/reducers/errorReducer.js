import {ERRORS} from "../actions/types";

export const errorRedcuer = (state={},action)=>{
    switch(action.type){
        case ERRORS:
            return action.payload;

        default:
            return state;
    }
}