export default function HotelList({ hotels }) {
  if (!hotels.length) return <p>No results.</p>;

  return (
    <ul>
      {hotels.map((h, i) => (
        <li key={i}>
          <h3>{h.name} ({h.stars}★)</h3>
          <p>{h.rooms[0].price} $/night - Capacity: {h.rooms[0].capacity}</p>
        </li>
      ))}
    </ul>
  );
}
