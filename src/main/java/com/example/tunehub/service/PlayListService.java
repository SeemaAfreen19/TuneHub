package com.example.tunehub.service;

import java.util.List;

import com.example.tunehub.entites.PlayList;

public interface PlayListService {

	public void addPlaylist(PlayList playlist);

	public List<PlayList> fetchAllPlaylists();

}
