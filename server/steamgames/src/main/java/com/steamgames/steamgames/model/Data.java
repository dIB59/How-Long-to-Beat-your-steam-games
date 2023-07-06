package com.steamgames.steamgames.model;

public record Data(int count, int game_id, String game_name, int game_name_date, String game_alias,
                   String game_type, String game_image, int comp_lvl_combine, int comp_lvl_sp,
                   int comp_lvl_co, int comp_lvl_mp, int comp_lvl_spd, int comp_main, int comp_plus,
                   int comp_100, int comp_all, int comp_main_count, int comp_plus_count,
                   int comp_100_count, int comp_all_count, int invested_co, int invested_mp,
                   int invested_co_count, int invested_mp_count, int count_comp, int count_speedrun,
                   int count_backlog, int count_review, int review_score, int count_playing,
                   int count_retired, String profile_dev, int profile_popular, int profile_steam,
                   String profile_platform, int release_world) {
}

