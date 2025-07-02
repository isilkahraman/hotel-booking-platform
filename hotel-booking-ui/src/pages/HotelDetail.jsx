import { useState } from 'react';
import CommentsChart from '../components/CommentsChart';
import CommentForm from '../components/CommentForm';
import BookingForm from '../components/BookingForm';

export default function HotelDetail() {
  const hotelId = 1; // Replace with dynamic routing later
  const [reloadKey, setReloadKey] = useState(0); // force chart refresh
  const hotel = {
    id: 1,
    name: "Sample Hotel",
    rooms: [
      { id: 10, price: 200, capacity: 2 }
    ]
  };

  const handleCommentAdded = () => {
    setReloadKey(prev => prev + 1);
  };

  return (
    <div>
        <h2>Hotel Details</h2>
        <h2>{hotel.name}</h2>
        {hotel.rooms.map(room => (
            <div key={room.id}>
            <p>Room {room.id} – ${room.price}/night – Capacity: {room.capacity}</p>
            <BookingForm roomId={room.id} />
            </div>
        ))}
      <CommentsChart hotelId={hotelId} key={reloadKey} />
      <CommentForm hotelId={hotelId} onCommentAdded={handleCommentAdded} />
    </div>
  );
}
