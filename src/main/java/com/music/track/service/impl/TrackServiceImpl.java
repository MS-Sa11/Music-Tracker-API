package com.music.track.service.impl;

import com.music.track.dto.TrackRequest;
import com.music.track.model.Track;
import com.music.track.repository.TrackRepository;
import com.music.track.service.TrackService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    public  TrackRepository trackRepo;

    @Override
    public Track createTrack(TrackRequest trackRequest) {
    	Track track = new Track();
    	 track.setTitle(trackRequest.title());
         track.setAlbumName(trackRequest.albumName());
         track.setReleaseDate(trackRequest.releaseDate());
         track.setPlayCount(trackRequest.playCount());
         return trackRepo.save(track);
    }
    
    @Override
    public List<Track> getAllTracks() {
        return trackRepo.findAll();
    }

    @Override
    public void deleteTrack(Long trackId) {
    	trackRepo.deleteById(trackId);

    }

    @Override
    public List<Track> sortedTracks() {
    	 return trackRepo.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }
}
