import React, { useState } from 'react';
import axios from 'axios';

type ResponseData = {
  id: number;
  steamId: string;
  numberOfGames: number;
};

type FormProps = {
  onSubmit: (userId: string) => void;
  error: string | null;
};

const Form: React.FC<FormProps> = ({ onSubmit, error }) => {
  const [userId, setUserId] = useState('');

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    onSubmit(userId);
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          <input
          //field is empty then have the user enter a user ID
            placeholder="Enter your Steam ID"
            type="text"
            value={userId}
            onChange={(event) => setUserId(event.target.value)}
          />
        </label>
        <button className="btn" type="submit">Submit</button>
      </form>
      {error && <div>Error: {error}</div>}
    </div>
  );
};

export default Form;
