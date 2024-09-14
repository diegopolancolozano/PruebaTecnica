import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Movies = () => {
    const [movies, setMovies] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        axios.get('/movies')
            .then(response => {
                setMovies(response.data);
                setError('');
            })
            .catch(error => {
                setError('Failed to fetch movies');
            });
    }, []);

    return (
        <div>
            <h1>Movies</h1>
            {error ? <p>{error}</p> : (
                <ul>
                    {movies.map(movie => (
                        <li key={movie.id}>{movie.title}</li>
                    ))}
                </ul>
            )}
        </div>
    );
};

export default Movies;
