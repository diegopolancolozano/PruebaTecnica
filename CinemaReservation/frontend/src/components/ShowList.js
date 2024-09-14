// src/components/ShowList.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ShowList = () => {
    const [shows, setShows] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchShows = async () => {
            try {
                const response = await axios.get('/api/shows'); // Asegúrate de que este endpoint es correcto
                setShows(response.data);
            } catch {
                setError('Failed to fetch shows');
            }
        };

        fetchShows();
    }, []);

    return (
        <div>
            <h1>Shows</h1>
            {error && <p>{error}</p>}
            <ul>
                {shows.map(show => (
                    <li key={show.id}>{show.movie.title} at {show.showTime}</li>
                ))}
            </ul>
        </div>
    );
};

export default ShowList;
