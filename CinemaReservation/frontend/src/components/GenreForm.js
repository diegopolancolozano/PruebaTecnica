// src/components/GenreForm.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const GenreForm = () => {
    const [genres, setGenres] = useState([]);
    const [newGenre, setNewGenre] = useState('');
    const [error, setError] = useState('');

    useEffect(() => {
        fetchGenres();
    }, []);

    const fetchGenres = () => {
        axios.get('/api/genres') // Asegúrate de que este endpoint es correcto
            .then(response => setGenres(response.data))
            .catch(() => setError('Failed to fetch genres'));
    };

    const handleCreate = () => {
        if (newGenre.trim() === '') {
            setError('Genre name cannot be empty');
            return;
        }

        axios.post('/api/genres', { name: newGenre.trim() }) // Asegúrate de que este endpoint es correcto
            .then(() => {
                fetchGenres();
                setNewGenre('');
                setError('');
            })
            .catch(() => setError('Failed to create genre'));
    };

    return (
        <div>
            <h1>Genres</h1>
            {error && <p>{error}</p>}
            <input
                type="text"
                value={newGenre}
                onChange={e => setNewGenre(e.target.value)}
                placeholder="New Genre"
            />
            <button onClick={handleCreate}>Add Genre</button>
            <ul>
                {genres.map((genre, index) => (
                    <li key={index}>{genre.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default GenreForm;
