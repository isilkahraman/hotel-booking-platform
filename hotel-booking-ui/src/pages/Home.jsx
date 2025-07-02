import { useState } from 'react';
import SearchForm from '../components/SearchForm';
import HotelList from '../components/HotelList';
import API from '../api/api';

export default function Home() {
  const [hotels, setHotels] = useState([]);

  const handleSearch = async ({ location, people }) => {
    const res = await API.post('/search', {
      location,
      startDate: '2025-07-15',
      endDate: '2025-07-18',
      people,
      isClient: true
    });
    setHotels(res.data);
  };

  return (
    <div>
      <h1>Hotel Booking</h1>
      <SearchForm onSearch={handleSearch} />
      <HotelList hotels={hotels} />
    </div>
  );
}
