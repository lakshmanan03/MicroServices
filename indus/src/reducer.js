export const initialState = {
    basket:[],
    user:[],
};

const reducer =(state,action) =>
{
    console.log(action);
switch(action.type){

    case 'SET_USER':
        return {...state,user:action.user,}
    case 'ADD_TO_BASKET' :
    return { ...state,
    basket: [...state.basket,action.item]
    };
       
    case 'REMOVE_FROM_BASKET' :
        //cloned the basket

        let newBasket=[...state.basket];
        console.log('we are here');
        const index=state.basket.findIndex((basketItem)=>basketItem.id===action.id);
        console.log('and the '+index);
        if(index>=0)
        {
            
            newBasket.splice(index,1);

        }else
        {
            console.warn('nothing to remove');
        }
    
        return {...state,
        basket:newBasket };
       

    default :
    return state;

}
}

export default reducer;