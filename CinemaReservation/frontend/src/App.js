// src/App.js

import React from 'react';
import './App.css';
import ReservationForm from './components/ReservationForm';
import ShowList from './components/ShowList';
import MovieList from './components/MovieList';
import GenreForm from './components/GenreForm';
import AddMovieForm from './components/AddMovieForm';
import AddShowForm from './components/AddShowForm';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <h1>Cinema Reservation System</h1>
                <MovieList />
                <AddMovieForm />
                <GenreForm />
                <ShowList />
                <AddShowForm />
                <ReservationForm />
            </header>
        </div>
    );
}

export default App;
