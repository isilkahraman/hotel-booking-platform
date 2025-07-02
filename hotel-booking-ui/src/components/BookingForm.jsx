import { useState } from 'react';
import API from '../api/api';

export default function BookingForm({ roomId }) {
  const [customerName, setCustomerName] = useState('');
  const [email, setEmail] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [people, setPeople] = useState(2);
  const [message, setMessage] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await API.post('/book', {
        customerName,
        email,
        roomId,
        startDate,
        endDate,
        people
      });
      setMessage('✅ Booking successful!');
    } catch (err) {
      console.error(err);
      setMessage('❌ Booking failed. Please try again.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Book This Room</h3>
      {message && <p>{message}</p>}
      <input
        placeholder="Your Name"
        value={customerName}
        onChange={e => setCustomerName(e.target.value)}
        required
      /><br />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={e => setEmail(e.target.value)}
        required
      /><br />
      <label>Start Date: </label>
      <input
        type="date"
        value={startDate}
        onChange={e => setStartDate(e.target.value)}
        required
      /><br />
      <label>End Date: </label>
      <input
        type="date"
        value={endDate}
        onChange={e => setEndDate(e.target.value)}
        required
      /><br />
      <input
        type="number"
        placeholder="Number of People"
        value={people}
        min={1}
        onChange={e => setPeople(+e.target.value)}
        required
      /><br />
      <button type="submit">Book Now</button>
    </form>
  );
}
