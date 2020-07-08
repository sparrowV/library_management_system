import {SET_USER, ERRORS} from '../actions/types';

export const loginReducer = (state={},action)=>{
	console.log(action);
	console.log(Object.assign({},state,action.payload));
    switch(action.type){
        case SET_USER:
            return Object.assign({},state,{details:action.payload});


        default:
            return state;
    }

    
}