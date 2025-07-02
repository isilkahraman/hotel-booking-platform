import { useState } from 'react';
import API from '../api/api';

export default function CommentForm({ hotelId, onCommentAdded }) {
  const [serviceType, setServiceType] = useState('');
  const [rating, setRating] = useState(5);
  const [text, setText] = useState('');
  const [success, setSuccess] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await API.post('/comments', {
        hotelId,
        serviceType,
        rating,
        text
      });
      setSuccess(true);
      setServiceType('');
      setRating(5);
      setText('');
      if (onCommentAdded) onCommentAdded();
    } catch (err) {
      alert('Failed to submit comment');
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ marginTop: '1rem' }}>
      <h3>Leave a Review</h3>
      {success && <p style={{ color: 'green' }}>✅ Comment submitted!</p>}
      <div>
        <label>Service Type: </label>
        <input
          type="text"
          value={serviceType}
          onChange={e => setServiceType(e.target.value)}
          required
          placeholder="e.g., room, staff"
        />
      </div>
      <div>
        <label>Rating (1–5): </label>
        <input
          type="number"
          value={rating}
          min={1}
          max={5}
          onChange={e => setRating(+e.target.value)}
          required
        />
      </div>
      <div>
        <label>Comment: </label><br />
        <textarea
          value={text}
          onChange={e => setText(e.target.value)}
          required
          rows="3"
        />
      </div>
      <button type="submit">Submit</button>
    </form>
  );
}
