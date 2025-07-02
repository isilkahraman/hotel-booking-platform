import { useState } from 'react';
import API from '../api/api';

export default function ChatBot() {
  const [msg, setMsg] = useState('');
  const [reply, setReply] = useState('');

  const handleChat = async () => {
    const res = await API.post('http://localhost:5000/api/ai/chat', { message: msg });
    setReply(res.data.reply);
  };

  return (
    <div>
      <textarea rows="2" value={msg} onChange={e => setMsg(e.target.value)} />
      <button onClick={handleChat}>Ask</button>
      <pre>{reply}</pre>
    </div>
  );
}
