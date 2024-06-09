import React, { useState, useEffect } from 'react';
import { Form, Button, Table, Container, Row, Col } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';

const EmployeeForm = () => {
  const [formData, setFormData] = useState({
    employeeId: "",
    employeeName: "",
    dateOfJoining: "",
    dateOfBirth: "",
    email: "",
    designation: "",
    gender: "",
    nationality: "",
    employeeStatus: ""
  });

  const [responseMessage, setResponseMessage] = useState('');
  const [submittedData, setSubmittedData] = useState(null);
  const [employeeData, setEmployeeData] = useState([]);

  useEffect(() => {
    // Fetch data from the API on component mount
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/getAllPrimaryInfo');
        const result = response.data;
        if (!result.error) {
          setEmployeeData(result.data);
        } else {
          setResponseMessage(`Error: ${result.message}`);
        }
      } catch (error) {
        setResponseMessage('Error: Unable to fetch data');
      }
    };

    fetchData();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/api/pinfo', formData);
      const result = response.data;
      if (result.error) {
        setResponseMessage(`Error: ${result.message}`);
      } else {
        setResponseMessage(`Success: ${result.message}`);
        setSubmittedData(formData);
        // Fetch updated data after submitting the form
        const updatedResponse = await axios.get('http://localhost:8080/api/getAllPrimaryInfo');
        setEmployeeData(updatedResponse.data.data);
      }
    } catch (error) {
      setResponseMessage('Error: Unable to submit form');
    }
  };

  return (
    <Container>
      <Row>
        <Col md={6}>
          <Form onSubmit={handleSubmit} style={{ backgroundColor: '#f2f2f2', padding: '20px', borderRadius: '8px' }}>
            <Form.Group controlId="employeeId">
              <Form.Label>Employee ID</Form.Label>
              <Form.Control
                type="text"
                name="employeeId"
                value={formData.employeeId}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="employeeName">
              <Form.Label>Employee Name</Form.Label>
              <Form.Control
                type="text"
                name="employeeName"
                value={formData.employeeName}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="dateOfJoining">
              <Form.Label>Date of Joining</Form.Label>
              <Form.Control
                type="date"
                name="dateOfJoining"
                value={formData.dateOfJoining}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="dateOfBirth">
              <Form.Label>Date of Birth</Form.Label>
              <Form.Control
                type="date"
                name="dateOfBirth"
                value={formData.dateOfBirth}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="email">
              <Form.Label>Email</Form.Label>
              <Form.Control
                type="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="designation">
              <Form.Label>Designation</Form.Label>
              <Form.Control
                type="text"
                name="designation"
                value={formData.designation}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="gender">
              <Form.Label>Gender</Form.Label>
              <Form.Control
                as="select"
                name="gender"
                value={formData.gender}
                onChange={handleChange}
              >
                <option value="">Select Gender</option>
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
                <option value="OTHER">Other</option>
              </Form.Control>
            </Form.Group>
            <Form.Group controlId="nationality">
              <Form.Label>Nationality</Form.Label>
              <Form.Control
                type="text"
                name="nationality"
                value={formData.nationality}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group controlId="employeeStatus">
              <Form.Label>Employee Status</Form.Label>
              <Form.Control
                as="select"
                name="employeeStatus"
                value={formData.employeeStatus}
                onChange={handleChange}
              >
                <option value="">Select Status</option>
                <option value="ACTIVE">Active</option>
                <option value="INACTIVE">Inactive</option>
              </Form.Control>
            </Form.Group>
            <Button variant="primary" type="submit" style={{ marginTop: '10px' }}>
              Submit
            </Button>
            {responseMessage && <p style={{ marginTop: '10px' }}>{responseMessage}</p>}
          </Form>
        </Col>
        <Col md={6}>
          <Table striped bordered hover style={{ marginTop: '20px' }}>
            <thead>
              <tr>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Date of Joining</th>
                <th>Date of Birth</th>
                <th>Email</th>
                <th>Designation</th>
                <th>Gender</th>
                <th>Nationality</th>
                <th>Employee Status</th>
              </tr>
            </thead>
            <tbody>
              {employeeData.map((employee, index) => (
                <tr key={index}>
                  <td>{employee.employeeId}</td>
                  <td>{employee.employeeName}</td>
                  <td>{employee.dateOfJoining}</td>
                  <td>{employee.dateOfBirth}</td>
                  <td>{employee.email}</td>
                  <td>{employee.designation}</td>
                  <td>{employee.gender}</td>
                  <td>{employee.nationality}</td>
                  <td>{employee.employeeStatus}</td>
                </tr>
              ))}
            </tbody>
          </Table>
        </Col>
      </Row>
    </Container>
  );
};

export default EmployeeForm;
