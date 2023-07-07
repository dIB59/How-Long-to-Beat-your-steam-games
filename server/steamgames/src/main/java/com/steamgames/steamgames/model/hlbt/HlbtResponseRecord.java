package com.steamgames.steamgames.model.hlbt;

import com.steamgames.steamgames.model.hlbt.Data;

import java.util.List;

public record HlbtResponseRecord(String color, String title, String category, int count,
                                 int pageCurrent, int pageTotal, int pageSize, List<Data> data,
                                 List<Object> userData, Object displayModifier) {
}
