package com.example.tunehub.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tunehub.entites.Song;
import com.example.tunehub.service.SongService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean songStatus = service.songExists(song.getName());
		if(songStatus==false) {
			service.addSong(song);
			System.out.println("song added successfully");
		}
		else {
			System.out.println("song already exists");
		}
		return "adminhome";
		
	}
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		List<Song> songsList=service.fetchAllSongs();
		System.out.println(songsList);
		model.addAttribute("songs", songsList);
		return  "displaySongs";
	}
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		boolean premiumUser=false;
		if(premiumUser == true) {
		List<Song> songsList=service.fetchAllSongs();
		System.out.println(songsList);
		model.addAttribute("songs", songsList);
		return  "displaySongs";
	}
		else {
			return "makePayment";
		}
	
	
	

	}
}
