CREATE SCHEMA IF NOT EXISTS bot;

CREATE TABLE IF NOT EXISTS bot.category (
    id SERIAL PRIMARY KEY,
    name TEXT,
    aliases TEXT
);

CREATE TABLE IF NOT EXISTS bot.expense (
    id SERIAL PRIMARY KEY,
    amount INTEGER,
    created DATE,
    category_id INTEGER REFERENCES botService.category(id)
);
