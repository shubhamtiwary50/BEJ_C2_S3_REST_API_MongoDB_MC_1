package com.niit.service;

import com.niit.domain.Track;
import com.niit.exception.ArtistNotFoundException;
import com.niit.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track);
    List<Track> getAllTrackData() throws TrackNotFoundException;
    public boolean deleteTrack(int trackId) throws TrackNotFoundException;
    List<Track> getAllTrackByTrackRating(String trackRating) throws TrackNotFoundException;
    List<Track> getAllTrackByArtistName(String artistName) throws ArtistNotFoundException;

}
