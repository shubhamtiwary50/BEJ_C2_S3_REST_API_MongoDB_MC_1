package com.niit.controller;

import com.niit.domain.Track;
import com.niit.exception.TrackNotFoundException;
import com.niit.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trackdata/v1")
public class TrackController {


    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    @PostMapping("/saveTrack")
    public ResponseEntity<?> saveTrackData(@RequestBody Track track) {
        return new ResponseEntity<>(trackService.saveTrack(track), HttpStatus.CREATED);

    }

    @GetMapping("/getTracks")
    public ResponseEntity<?> fetchAllTracks() throws Exception {
        return new ResponseEntity<>(trackService.getAllTrackData(), HttpStatus.FOUND);
    }


    @DeleteMapping("/deleteTrack/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId) throws TrackNotFoundException, Exception {
        return new ResponseEntity<>(trackService.deleteTrack(trackId), HttpStatus.OK);
    }


    @GetMapping("/getTrackByRating/{trackRating}")
    public ResponseEntity<?> getAllTracksByTrackRating(@PathVariable int trackRating) throws TrackNotFoundException,Exception{
        return new ResponseEntity<>(trackService.getAllTrackByTrackRating(String.valueOf(trackRating)),HttpStatus.FOUND);
    }
    @GetMapping("/getTrackByArtist/{artistName}")
    public ResponseEntity<?> getAllTracksByTrackRating(@PathVariable String  artistName) throws TrackNotFoundException,Exception{
        return new ResponseEntity<>(trackService.getAllTrackByArtistName(artistName),HttpStatus.FOUND);
    }
}
