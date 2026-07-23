import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleChange = (e) => {
    setRupees(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const amountInRupees = parseFloat(rupees);
    if (!isNaN(amountInRupees)) {
      // Assume 1 Euro = 90 INR
      setEuros((amountInRupees / 90).toFixed(2));
    }
  };

  return (
    <div style={{ marginTop: '20px', border: '1px solid #ccc', padding: '15px' }}>
      <h2>Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label htmlFor="inr">Indian Rupees (INR): </label>
          <input 
            type="number" 
            id="inr" 
            value={rupees} 
            onChange={handleChange} 
            placeholder="Enter amount in INR"
          />
        </div>
        <button type="submit">Convert</button>
      </form>
      
      {euros !== null && (
        <p style={{ marginTop: '15px', fontWeight: 'bold', color: 'green' }}>
          Equivalent in Euro: € {euros}
        </p>
      )}
    </div>
  );
};

export default CurrencyConvertor;
