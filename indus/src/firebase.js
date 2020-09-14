import firebase from "firebase";


const firebaseApp= firebase.initializeApp({  
        apiKey: "AIzaSyAAqTsXS7_Gk27MrXran8ClWM92L39Ky-w",
        authDomain: "indus-613de.firebaseapp.com",
        databaseURL: "https://indus-613de.firebaseio.com",
        projectId: "indus-613de",
        storageBucket: "indus-613de.appspot.com",
        messagingSenderId: "690892716778",
        appId: "1:690892716778:web:54864cc5aea9c3f95e3593",
        measurementId: "G-8T71BTDDXC"
      
});

const db= firebaseApp.firestore();
const auth=firebase.auth();

export {db,auth};