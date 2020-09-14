import React from "react";
import logo from "./logo.jpg";
import { Link } from "react-router-dom";
import SearchIcon from "@material-ui/icons/Search";
import ShoppingBasketIcon from  "@material-ui/icons/ShoppingBasket";
import './Header.css'
import { useStateValue } from "./StateProvider";
import { auth } from "./firebase";
//import intitialState  from "./reducer";


function Header() {
  
  const [{basket,user}]= useStateValue();
   const login =()=>
   {
     if(user)
     {
       auth.signOut();
     }
   }
  return (
    <nav className="header">
      <Link to="/">
        <img className="header__logo" alt="" src={logo} />
      </Link>
      <div className="header__search">
        <input type="text" className="header__searchInput" />
        <SearchIcon className="header__searchIcon"/>
      </div>
      <div className="header__nav">
      
       <Link to={!user &&"/login"} className="header__link">
       <div className="header__option" onClick={login}>
       <span className="header__optionLineOne">Hello</span>
       <span className="header__optionLineTwo">{user? "Signout" :"SignIn"}</span>
       </div>
       </Link>

       <Link to="/" className="header__link">
       <div className="header__option">
       <span className="header__optionLineOne">Returns</span>
       <span className="header__optionLineTwo">&Orders</span>
       </div>
       </Link>

       <Link to="/" className="header__link">
       <div className="header__option">
       <span className="header__optionLineOne">Your</span>
       <span className="header__optionLineTwo"> Prime</span>
       </div>
       </Link>
       <Link to="/checkout">
         <div className="header__basket">
         <ShoppingBasketIcon />
           <span className="header__optionLineTwoBasketCount">{basket?.length}</span>
           
         </div>
       </Link>

      </div>

    </nav>
  );
}

export default Header;
