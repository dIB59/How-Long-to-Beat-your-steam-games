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
    
  return (
    <main className='userGamesArticle'>
      {loading ? (
        <p>Loading games...</p>
      ) : userGamesData && userGamesData.length > 0 ? (
        <table className='table'>
            <thead>
                <tr>
                <th><h2>ID</h2></th>
                <th>
                  <h2>Number of Games
                  <button onClick={handleSort}>
                  {sortOrder === 'asc' ? '▲' : '▼'}
                  </button></h2>
                </th>
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
