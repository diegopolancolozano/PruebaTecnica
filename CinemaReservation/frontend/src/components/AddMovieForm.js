// src/components/AddMovieForm.js

import React, { useState } from 'react';
import axios from 'axios';

const AddMovieForm = () => {
    const [title, setTitle] = useState('');
    const [genre, setGenre] = useState('');
    const [error, setError] = useState('');

    const handleAddMovie = async () => {
        try {
            await axios.post('/api/movies', { title, genre }); // Ajusta el endpoint según tu configuración
            alert('Movie added successfully!');
            setTitle('');
            setGenre('');
            setError('');
        } catch {
            setError('Failed to add movie');
        }
    };

    return (
        <div>
            <input
                type="text"
                placeholder="Title"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
            />
            <input
                type="text"
                placeholder="Genre"
                value={genre}
                onChange={(e) => setGenre(e.target.value)}
            />
            <button onClick={handleAddMovie}>Add Movie</button>
        </div>
    );
};

export default AddMovieForm;
