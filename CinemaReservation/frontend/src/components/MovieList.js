// src/components/MovieList.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MovieList = () => {
    const [movies, setMovies] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        axios.get('/api/movies') // Asegúrate de que este endpoint es correcto
            .then(response => {
                setMovies(response.data);
                setError('');
            })
            .catch(() => setError('Failed to fetch movies'));
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

export default MovieList;
