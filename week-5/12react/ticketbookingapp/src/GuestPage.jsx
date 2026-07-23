import React from 'react';

const GuestPage = () => {
  return (
    <div style={{ padding: '20px', border: '1px solid #ccc', marginBottom: '20px' }}>
      <h2>Welcome Guest!</h2>
      <h3>Available Flights:</h3>
      <ul>
        <li>Flight 101 - New York to London</li>
        <li>Flight 202 - Paris to Tokyo</li>
        <li>Flight 303 - Dubai to Mumbai</li>
      </ul>
      <p><em>Please log in to book tickets.</em></p>
    </div>
  );
};

export default GuestPage;
