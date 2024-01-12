package com.example.tunehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entites.PlayList;
import com.example.tunehub.repository.PlayListRepository;
@Service
public class PlayListServiceImpl implements PlayListService {
	@Autowired
PlayListRepository repo;
	@Override
	public void addPlaylist(PlayList playlist) {
		repo.save(playlist);
		
	}
	@Override
	public List<PlayList> fetchAllPlaylists() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
