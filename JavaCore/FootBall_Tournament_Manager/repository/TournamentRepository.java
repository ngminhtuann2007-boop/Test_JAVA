package repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.Tournament;

public interface TournamentRepository { 
    Tournament save(Tournament tournament);
    Optional<Tournament> findById(UUID id);
    List<Tournament> findAll();
    boolean deleteById(UUID id);
    boolean existsById(UUID id);
} 
  
