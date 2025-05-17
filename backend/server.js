const express = require('express');
const Razorpay = require('razorpay');
const cors = require('cors');
const app = express();
app.use(cors());
app.use(express.json());
const express = require("express");
const path = require("path");


// Serve static frontend files
app.use(express.static(path.join(__dirname, "../frontend")));

app.get("*", (req, res) => {
  res.sendFile(path.join(__dirname, "../frontend/index.html"));
});


const razorpay = new Razorpay({
  key_id: 'rzp_test_UQTuNj7nbGHLLg',
  key_secret: 'WfCaU3ZW839Aj17jJPtgv464'
});

app.post('/create-order', async (req, res) => {
  const { amount } = req.body;

  const options = {
    amount: amount * 100, // convert to paise
    currency: 'INR',
    payment_capture: 1
  };

  try {
    const order = await razorpay.orders.create(options);
    res.json({ orderId: order.id });
  } catch (err) {
    res.status(500).send(err);
  }
});

app.listen(5000, () => console.log('Server running on http://localhost:5000'));
