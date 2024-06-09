import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import EmployeeForm from './components/Pinfo_form';


function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<EmployeeForm />} />
      </Routes>
    </Router>
  );
}

export default App;
