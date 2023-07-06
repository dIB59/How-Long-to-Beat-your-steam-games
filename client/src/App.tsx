import React, { useState } from 'react';
import axios from 'axios';
import './App.css';
import { UserGames } from './component/UserGames';

type ResponseData = {
  id: number;
  steamId: string;
  numberOfGames: number;
};

function App() {

  const [userId, setUserId] = useState('');
  const [responseData, setResponseData] = useState<ResponseData | null>(null);
  const [error, setError] = useState(null);

  const handleSubmit = (event: { preventDefault: () => void; }) => {
    event.preventDefault();

    // Make the POST request using Axios
    axios
      .post('http://localhost:8080/api/users', { userId: userId })
      .then((response) => {
        console.log('Success:', response.data);
        setResponseData(response.data);
        setError(null);
      })
      .catch((error) => {
        console.error('Error:', error);
        setError(error.message);
        setResponseData(null);
      });
  };
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          User ID:
          <input
            type="text"
            value={userId}
            onChange={(event) => setUserId(event.target.value)}
          />
        </label>
        <button type="submit">Submit</button>
      </form>
      {error && <div>Error: {error}</div>}
      {responseData && (
        <div>
         You added a new user with the ID: {responseData.id}
        </div>
      )}
      <hr />
      <UserGames />
    </div>
  );
}

export default App;
