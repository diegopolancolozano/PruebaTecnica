import React, { useState } from 'react';
import axios from 'axios';

const ReservationForm = () => {
    const [clientName, setClientName] = useState('');
    const [showId, setShowId] = useState('');
    const [chairIds, setChairIds] = useState([]);
    const [error, setError] = useState(null);

    const handleReservation = async () => {
        try {
            await axios.post('/api/reservations', { clientName, showId, chairIds });
            alert('Reservation created!');
        } catch (e) {
            setError('Failed to create reservation');
        }
    };

    const handleCancellation = async (id) => {
        try {
            await axios.delete(`/api/reservations/${id}`);
            alert('Reservation cancelled!');
        } catch (e) {
            setError('Failed to cancel reservation');
        }
    };

    return (
        <div>
            <h1>Reservation</h1>
            <input
                type="text"
                placeholder="Client Name"
                value={clientName}
                onChange={(e) => setClientName(e.target.value)}
            />
            <input
                type="number"
                placeholder="Show ID"
                value={showId}
                onChange={(e) => setShowId(e.target.value)}
            />
            <input
                type="text"
                placeholder="Chair IDs (comma-separated)"
                value={chairIds}
                onChange={(e) => setChairIds(e.target.value.split(','))}
            />
            <button onClick={handleReservation}>Reserve</button>
            {/* Add logic to list reservations and allow cancellation */}
            {error && <p>{error}</p>}
        </div>
    );
}

export default ReservationForm;