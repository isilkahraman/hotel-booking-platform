import { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import API from '../api/api';
import {
  Chart as ChartJS,
  BarElement,
  CategoryScale,
  LinearScale,
  Legend,
  Tooltip
} from 'chart.js';

ChartJS.register(BarElement, CategoryScale, LinearScale, Legend, Tooltip);

export default function CommentsChart({ hotelId }) {
  const [chartData, setChartData] = useState(null);

  useEffect(() => {
    async function fetchData() {
      const res = await API.get(`/comments/${hotelId}/stats`);
      const data = res.data;

      const labels = ['1★', '2★', '3★', '4★', '5★'];
      const datasets = data.map(service => ({
        label: service.serviceType,
        data: service.distribution,
        backgroundColor: getRandomColor()
      }));

      setChartData({ labels, datasets });
    }

    fetchData();
  }, [hotelId]);

  function getRandomColor() {
    const colors = ['#36A2EB', '#FF6384', '#FFCE56', '#4BC0C0', '#9966FF'];
    return colors[Math.floor(Math.random() * colors.length)];
  }

  if (!chartData) return <p>Loading chart...</p>;

  return (
    <div>
      <h3>Rating Distribution</h3>
      <Bar data={chartData} />
    </div>
  );
}
