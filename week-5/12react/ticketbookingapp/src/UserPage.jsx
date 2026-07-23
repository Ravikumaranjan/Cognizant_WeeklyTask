import React from 'react';

const UserPage = () => {
  return (
    <div style={{ padding: '20px', border: '1px solid #ccc', marginBottom: '20px' }}>
      <h2>Welcome User!</h2>
      <h3>Ticket Booking</h3>
      <p>You can now book your flight tickets here.</p>
      <button style={{ padding: '10px 20px', cursor: 'pointer' }}>Book a Ticket</button>
    </div>
  );
};

export default UserPage;
