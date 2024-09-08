package com.music.track.controller;

import com.music.track.dto.TrackRequest;
import com.music.track.model.Track;
import com.music.track.service.TrackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("music/platform/v1/tracks")
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    /**
     * Create a track
     * @param trackRequest
     * @return
     */
    @PostMapping()
    public Track createTrack(@RequestBody TrackRequest trackRequest){
    	 return trackService.createTrack(trackRequest);

    }
    /**
     * Get all tracks
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<Track>> getAllTracks(){
    	 List<Track> tracks = trackService.getAllTracks();
         return ResponseEntity.ok(tracks);    }
    /**
     * Delete a track
     * @param trackId
     */
    @DeleteMapping("/{trackId}")
    
    public ResponseEntity<Void> deleteTrack(@PathVariable Long trackId) {
    	trackService.deleteTrack(trackId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get Track sorted
     * @return
     */
    @GetMapping("/sorted")
    public ResponseEntity<List<Track>> getTracksSorted() {
    	 List<Track> sortedTracks = trackService.sortedTracks();
         return ResponseEntity.ok(sortedTracks);
    }
}
