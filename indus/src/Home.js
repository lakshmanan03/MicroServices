import React from 'react'
import amazon from "./amazon1.jpg";
import Product from "./Product";
import  "./Home.css";


function Home() {
  return (
    <div className="home">
      <img src={amazon} className="home__image" alt=""></img>
      <div className="home__row">
      <Product id="4287" title="The Hair Dryer"
      price={4354} rating={4}
      image="https://images-na.ssl-images-amazon.com/images/I/71LxXaBCobL._AC_SL1200_.jpg"/>
       <Product id="423" title="new gamer accessories"
      price={665} rating={4}
      image="https://images-na.ssl-images-amazon.com/images/G/01/AmazonExports/Fuji/2019/July/amazonbasics_520x520._SY304_CB442725065_.jpg"/>
      </div>
      <div className="home__row">
      <Product id="41" title="Electronics at the sale of new items yet to be purchases"
      price={324} rating={2}
      image="https://images-na.ssl-images-amazon.com/images/I/51wL4BVh2YL._AC_US240_FMwebp_QL65_.jpg"/>
    <Product id="420" title="Monitor of the next gen is ready here at your doorstep "
      price={34344} rating={4}
      image="
      https://images-na.ssl-images-amazon.com/images/I/31PTviHMeUL._AC_US240_FMwebp_QL65_.jpg"/>
        <Product id="424" title="The latest Cable used for any type of connectivity"
      price={6466} rating={3}
      image="https://images-na.ssl-images-amazon.com/images/G/01/amazonglobal/images/email/asins/DURM-2447E617EC5C463L._V533746472_.jpg"/>
      </div>
    </div>
  );
}

export default Home
