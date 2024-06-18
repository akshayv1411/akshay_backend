import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Typography from '@mui/material/Typography';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import ShoppingBasketIcon from '@mui/icons-material/ShoppingBasket';
import LocalMallIcon from '@mui/icons-material/LocalMall';
import ReceiptIcon from '@mui/icons-material/Receipt'; 
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useState, useEffect } from 'react';
import Grid from '@mui/material/Grid';
import TextField from '@mui/material/TextField';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import Button from '@mui/material/Button';
import axios from 'axios'
import { Link } from 'react-router-dom';
export default function Dashboardn() {


  const [orders, setOrders ] = useState([]);
  // const [orderId, setOrderId] = useState('');
  const [supplier, setSupplier] = useState('');
  // const [orderDate, setOrderDate] = useState('');
  const [status, setStatus] = useState('');
  const [email, setEmail] = useState('');
  const [order, setOrder] = useState('');
  // const { users, setUsers } = useState([]);
  const getOrderToupdate=(orderId)=>{
    const selectedorder = orders.find(order => order.orderId === orderId);
    setSupplier(selectedorder.supplier);
    setStatus(selectedorder.status);
    // setOrder(selectedorder);
  };
    const UpdateOrder=()=>{
      console.log(status,supplier,order.orderId);
      if(supplier && status){

        axios.put('http://localhost:8080/api/v1/inventory/orderlist/put',{orderId:order.orderId,supplier,status})
        .then(response=>{
          console.log('updated order',response);
          getOrders();
          clearFields();
        }).catch(error=>{
          console.log('error while updating',error);
        })
      }
    }

  
  const clearFields=()=>{
     setSupplier('')
     setStatus('')
     setEmail('')
  }
  useEffect(()=>{
  getOrders();
  },[])
  const getOrders=()=>{
    axios.get('http://localhost:8080/api/v1/inventory/orderlist/getall')
    .then(response=>{
      console.log('fetchihng',response);
      setOrders(response.data.data)
    })
    .catch(error=>{
      console.log('error while fetching',error);
    })
  }
  
  const addOrder=(supplier,status,email)=>{
    axios.post('http://localhost:8080/api/v1/inventory/orderlist',{email,orders:[{supplier,status}]})
    .then(response=>{
      console.log('data added success',response);
     clearFields();
     getOrders();
    })
    .catch(error=>{
      console.log('error while adding data',error);
    })
  }
  const deleteOrder=(orderId)=>{
    console.log(orderId);
    axios.delete('http://localhost:8080/api/v1/inventory/orderlist/delete',{data:{orderId}})
    .then(response=>{
      console.log('deleted success',response);
      alert("deleted success!!")
      getOrders();
    }).catch(error=>{
      console.log('error while deleting',error);
      alert("orderId not found !!")
    })
  }

  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Box
          sx={{
            display: 'flex',
            justifyContent: 'space-evenly',
            flexWrap: 'wrap',
          }}
        >
          <Box>
          <Link to={"/dashboard"}>
            <Card sx={{ display: 'inline-block', minWidth: 200, minHeight: 200, mb: 2 }}>
              <CardContent>
                <ShoppingBasketIcon sx={{ fontSize: 48 }} />
                <Typography variant="h5" component="div">
                  All Orders
                </Typography>
              </CardContent>
            </Card>
            </Link>
          </Box>
          <Box>
            <Link to={"/adduser"}>
            <Card sx={{ display: 'inline-block', minWidth: 200, minHeight: 200, mb: 2 }}>
              <CardContent>
                <AccountCircleIcon sx={{ fontSize: 48 }} />
                <Typography variant="h5" component="div">
                  All Users
                </Typography>
              </CardContent>
            </Card>
            </Link>
          </Box>
          <Box>
            <Link to={"/addproducts"}>
            <Card sx={{ display: 'inline-block', minWidth: 200, minHeight: 200, mb: 2 }}>
              <CardContent>
                <LocalMallIcon sx={{ fontSize: 48 }} />
                <Typography variant="h5" component="div">
                  All Products
                </Typography>
              </CardContent>
            </Card>
            </Link>
          </Box>
          <Box>
            <Link to={"/addcategories"}>
            <Card sx={{ display: 'inline-block', minWidth: 200, minHeight: 200, mb: 2 }}>
              <CardContent>
                <ReceiptIcon sx={{ fontSize: 48 }} />
                <Typography variant="h5" component="div">
                  All PurchaseOrderItems
                </Typography>
              </CardContent>
            </Card>
            </Link>
          </Box>
        </Box>
        <Grid container spacing={2} alignItems="center">
          <Grid item xs={12} sm={4}>
            <TextField label="Supplier" variant="outlined" fullWidth id="supplier" value={supplier} onChange={(e) => setSupplier(e.target.value)} />
          </Grid>
          <Grid item xs={12} sm={4}>
            <Select label="Status" value={status} onChange={(e) => setStatus(e.target.value)} variant="outlined" fullWidth>
              <MenuItem value="Active">Active</MenuItem>
              <MenuItem value="Closed">Closed</MenuItem>
            </Select>
          </Grid>
          <Grid item xs={12} sm={4}>
            <TextField label="Email" variant="outlined" fullWidth id="email" value={email} onChange={(e) => setEmail(e.target.value)} />
          </Grid>
          <Grid item xs={12} sm={4}>
            <Button variant="contained" color="primary" size="small" sx={{ mr: 1 }}  onClick={()=>{addOrder(supplier,status,email)}}>
              Add Order
            </Button>
            <Button variant="contained" color="primary" size="small" onClick={()=>{UpdateOrder()}} disabled={!supplier||!status}>
              Update
            </Button>
          </Grid>
        </Grid>
        <Typography variant="h5" component="div" sx={{ mt: 4, textAlign: 'center' }}>
          Purchase Order's
        </Typography>
        <TableContainer component={Paper} sx={{ mt: 2 }}>
          <Table aria-label="simple table">
            <TableBody>
              <TableRow>
                <TableCell>OrderId</TableCell>
                <TableCell>OrderDate</TableCell>
                <TableCell>Supplier</TableCell>
                <TableCell>Status</TableCell>
                <TableCell>Date</TableCell>
                <TableCell>UserId</TableCell>
                <TableCell>Action</TableCell>
              </TableRow>
              {orders?.map((order, index) => (
                    <TableRow key={index}>
                      <TableCell>{index + 1}</TableCell>
                      <TableCell>{order.orderDate}</TableCell>
                      <TableCell>{order.supplier}</TableCell>
                      <TableCell>{order.status}</TableCell>
                      <TableCell>{order.createdAt}</TableCell>
                      <TableCell>{order.email}</TableCell>
                      
                      <TableCell>
                        <Button variant="contained" sx={{ mr: 1 }} onClick={()=>{getOrderToupdate(order.orderId)}}>Update</Button>
                        <Button variant="contained" color="error" onClick={()=>{deleteOrder(order.orderId)}}>Delete</Button>
                      </TableCell>
                    </TableRow>
                  ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    </Box>
  );
}
