import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ cohortCode, status, startDate, endDate, trainerName }) => {
  const h3Style = {
    color: status === 'ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={h3Style}>{cohortCode}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{status}</dd>
        <dt>Start Date</dt>
        <dd>{startDate}</dd>
        <dt>End Date</dt>
        <dd>{endDate}</dd>
        <dt>Trainer</dt>
        <dd>{trainerName}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
