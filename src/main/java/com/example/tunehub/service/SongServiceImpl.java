package com.example.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entites.Song;
import com.example.tunehub.repository.SongRepository;



@Service
public class SongServiceImpl implements SongService{
	@Autowired
	SongRepository repo;
	@Override
	public String addSong(Song song) {
		repo.save(song);
		return null;
	}
	@Override
	public List<Song> fetchAllSongs() {
		return repo.findAll();
	}
	@Override
	public boolean songExists(String name) {
		Song song = repo.findByName(name);
		if(song==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	@Override
	public void updateSong(Song song) {
	repo.save(song);
	}

	
	
	}

