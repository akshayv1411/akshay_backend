import React, { useState,useEffect} from 'react';
import './AddCategories.css';
import './NavBar1';
import { Typography, Button, Box, TableHead } from '@mui/material';
import TextField from '@mui/material/TextField';

import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import axios from 'axios'

function AddCategories() {
 const[orderItems,setOrderItems]=useState([])
 const[orderItemId,setOrderItemId]=useState('');
  const [quantity, setQuqntity] = useState('');
  const [unitPrice, setUnitPrice] = useState('');
  const [itemId, setItemId] = useState('');
  const [orderId, setOrderId] = useState('');

  useEffect(()=>{
    getOrderItems();
    },[])
 const addItemslist=(quantity,unitPrice,orderId,itemId)=>{
  axios.post('http://localhost:8080/api/v1/inventory/purchaseItems',{orderId,itemId,orderItems:[{quantity,unitPrice}]})
  .then(response=>{
    console.log('inventoryItems added successfull',response);
    getOrderItems();
    clearFields();
  }).catch(error=>{
    console.log('error while adding data',error);
  })
 }

 const getOrderItems=()=>{
  axios.get('http://localhost:8080/api/v1/inventory/purchaseItems/getall')
  .then(response=>{
    console.log('fetching items ordes',response.data.data);
    setOrderItems(response.data.data);
  })
 }
const clearFields=()=>{
  setItemId('')
  setOrderId('');
  setQuqntity('');
  setUnitPrice('');
}
 const orderToUpdate=(orderItemId)=>{

  const selectedOrder=orderItems.find(order=>order.orderItemId===orderItemId);
  setQuqntity(selectedOrder.quantity);
  setUnitPrice(selectedOrder.unitPrice);
  setOrderItemId(selectedOrder.orderItemId);
 
 }
  const orderItemUpdate=()=>{
    console.log(orderItemId,quantity,unitPrice);
    axios.put('http://localhost:8080/api/v1/inventory/purchaseItems/put',{orderItemId,quantity,unitPrice})
    .then(response=>{
      console.log('updated success',response);
      clearFields();
      getOrderItems();
      alert('updated successful')
    }).catch(error=>{
      console.log(error);
    })
  }


  return (
    <div>
      <img
        src="https://th.bing.com/th/id/OIP.YDcDFTtsiXrWfgr1FHv6yAHaEA?pid=ImgDet&w=208&h=112&c=7&dpr=1.5"
        alt="Sample"
        style={{ width: '100%', height: '300px' }}
      />
      <Box>
       
        <TextField
          id="quantity"
          label="Quantity"
          variant="outlined"
          value={quantity} onChange={(e) => setQuqntity(e.target.value)}
          sx={{ '& > :not(style)': { m: 2, width: '25ch' } }}
        />
        <TextField
          id="unitPrice"
          label="Unit Price"
          variant="outlined"
          value={unitPrice} onChange={(e) => setUnitPrice(e.target.value)}
          sx={{ '& > :not(style)': { m: 2, width: '25ch' } }}
        />
         <TextField
          id="orderId"
          label="OrderID"
          variant="outlined"
          value={orderId} onChange={(e) => setOrderId(e.target.value)}
          sx={{ '& > :not(style)': { m: 2, width: '25ch' } }}
        />
         <TextField
          id="itemId"
          label="ItemID"
          variant="outlined"
          value={itemId} onChange={(e) => setItemId(e.target.value)}
          sx={{ '& > :not(style)': { m: 2, width: '25ch' } }}
        />
        <Box>
          <Button variant="contained" sx={{ m: 1 }} onClick={()=>{addItemslist(quantity,unitPrice,orderId,itemId)}}>
            Add
          </Button>
          <Button
            variant="contained"
            disabled={quantity? false : true}
            sx={{ m: 1, '&:hover': { backgroundColor: '#64b5f6' } }} onClick={()=>{orderItemUpdate()}}
           
          >
            Update
          </Button>
          
        </Box>
      </Box>
      <Box>
        <Typography variant="h5" component="div" textAlign={'center'}>
          Inventory Items
        </Typography>
        <TableContainer component={Paper}>
          <Table aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Order Items ID</TableCell>
                <TableCell>Quantity</TableCell>
                <TableCell>₹ Unit Price</TableCell>
                <TableCell>ProductName</TableCell>
                <TableCell>PurchaseOrderId</TableCell>
                <TableCell>Action</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {orderItems?.map((itemOrder, index) => (
                <TableRow key={index}>
                  <TableCell>{index+1}</TableCell>
                  <TableCell>{itemOrder.quantity}</TableCell>
                  <TableCell>{itemOrder.unitPrice}</TableCell>
                  <TableCell>{itemOrder.itemName}</TableCell>
                  <TableCell>{itemOrder.orderId}</TableCell>
                  <TableCell>
                  <Button variant="contained" sx={{ mr: 1 }} onClick={()=>{orderToUpdate(itemOrder.orderItemId)}}>
                    Edit
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Box>
    </div>
  );
}

export default AddCategories;
