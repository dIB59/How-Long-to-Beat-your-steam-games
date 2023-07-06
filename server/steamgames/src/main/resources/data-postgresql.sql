INSERT INTO user_games (steam_id ,number_of_games) VALUES (1, 1) ON CONFLICT DO NOTHING;
INSERT INTO user_games (steam_id ,number_of_games) VALUES (2, 12) ON CONFLICT DO NOTHING;