import axios from 'axios';
import { FC, useEffect, useState } from 'react';
import { UserGame } from '../types';

type UserGamesProps = {
  loading: boolean;
  userGamesData: UserGame[] | null;
  fetchData: () => Promise<void>;
  handleSort: () => void;
  sortOrder: 'asc' | 'desc';
}

export const UserGames: FC<UserGamesProps> = (props) => {
  const { userGamesData, loading, fetchData, handleSort, sortOrder } = props;

  useEffect(() => {
    fetchData();
  }, []);

  const [hoveredRow, setHoveredRow] = useState<number | null>(null);

  const handleRowHover = (index: number) => {
    setHoveredRow(index);
  };

  const handleDelete = (id: number) => {
    console.log('Delete:', id);
    axios.delete(`http://localhost:8080/api/users/${id}`)
      .then(() => {
        // Update the userGamesData state or trigger a refetch if necessary.
        fetchData();
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  return (
    <main className='userGamesArticle'>
      {loading ? (
        <p>Loading games...</p>
      ) : userGamesData && userGamesData.length > 0 ? (
        <table className='table'>
          <thead>
            <tr>
            <th>
                <h2>Persona</h2>
              </th>
              <th>
                <h2>
                  Number of Games
                  <button onClick={handleSort}>
                    {sortOrder === 'asc' ? '▲' : '▼'}
                  </button>
                </h2>
              </th>
              <th>
                <h2>Steam ID</h2>
              </th>
              <th>
              </th>
            </tr>
          </thead>
          <tbody>
            {userGamesData.map((data, index) => (
              <tr
                key={data.id}
                onMouseEnter={() => handleRowHover(index)}
                onMouseLeave={() => handleRowHover(0)}
              >
                <td>{data.personaName}</td>
                <td>{data.numberOfGames}</td>
                <td>{data.steamId}</td>
                <td>
                  {hoveredRow === index && (
                    <button onClick={() => handleDelete(data.id)}>Delete</button>
                  )}
                </td>
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
