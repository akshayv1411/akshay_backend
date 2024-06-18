import React, { useState, useContext } from 'react';
import { Avatar, FormControlLabel, Grid, Paper, TextField, Checkbox, Button, Typography } from "@mui/material";
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import { Link } from 'react-router-dom';
import backgroundImage from './image1.jpg';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { DataContext } from '../dataContext';


const Login = ({ onLogin }) => {
  const navigate = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errors, setErrors] = useState('');
  const { setIsLoggedIn } = useContext(DataContext);

  const handleLogin = (email, password ) => {
 
    if (!email || !password) {
      setErrors("Please fill in both email and password fields.");
      
    } else {
      axios.post("http://localhost:8080/api/v1/inventory/admin/login",{email, password} )
        .then(response => {
          console.log('loginSuccess',response);
          if (response.data.data==="email and password matches!!") {
            alert('Login Success')
            console.log('login successful', response);
            localStorage.setItem('isLoggedIn', true);
            setIsLoggedIn(true); 
            onLogin();
            navigate('/dashboard');
            clearFields();
          } else{
            setErrors("Invalid email or password. Please try again.");
          }
        })
        .catch(error => {
          console.error('login failed', error);
          setErrors("An error occurred. Please try again later.");
          alert("An error occurred. Please try again later.");
        });
    }
  };

  const clearFields = () => {
    setEmail('');
    setPassword('');
  };

  const paperStyle = {
    padding: 20,
    height: 'auto',
    width: 280,
    margin: "20px auto",
  };

  const avatarStyle = { backgroundColor: 'green' };

  const textFieldStyle = {
    marginBottom: '10px',
  };

  const gridStyle = {
    minHeight: '100vh',
    backgroundImage: `url(${backgroundImage})`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
  };

  return (
    <Grid container style={gridStyle}>
      <Paper elevation={10} style={paperStyle}>
        <Grid align='center'>
          <Avatar style={avatarStyle}><LockOutlinedIcon /></Avatar>
          <h2>Sign in</h2>
        </Grid>
        <Grid container direction="column" spacing={2} alignItems="center">
          <Grid item xs={12}>
            <TextField label="Email" placeholder="Enter Email"
              type='email'
              value={email}
              fullWidth required style={textFieldStyle} onChange={(e) => setEmail(e.target.value)} />
          </Grid>
          <Grid item xs={12}>
            <TextField label="Password" placeholder="Enter Password" type="password"
              value={password} fullWidth required onChange={(e) => setPassword(e.target.value)} />
          </Grid>
          <Grid item xs={12}>
            <FormControlLabel
              control={<Checkbox name="checkedB" color="primary" />}
              label="Remember me"
            />
          </Grid>
          <Grid item xs={12}>
            <Button type="submit" variant="contained" color="primary" fullWidth style={{ color: "black", textDecoration: "none" }} onClick={() => handleLogin(email, password )}>
              Sign In
            </Button>
          </Grid>
          <Grid item xs={12}>
            {/* <Typography>
              <Link href="#" variant="body2">Forgot Password?</Link>
            </Typography> */}
            <Typography>
              <Link to={"/signup"} variant="body2">Don't have an account? Sign up</Link>
            </Typography>
          </Grid>
        </Grid>
        {errors && (
          <Typography style={{ color: "red", textAlign: "center" }}>
            {errors}
          </Typography>
        )}
      </Paper>
    </Grid>
  );
};

export default Login;
