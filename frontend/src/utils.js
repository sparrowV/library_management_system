import store from './store';


export const hasAuthority = (authority)=>{
    const state = store.getState();
    if(state.user.details.authorities){
        return state.user.details.authorities.includes(authority);
    }
    return false;
}