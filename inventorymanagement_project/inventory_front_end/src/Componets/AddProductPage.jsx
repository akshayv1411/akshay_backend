import React, { useContext, useState, useEffect } from 'react';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid';
import TableContainer from '@mui/material/TableContainer';
import Table from '@mui/material/Table';
import TableHead from '@mui/material/TableHead';
import TableBody from '@mui/material/TableBody';
import TableRow from '@mui/material/TableRow';
import TableCell from '@mui/material/TableCell';
import Paper from '@mui/material/Paper';
import axios from 'axios'
import { DataContext } from '../dataContext';
import { Container } from 'react-bootstrap';

const AddProductPage = () => {
  const { products, setProducts } = useContext(DataContext);
  const [product, setProduct] = useState('');
  const [category, setCategory] = useState('');
  const [productId, setProductId] = useState('');
  const [itemName, setItemName] = useState('');
  const [unitPrice, setUnitPrice] = useState('');
  const [quantityOnHand, setQuantityOnHand] = useState('');
  const [reorderPoint, setReorderPoint] = useState('');
  const [description, setDescription] = useState('');

  const clearFields = () => {
    setCategory('');
    setProductId('');
    setItemName('');
    setUnitPrice('');
    setQuantityOnHand('');
    setReorderPoint('');
    setDescription('');
  };

  useEffect(() => {
    getProducts();
  }, []);
  const getItem= (productId)=>{
  
   
    axios.get(`http://localhost:8080/api/v1/inventory/inventory/get?itemId=${productId}`)
    .then(response=>{
      const itemData=response.data.data
      setProducts(itemData?[itemData]:[]);
      clearFields();
    })
    .catch(error=>{
      console.log("error while fetching",error);
    })
  }

  const deleteProduct = (itemId) => {
    axios.delete('http://localhost:8080/api/v1/inventory/inventory/delete', { data: { itemId } })
      .then(response => {
        console.log(itemId);
        console.log('product deleted successfully', response);
        getProducts();
      })
      .catch(error => {
        console.log('error while deleting', error);
      });
  };

  const addProduct = (itemName, description, category, unitPrice, quantityOnHand, reorderPoint) => {
    if (!itemName || !description || !category || !unitPrice || !quantityOnHand || !reorderPoint) {
      alert("all fields required!!");
    } else {
      axios.post('http://localhost:8080/api/v1/inventory/inventory', { itemName, description, category, unitPrice, quantityOnHand, reorderPoint })
        .then(response => {
          console.log('data added successful', response);
          alert('product Added!!');
          clearFields();
          getProducts();
        })
        .catch(error => {
          console.log('error while adding', error);
        });
    }
  };

  const getProducts = () => {
    axios.get('http://localhost:8080/api/v1/inventory/inventory/getall')
      .then(response => {
        console.log('fetchingSuccess', response.data.data);
        setProducts(response.data.data || [])
      }).catch(error => {
        console.log('error fetching products', error);
      })
  };

  const selectProductToUpdate = (productId) => {
    const selectProduct = products.find(product => product.itemId === productId)
    setItemName(selectProduct.itemName);
    setCategory(selectProduct.category);
    setProductId(selectProduct.itemId);
    setDescription(selectProduct.description);
    setQuantityOnHand(selectProduct.quantityOnHand);
    setReorderPoint(selectProduct.reorderPoint);
    setUnitPrice(selectProduct.unitPrice);
    setProduct(selectProduct);
  };

  const updateProduct = () => {
    if (itemName && description && category && unitPrice && quantityOnHand && reorderPoint) {
      axios.put('http://localhost:8080/api/v1/inventory/inventory/put', { itemId: productId, itemName, description, category, unitPrice, quantityOnHand, reorderPoint })
        .then(response => {
          console.log('Product updated successfully', response);
          alert("product updated!!");
          getProducts();
          clearFields();
        })
        .catch(error => {
          console.log('Error occurred', error);
        })
    }
  };

  return (
    <div style={{ padding: '20px' }}>
      <Container fluid style={{ width: '100%', display: 'flex', padding: 0, margin: 0 }}>
        <img
          src="https://th.bing.com/th/id/OIP.JcUquSlrO_lTWrxesyW_JgHaEK?rs=1&pid=ImgDetMain"
          alt="img"
          style={{ width: '100%', height: '300px', objectFit: 'cover' }}
        />
      </Container>
      <Typography variant="h4" gutterBottom>
        Add Product
      </Typography>
      <Grid container spacing={2}>
        <Grid item xs={6}>
          <TextField label="Product Id" variant="outlined" fullWidth id="productId" value={productId} onChange={(e) => setProductId(e.target.value)} />
        </Grid>
        <Grid item xs={6}>
          <TextField label="Product Name" variant="outlined" fullWidth id="productName" value={itemName} onChange={(e) => setItemName(e.target.value)} />
        </Grid>
        <Grid item xs={6}>
          <TextField label="Category" variant="outlined" fullWidth id="category" value={category} onChange={(e) => setCategory(e.target.value)} />
        </Grid>
        <Grid item xs={6}>
          <TextField label="Price" variant="outlined" fullWidth id="price" value={unitPrice} onChange={(e) => setUnitPrice(e.target.value)} />
        </Grid>
        <Grid item xs={6}>
          <TextField label="Stock" variant="outlined" fullWidth id="stock" value={quantityOnHand} onChange={(e) => setQuantityOnHand(e.target.value)} />
        </Grid>
        <Grid item xs={6}>
          <TextField label="Reorder Point" variant="outlined" fullWidth id="reorderPoint" value={reorderPoint} onChange={(e) => setReorderPoint(e.target.value)} />
        </Grid>

        <Grid item xs={6}>
          <TextField label="Description" variant="outlined" fullWidth id="description" value={description} onChange={(e) => setDescription(e.target.value)} />
        </Grid>
        <Grid item xs={11}>
          <Button variant="contained" color="primary" sx={{ mr: 1 }} onClick={() => { addProduct(itemName, description, category, unitPrice, quantityOnHand, reorderPoint) }}>
            Add Product
          </Button>
          <Button variant="contained" color="primary" sx={{ mr: 1 }}  disabled={!product || !product.itemId} onClick={() => { updateProduct() }}>
            Update Product
          </Button>
          <Button variant="outlined" color="primary" sx={{ mr: 1 }}  onClick={() => {getItem(productId)}}>
            Search
          </Button>
        </Grid>
      </Grid>
      <div style={{ marginTop: '20px' }}>
        <Typography variant="h5" gutterBottom>
          Products
        </Typography>
        <TableContainer component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell align="center">Product ID</TableCell>
                <TableCell align="center">Product Name</TableCell>
                <TableCell align="center">Category</TableCell>
                <TableCell align="center">Price</TableCell>
                <TableCell align="center">Stock</TableCell>
                <TableCell align="center">Reorder Point</TableCell>
                <TableCell align="center">Description</TableCell>
                <TableCell align="center">Date</TableCell>
                <TableCell align="center">Actions</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {products?.map((product, index) => (
                <TableRow key={index}>
                  <TableCell align="center">{product.itemId}</TableCell>
                  <TableCell align="center">{product.itemName}</TableCell>
                  <TableCell align="center">{product.category}</TableCell>
                  <TableCell align="center">{product.unitPrice}</TableCell>
                  <TableCell align="center">{product.quantityOnHand}</TableCell>
                  <TableCell align="center">{product.reorderPoint}</TableCell>
                  <TableCell align="center">{product.description}</TableCell>
                  <TableCell align="center">{product.createdAt}</TableCell>
                  <TableCell align="center">
                    <Button variant="contained" sx={{ mr: 1 }} onClick={() => selectProductToUpdate(product.itemId)}>
                      Edit
                    </Button>
                    <Button variant="contained" color="error" onClick={() => deleteProduct(product.itemId)}>
                      Remove
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    </div>
  );
};

export default AddProductPage;
