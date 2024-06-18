import React, { useContext, useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import { DataContext } from '../dataContext';
import axios from 'axios';
import { Container } from 'react-bootstrap';

export default function MiniDrawer() {
  const { users, setUsers } = useContext(DataContext);
  const [username, setUsername] = useState('');
  const [user , setUser] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    getUsers();
  }, []);
  const getUser = () => {
    axios.post(`http://localhost:8080/api/v1/inventory/user/get?email=${email}`)
      .then(response => {
       const userData=(response.data.data);
        setUsers(userData?[userData]:[]);
        clearFields();
      })
      .catch(error => {
        console.error('Error occurred', error);
        alert('Error occurred while fetching user');

      });
  }
   const findUserToUpdate =(email) =>{
    const userData = users.find(user=>user.email===email)
    setEmail(userData.email)
    setUsername(userData.username)
    setUser(userData)
   }
   const updateUser =()=>{
    if(!username||!email){
      alert('email id and password not present')
    }
    else{
    axios.put("http://localhost:8080/api/v1/inventory/user/put",{email,username})
    .then(response=>{
     console.log('Update User',response)
     getUsers();
     clearFields();
    }).catch(error=>{
      console.log('error')
    })

   }
  }
  const AddUser = () => {
    setIsLoading(true);


    if (!username || !email) {
      alert("Please fill in both username and email fields.");
      setIsLoading(false);
      return;
    }

 
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
      alert("Please enter a valid email address.");
      setIsLoading(false);
      return;
    }

   
    axios.post("http://localhost:8080/api/v1/inventory/user/register", { username, password, email })
      .then(response => {
        console.log('User added successfully', response);
        alert('User Added!!')
        clearFields();
        getUsers();
      })
      .catch(error => {
        console.log('Error occurred', error);
        alert('Error occurred while adding user');
      })
      .finally(() => {
        setIsLoading(false);
      });
  };

  const getUsers = () => {
    axios.get('http://localhost:8080/api/v1/inventory/user/getall')
      .then(response => {
        setUsers(response.data.data || []);
        console.log('Users fetched successfully', response.data.data);
      })
      .catch(errors => {
        console.log('Fetching error', errors);
      });
  };

  const deleteUser = (email) => {
    setIsLoading(true);
    axios.delete('http://localhost:8080/api/v1/inventory/user/delete', { data: { email } })
      .then(response => {
        console.log('User deleted successfully', response);
        alert('User deleted successfully')
        getUsers();
      })
      .catch(error => {
        console.log('Error occurred', error);
        alert('Error occurred while deleting user');
      })
      .finally(() => {
        setIsLoading(false);
      });
  };

  const clearFields = () => {
    setUsername('');
    setEmail('');
    setPassword('');
  };

  return (
    <>
      <br />
      <Container fluid style={{ width: '100%', display: 'flex', padding: 0, margin: 0 }}>
        <img
          src="https://th.bing.com/th/id/OIP.5fHbNsscCAXHjMlCWGS1agHaEK?w=320&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7"
          alt="img"
          style={{ width: '100%', height: '300px', objectFit: 'cover' }}
        />
      </Container>

      <Box sx={{ display: 'flex' }}>
        <CssBaseline />
        <Box component="main" sx={{ flexGrow: 1, p: 1, marginTop: 1 }}>
          <Grid item xs={12} md={8}>
          </Grid>
          <Grid container spacing={2}>
            <Grid item xs={2}>
              <TextField label="Username" fullWidth value={username} onChange={(e) => setUsername(e.target.value)} />
            </Grid>
            <Grid item xs={2}>
              <TextField label="Email" fullWidth value={email} onChange={(e) => setEmail(e.target.value)} />
            </Grid>

            <Grid item xs={12}>
              <Button variant="contained" sx={{ mr: 1 }} onClick={AddUser}> Add</Button>
              <Button variant="contained" sx={{ mr: 1 }} disabled={!username||!email}onClick={updateUser}>Update </Button>
              <Button variant="outlined" sx={{ mr: 1 }} onClick={getUser}> Search</Button>
            </Grid>
            <Grid item xs={12}>
              <Typography variant="h6" gutterBottom component="div">
                All Users Data
              </Typography>
              <Table>
                <TableHead>
                  <TableRow>
                    <TableCell>ID</TableCell>
                    <TableCell>Username</TableCell>
                    <TableCell>Email</TableCell>
                    <TableCell>Date</TableCell>
                    <TableCell>Action</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                {users?.map((user, index) => (
                    <TableRow key={index}>
                      <TableCell>{index + 1}</TableCell>
                      <TableCell>{user.username}</TableCell>
                      <TableCell>{user.email}</TableCell>
                      <TableCell>{user.createdAt}</TableCell>
                      <TableCell>
                      <Button variant="contained"  sx={{ mr: 1 }} color="primary" onClick={() =>findUserToUpdate(user.email)} disabled={isLoading}>Edit</Button>
                        <Button variant="contained" color="error" onClick={() => deleteUser(user.email)} disabled={isLoading}>Delete</Button>
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </Grid>
          </Grid>
        </Box>
      </Box>
    </>
  );
}
