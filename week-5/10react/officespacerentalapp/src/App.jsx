import React from 'react';
import './App.css';

function App() {
  // Create a list of Objects (office spaces)
  const offices = [
    { id: 1, Name: "DBS Workspace", Rent: 50000, Address: "Chennai" },
    { id: 2, Name: "Omni Space", Rent: 75000, Address: "Bangalore" },
    { id: 3, Name: "CoWork Pro", Rent: 45000, Address: "Pune" },
    { id: 4, Name: "Elite Offices", Rent: 85000, Address: "Mumbai" },
  ];

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      {/* Element to display the heading of the page */}
      <h1>Office Space, at Affordable Range</h1>
      
      {/* Attribute to display the image of the office space */}
      <img 
        src="https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=600&q=80" 
        alt="Office Space" 
        style={{ borderRadius: '10px', width: '100%', maxWidth: '600px', height: 'auto', marginBottom: '20px' }}
      />
      
      <h2>Available Offices</h2>
      
      {/* Loop through the office space item to display more data */}
      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '20px' }}>
        {offices.map((office) => (
          <div key={office.id} style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px', width: '250px' }}>
            {/* Display details like Name, Rent and Address */}
            <h3>{office.Name}</h3>
            <p><strong>Address:</strong> {office.Address}</p>
            
            {/* Apply CSS: color of Rent in Red if < 60000, Green if >= 60000 */}
            <p>
              <strong>Rent:</strong>{' '}
              <span style={{ color: office.Rent < 60000 ? 'red' : 'green', fontWeight: 'bold' }}>
                ₹{office.Rent}
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
