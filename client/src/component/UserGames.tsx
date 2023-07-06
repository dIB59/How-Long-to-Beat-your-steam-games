import axios from 'axios'
import { useEffect, useState } from 'react'

type UserGame = {
    id: number;
    numberOfGames: number;
};

export const UserGames = () => {
    const [userGamesData, setUserGamesData] = useState<UserGame[] | null>(null);
    const [loading, setLoading] = useState<boolean>(true);

    useEffect(() => {
        axios.get('http://localhost:8080/api/users')
            .then(response => {
                setUserGamesData(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error(error);
                setLoading(false);
            });
    }, []);

    return (
        <article className='userGamesArticle'>
            {loading ? (
                <p>Loading user games...</p>
            ) : userGamesData && userGamesData.length > 0 ? (
                <div>
                    {userGamesData.map(data => (
                        <div key={data.id}>
                            <p>{data.id}</p>
                            <p>{data.numberOfGames}</p>
                        </div>
                    ))}
                </div>
            ) : (
                <p>No user games found.</p>
            )}
        </article>
    );
}
