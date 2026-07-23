import React from 'react';

const IndianPlayers = () => {
  const indianPlayers = ['Sachin', 'Dhoni', 'Virat', 'Rohit', 'Yuvraj', 'Raina'];
  
  // Destructuring array to get players
  const [first, second, third, fourth, fifth, sixth] = indianPlayers;

  const T20Players = ['Hardik', 'Bumrah', 'Surya'];
  const RanjiTrophyPlayers = ['Pujara', 'Rahane', 'Ashwin'];
  
  // Merge feature of ES6 (Spread operator)
  const mergedPlayers = [...T20Players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd and Even Team Players (using Destructuring)</h2>
      <div>
        <h3>Odd Players</h3>
        <ul>
          <li>{first}</li>
          <li>{third}</li>
          <li>{fifth}</li>
        </ul>
        <h3>Even Players</h3>
        <ul>
          <li>{second}</li>
          <li>{fourth}</li>
          <li>{sixth}</li>
        </ul>
      </div>
      <hr />
      <h2>Merged Team Players (using Spread Operator)</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
