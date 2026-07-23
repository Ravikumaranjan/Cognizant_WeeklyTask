import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';
import './App.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Using an Element Variable for conditional rendering
  let pageContent;

  if (isLoggedIn) {
    pageContent = (
      <div>
        <UserPage />
        <button onClick={() => setIsLoggedIn(false)} style={{ padding: '10px 20px', cursor: 'pointer', backgroundColor: '#f44336', color: 'white', border: 'none', borderRadius: '4px' }}>
          Logout
        </button>
      </div>
    );
  } else {
    pageContent = (
      <div>
        <GuestPage />
        <button onClick={() => setIsLoggedIn(true)} style={{ padding: '10px 20px', cursor: 'pointer', backgroundColor: '#4CAF50', color: 'white', border: 'none', borderRadius: '4px' }}>
          Login
        </button>
      </div>
    );
  }

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1>Ticket Booking App</h1>
      <hr style={{ marginBottom: '20px' }} />
      
      {/* Rendering the element variable */}
      {pageContent}
    </div>
  );
}

export default App;
