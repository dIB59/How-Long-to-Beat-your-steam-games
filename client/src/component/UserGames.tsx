import axios from 'axios';
import { useEffect, useState } from 'react';

type UserGame = {
  id: number;
  numberOfGames: number;
  steamId: string;
};

export const UserGames = () => {
  const [userGamesData, setUserGamesData] = useState<UserGame[] | null>(null);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchData = async () => {
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

    fetchData();
  }, []);
    
  return (
    <main className='userGamesArticle'>
      {loading ? (
        <p>Loading user games...</p>
      ) : userGamesData && userGamesData.length > 0 ? (
        <table>
            <thead>
                <tr>
                <th><h2>ID</h2></th>
                <th><h2>Number of Games</h2></th>
                <th><h2>Steam ID</h2></th>
                </tr>
            </thead>
            <tbody>
                {userGamesData.map(data => (
                <tr key={data.id}>
                    <td>{data.id}</td>
                    <td>{data.numberOfGames}</td>
                    <td>{data.steamId}</td>
                </tr>
                ))}
            </tbody>
        </table>
      ) : (
        <p>No user games found.</p>
      )}
    </main>
  );
};
