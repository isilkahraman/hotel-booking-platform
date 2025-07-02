// ai-agent.js

const express = require('express');
const axios = require('axios');
const bodyParser = require('body-parser');
require('dotenv').config();

const app = express();
app.use(bodyParser.json());

// Sample prompt parsing and mock intent detection
function parseIntent(message) {
    const locationMatch = message.match(/in (\w+)/i);
    const dateMatch = message.match(/from (\w+ \d{1,2}) to (\w+ \d{1,2})/i);
    const peopleMatch = message.match(/for (\d+) adults?/i);

    return {
        location: locationMatch ? locationMatch[1] : 'Rome',
        startDate: '2025-07-15',
        endDate: '2025-07-18',
        people: peopleMatch ? parseInt(peopleMatch[1]) : 2
    };
}

app.post('/api/ai/chat', async (req, res) => {
    const userMessage = req.body.message;
    const parsed = parseIntent(userMessage);

    try {
        // Call search API via Gateway
        const response = await axios.post(`${process.env.GATEWAY_URL}/api/search`, {
            location: parsed.location,
            startDate: parsed.startDate,
            endDate: parsed.endDate,
            people: parsed.people,
            isClient: true
        });

        const options = response.data.map((hotel, i) =>
            `${i + 1}. ${hotel.name} - ${hotel.stars}★ - $${hotel.rooms[0].price}/night`
        ).join('\n');

        const reply = `Here are hotels in ${parsed.location} from ${parsed.startDate} to ${parsed.endDate} for ${parsed.people} adults:\n\n${options}`;
        res.json({ reply });

    } catch (err) {
        console.error(err);
        res.status(500).json({ reply: 'Sorry, something went wrong while searching.' });
    }
});

app.listen(5000, () => {
    console.log('AI Agent running on http://localhost:5000');
});
