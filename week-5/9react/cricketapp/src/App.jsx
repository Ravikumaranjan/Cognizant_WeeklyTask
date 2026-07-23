import React, { useState } from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';
import './App.css';

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div className="App">
      <h1>Cricket App</h1>
      <div style={{ marginBottom: '20px' }}>
        <button onClick={() => setFlag(!flag)}>
          Toggle Flag (Current: {flag.toString()})
        </button>
      </div>
      
      <hr />
      
      {flag ? (
        <ListofPlayers />
      ) : (
        <IndianPlayers />
      )}
    </div>
  );
}

export default App;
