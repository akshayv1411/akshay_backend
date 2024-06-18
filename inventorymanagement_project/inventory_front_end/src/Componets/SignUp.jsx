import React, { useState } from 'react';
import { Col, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './Register.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const SignUp = () => {
  const navigate = useNavigate();

  const registerUser = (email, password, adminame) => {
    axios.post("http://localhost:8080/api/v1/inventory/admin", { email, password, adminame})
      .then(response => {
        console.log('Registration successful:', response);
        alert('Registration Success!!')
        clearFields();
        navigate('/'); 
      })
      .catch(error => {
        alert('Registration failed!!')
        console.error('There was an error registering the admin:', error);
      });
  };

  const [adminame, setAdminame] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [validated, setValidated] = useState(false);

  const handleRegistration = (e) => {
    e.preventDefault();
    const form = e.currentTarget;

    if (form.checkValidity() === false) {
      e.stopPropagation();
    } else {
  
      if (!validateEmail(email)) {
        alert('Please enter a valid email address.');
        return;
      }
      
      registerUser(email, password, adminame);
    }
    
    setValidated(true);
  };

  const validateEmail = (email) => {
    const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return re.test(String(email).toLowerCase());
  };
  
  const clearFields = () => {
    setAdminame('');
    setEmail('');
    setPassword('');
  };

  return (
    <div className="center-container">
      <div className="registration-background"></div>
      <div className="registration-container">
        <div className="form-container">
          <h2>Sign Up</h2>
          <Form noValidate validated={validated} onSubmit={handleRegistration}>
            <Form.Group controlId="name">
              <Form.Label>Name:</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Name"
                value={adminame}
                onChange={(e) => setAdminame(e.target.value)}
                required
              />
              <Form.Control.Feedback type="invalid">Please enter your name.</Form.Control.Feedback>
            </Form.Group>

            <Form.Group controlId="formBasicEmail">
              <Form.Label>Email address</Form.Label>
              <Form.Control
                type="email"
                placeholder="Enter email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
              <Form.Control.Feedback type="invalid">Please enter a valid email.</Form.Control.Feedback>
              <Form.Text className="text-muted">We'll never share your password with anyone else.</Form.Text>
            </Form.Group>

            <Form.Group controlId="password">
              <Form.Label>Create Password:</Form.Label>
              <Form.Control
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                pattern="(?=.*\d)(?=.*[A-Z]).{8}"
                title="Password must be 8 characters long and include at least one uppercase letter and one numerical digit"
                required
              />
              <Form.Control.Feedback type="invalid">
                Password must be 8 characters long and include at least one uppercase letter and one numerical digit.
              </Form.Control.Feedback>
            </Form.Group>

            <Form.Group as={Col} className="mb-3">
              <Button variant="primary" type="submit">
                Register
              </Button>
            </Form.Group>
          </Form>
        </div>
      </div>
    </div>
  );
};

export default SignUp;
