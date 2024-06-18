import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddUsers1 from './Componets/AddUsers1'
import AddCategories from './Componets/AddCategories';
import Dashboardn from './Componets/Dashboard'
import NavBar1 from './Componets/NavBar1';
import SignUp from './Componets/SignUp';
import Login from './Componets/Login'
import AddProductPage from './Componets/AddProductPage';

function App() {

  let [isLoggedIn, setIsLoggedIn] = useState(false);

  React.useEffect(() => {
    if (localStorage.getItem('isLoggedIn')) {
      setIsLoggedIn(true);
    }
  },[])

  const handleLogin = () => {
  
    setIsLoggedIn(true);
  
  }
   const handleLogout = () => {
    setIsLoggedIn(false);
    localStorage.removeItem('isLoggedIn');
  }



  return (
    <div className="App">
 
       <Router>
          {(isLoggedIn === true) ? <NavBar1 onLogout={handleLogout} /> : null}
              <div className="wrapper" style={{ marginLeft: isLoggedIn ? '50px': '0px'}}>
                <Routes>
                  <Route exact path="/adduser" element={<AddUsers1 />} />
                  <Route exact path="/addcategories" element={<AddCategories/>} />
                  <Route exact path="/dashboard" element={<Dashboardn />} />
                  <Route exact path="/register" element={<SignUp />} />
                  <Route exact path="/" element={<Login onLogin={handleLogin} />} />
                  <Route exact path="/logout" element={<Login onLogin={handleLogin} />} />
                  <Route exact path="/Signup" element={<SignUp />} />
                  <Route exact path="/addproducts" element={<AddProductPage />} />

                </Routes>
              </div>
          </Router>

    </div>
  );
}

export default App;