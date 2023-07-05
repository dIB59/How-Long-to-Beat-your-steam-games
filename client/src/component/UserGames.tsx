import axios from 'axios'
import { useEffect, useState } from 'react'

type userGames = {
    id: number;
    numberOfGames: number;
};

export const UserGames = () => {
    const [userGamesData, setuserGamesData] = useState<userGames[] | null>(null);

    useEffect(() => {
        axios.get('http://localhost:8080/api/users')
            .then(response => {
                console.log(userGamesData);
                setuserGamesData(response.data);
            })
            .catch((exception) => console.log(exception))
    }, []);

    return (
        <>
            {userGamesData && (
                <article className='userGamesArticle'>
                    <div>{userGamesData.map((data) => (
                        <><p key={data.id}>{data.id}</p>
                        <p>{data.numberOfGames}</p></>
                    ))}</div>
                </article>
            )}
        </>
    )
}

