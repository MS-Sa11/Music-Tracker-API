package com.music.track.repository;

import com.music.track.dto.TrackRequest;
import com.music.track.model.Track;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    public void delete(Optional<Track> track);

    public TrackRequest save(TrackRequest track);
}
