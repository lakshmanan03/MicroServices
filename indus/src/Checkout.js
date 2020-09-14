import React from 'react';
import { useStateValue } from "./StateProvider";
import checkoutad from "./checkoutad.jpg";
import "./Checkout.css"
import CheckoutProduct from './CheckoutProduct'
import Subtotal from "./Subtotal";


function Checkout() {

  
    const [{basket}]= useStateValue();
  return (
    <div className="checkout">
      <img className="checkout__ad" src={checkoutad} alt=""/>
    
    {basket?.length===0?(<div className="emptyBasket">
      <h2>Your shopping basket is empty</h2>
      <p><strong>You can buy or add items in to your card by clicking on "Add to basket"</strong></p></div>)
      :(
     <div classNam="left"> <div className="fullBasket"><p className="basketTitle"><b>Your current purchases</b></p>
        
        {basket.map(item=>(<CheckoutProduct id={item.id} title={item.title} image={item.image} price={item.price}
        rating ={item.rating}/>))}

      </div>
      <div className="subtotal"><Subtotal/></div>
      </div>
      )}
      
    </div>
  )
}

export default Checkout
