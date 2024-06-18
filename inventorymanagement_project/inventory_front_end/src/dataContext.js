import React, { createContext, useState } from 'react';

// Create a Context
export const DataContext = createContext();

// Create a provider component
export const MyProvider = ({ children }) => {

    const [users, setUsers] = useState([]);
    const [categories, setCategories] = useState([]);
    const [products, setProducts] = useState([]);
    // const[orders,setOrders]=useState([]);
    const[isLoggedIn,setIsLoggedIn]=useState(false);
  return (
    <DataContext.Provider value={{ users, setUsers, categories, setCategories, products, setProducts ,isLoggedIn,setIsLoggedIn}}>
      {children}
    </DataContext.Provider>
  );
};
