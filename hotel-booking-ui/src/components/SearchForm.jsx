import { useState } from 'react';

export default function SearchForm({ onSearch }) {
  const [location, setLocation] = useState('');
  const [people, setPeople] = useState(2);

  const handleSubmit = (e) => {
    e.preventDefault();
    onSearch({ location, people });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Location" value={location} onChange={e => setLocation(e.target.value)} />
      <input type="number" placeholder="People" value={people} onChange={e => setPeople(+e.target.value)} />
      <button type="submit">Search</button>
    </form>
  );
}
