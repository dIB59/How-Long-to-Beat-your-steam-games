import React, { useState } from 'react';
import axios from 'axios';
import './App.css';
import { UserGames } from './component/UserGames';
import Form from './component/Form';

type ResponseData = {
  id: number;
  steamId: string;
  numberOfGames: number;
};

function App() {
  const [responseData, setResponseData] = useState<ResponseData | null>(null);
  const [error, setError] = useState<string | null>(null);

  const handleSubmit = (userId: string) => {
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
      <Form onSubmit={handleSubmit} error={error} />
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
