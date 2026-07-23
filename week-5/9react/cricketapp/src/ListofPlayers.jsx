import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Sachin', score: 66 },
    { name: 'Saurav', score: 88 },
    { name: 'Rahul', score: 55 },
    { name: 'Dhoni', score: 95 },
    { name: 'Virat', score: 45 },
    { name: 'Rohit', score: 75 },
    { name: 'Yuvraj', score: 65 },
    { name: 'Sehwag', score: 85 },
    { name: 'Zaheer', score: 20 },
    { name: 'Kumble', score: 10 },
    { name: 'Harbhajan', score: 15 }
  ];

  const below70 = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>Mr. {player.name} <span>{player.score}</span></li>
        ))}
      </ul>
      <hr />
      <h2>Players with Scores Below 70</h2>
      <ul>
        {below70.map((player, index) => (
          <li key={index}>Mr. {player.name} <span>{player.score}</span></li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
