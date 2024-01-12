package com.example.tunehub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entites.PlayList;
import com.example.tunehub.entites.Song;
import com.example.tunehub.service.PlayListService;
import com.example.tunehub.service.SongService;

@Controller
public class PlayListController {
	@Autowired
	SongService service;
	
	@Autowired
	PlayListService playlistService;
	@GetMapping("/createplaylist")
	public String createplaylist(Model model) {
		List<Song> songList=service.fetchAllSongs();
		model.addAttribute("songs",songList);
		return  "createplaylist";
	}
	
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute PlayList playlist) {
		//updating play list table
	playlistService.addPlaylist(playlist);
	//updating song table
	List<Song> songList=playlist.getSongs();
	for(Song s:songList) {
		s.getPlaylists().add(playlist);
		service.updateSong(s);
	}
	return "adminhome";
}
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<PlayList> allPlaylists=playlistService.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayPlaylists";
		
	}
}
