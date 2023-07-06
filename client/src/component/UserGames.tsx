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
    axios
      .get('http://localhost:8080/api/users')
      .then(response => {
        setUserGamesData(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error(error);
        setLoading(false);
      });
  }, [userGamesData]);

  useEffect(() => {
    if (userGamesData) {
      setLoading(false);
    }
  }, [userGamesData]);

  return (
    <article className='userGamesArticle'>
      {loading ? (
        <p>Loading user games...</p>
      ) : userGamesData && userGamesData.length > 0 ? (
        <table>
            <thead>
                <tr>
                <th>ID</th>
                <th>Number of Games</th>
                <th>Steam ID</th>
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
    </article>
  );
};
