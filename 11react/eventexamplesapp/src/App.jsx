import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
import './App.css';

function App() {
  // Counter state for Task 1
  const [counter, setCounter] = useState(0);

  // Method 1 for Increment button
  const incrementValue = () => {
    setCounter(prev => prev + 1);
  };

  // Method 2 for Increment button
  const sayHello = () => {
    alert("Hello, this is a static message!");
  };

  // Handler for Increment that invokes multiple methods
  const handleIncrement = () => {
    incrementValue();
    sayHello();
  };

  // Handler for Decrement
  const handleDecrement = () => {
    setCounter(prev => prev - 1);
  };

  // Handler for Say Welcome button
  const sayWelcome = (msg) => {
    alert(msg); // Will display "welcome"
  };

  // Handler for synthetic event
  const handleOnPress = (event) => {
    alert("I was clicked");
    console.log("Synthetic event triggered:", event);
  };

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h1>React Events Example App</h1>

      {/* 1. Increment and Decrement */}
      <div style={{ marginBottom: '20px', padding: '15px', border: '1px solid #ccc' }}>
        <h2>Counter Example</h2>
        <h3>Value: {counter}</h3>
        <button onClick={handleIncrement} style={{ marginRight: '10px' }}>
          Increment
        </button>
        <button onClick={handleDecrement}>
          Decrement
        </button>
      </div>

      {/* 2. Say Welcome */}
      <div style={{ marginBottom: '20px', padding: '15px', border: '1px solid #ccc' }}>
        <h2>Passing Arguments</h2>
        <button onClick={() => sayWelcome("welcome")}>
          Say Welcome
        </button>
      </div>

      {/* 3. Synthetic Event */}
      <div style={{ marginBottom: '20px', padding: '15px', border: '1px solid #ccc' }}>
        <h2>Synthetic Event</h2>
        {/* We use onClick which is a React synthetic event. We label the button "OnPress" as requested. */}
        <button onClick={handleOnPress}>
          OnPress
        </button>
      </div>

      {/* 4. Currency Convertor Component */}
      <CurrencyConvertor />
    </div>
  );
}

export default App;
