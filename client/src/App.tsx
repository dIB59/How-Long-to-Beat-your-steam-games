import React, { useState } from 'react';
import axios from 'axios';
import './App.css';
import { UserGames } from './component/UserGames';

function App() {
  const [username, setUsername] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    // Make the POST request using Axios
    axios
      .post('http://localhost:8080/api/users', { userId: username })
      .then((response) => {
        console.log('Success:', response.data);
        // Handle success response here
      })
      .catch((error) => {
        console.error('Error:', error);
        // Handle error here
      });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Username:
          <input
            type="text"
            value={username}
            onChange={(event) => setUsername(event.target.value)}
          />
        </label>
        <button type="submit">Submit</button>
      </form>
      <UserGames />
    </div>
  );
}

export default App;
