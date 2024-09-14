// src/components/AddShowForm.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AddShowForm = () => {
    const [movies, setMovies] = useState([]);
    const [movieId, setMovieId] = useState('');
    const [showTime, setShowTime] = useState('');
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchMovies = async () => {
            try {
                const response = await axios.get('/api/movies'); // Ajusta el endpoint según tu configuración
                setMovies(response.data);
            } catch {
                setError('Failed to fetch movies');
            }
        };

        fetchMovies();
    }, []);

    const handleAddShow = async () => {
        try {
            await axios.post('/api/shows', { movieId, showTime }); // Ajusta el endpoint según tu configuración
            alert('Show added successfully!');
            setMovieId('');
            setShowTime('');
            setError('');
        } catch {
            setError('Failed to add show');
        }
    };

    return (
        <div>
            <select
                value={movieId}
                onChange={(e) => setMovieId(e.target.value)}
            >
                <option value="">Select Movie</option>
                {movies.map(movie => (
                    <option key={movie.id} value={movie.id}>
                        {movie.title}
                    </option>
                ))}
            </select>
            <input
                type="datetime-local"
                value={showTime}
                onChange={(e) => setShowTime(e.target.value)}
            />
            <button onClick={handleAddShow}>Add Show</button>
        </div>
    );
};

export default AddShowForm;
