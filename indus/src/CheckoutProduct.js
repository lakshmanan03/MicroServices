 import React from 'react'
 import StarIcon from '@material-ui/icons/Star';
 import  './CheckoutProduct.css'
 import { useStateValue } from "./StateProvider";

 


 
 function CheckoutProduct(props) {

    console.log(props.id)
    const [{basket},dispatch]= useStateValue();

    const removeFromBasket=()=>{

        dispatch({
            type:"REMOVE_FROM_BASKET",
        id:props.id
    });
}
   return (
     <div className="checkoutproduct">
          
         <img  className="productimage"src={props.image} alt=""/>
     <div className="productinfo"><p className="producttitle">{props.title}</p>
     <p className="productprice"><small>Rs. </small><strong>{props.price}</strong></p>
     
     <div className="productrating">
      {
          Array(props.rating).fill().map((_)=>(<StarIcon className="star"/>))
      }
       <button className="productbutton" onClick={removeFromBasket}>Remove from basket</button>
  </div></div>
 
     </div>
   )
 }
 
 export default CheckoutProduct
 