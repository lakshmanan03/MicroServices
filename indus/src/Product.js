import React from 'react'
import StarIcon from '@material-ui/icons/Star';
import './Product.css'
import { useStateValue } from "./StateProvider";

function Product(props) {

  const [{},dispatch]= useStateValue();
  const addToBasket =()=>
  {
   dispatch(
     {type:'ADD_TO_BASKET',
    item:{
      id:props.id,
      title:props.title,
      price:props.price,
      rating:props.rating,
      image:props.image
    }
    }
   )
  };
  return (
    <div className="product grow">
     <p className="product__title"><b> {props.title}</b></p>
  <p className="product__price"><small>Rs. </small><strong>{props.price}</strong></p>
  <div className="product__rating">
      {
          Array(props.rating).fill().map((_)=>(<StarIcon className="star"/>))
      }
  </div>
  <img className="product__img" src={props.image} alt=""/>
  <button onClick={addToBasket} >Add to basket</button>
     
    </div>
  )
}

export default Product
