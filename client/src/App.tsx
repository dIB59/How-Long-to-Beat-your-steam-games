import React, { useState } from 'react';
import axios from 'axios';
import './App.css';
import { UserGames } from './component/UserGames';
import Form from './component/Form';
import { UserGame } from './types';

type ResponseData = {
  id: number;
  steamId: string;
  numberOfGames: number;
};

function App() {
  const [userGamesData, setUserGamesData] = useState<UserGame[] | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [sortOrder, setSortOrder] = useState<'asc' | 'desc'>('asc');
  const [responseData, setResponseData] = useState<ResponseData | null>(null);
  const [error, setError] = useState<string | null>(null);

  const fetchData = async () => {
    setLoading(true);
  
    try {
      const response = await axios.get<UserGame[]>('http://localhost:8080/api/users');
      setUserGamesData(response.data);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  const handleSort = () => {
    const sortedData = [...userGamesData!].sort((a, b) => {
      if (sortOrder === 'asc') {
        return a.numberOfGames - b.numberOfGames;
      } 
      return b.numberOfGames - a.numberOfGames;
    });

    setUserGamesData(sortedData);
    setSortOrder(sortOrder === 'asc' ? 'desc' : 'asc');
  };

  const handleSubmit = (userId: string) => {
    axios
      .post('http://localhost:8080/api/users', { userId: userId })
      .then((response) => {
        console.log('Success:', response.data);
        setResponseData(response.data);
        fetchData();
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
        <p>
          You added a new user with the ID: {responseData.id}
        </p>
      )}
      <hr />
      <UserGames loading={loading} userGamesData={userGamesData} fetchData={fetchData} handleSort={handleSort} sortOrder={sortOrder} />
    </div>
  );
}


export default App;
