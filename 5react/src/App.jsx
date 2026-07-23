import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div>
      <CohortDetails 
        cohortCode="C101: React Bootcamp" 
        status="ongoing" 
        startDate="10-Jan-2023" 
        endDate="30-Mar-2023" 
        trainerName="John Doe"
      />
      <CohortDetails 
        cohortCode="C102: Full Stack Java" 
        status="completed" 
        startDate="15-Aug-2022" 
        endDate="15-Dec-2022" 
        trainerName="Jane Smith"
      />
    </div>
  );
}

export default App;
