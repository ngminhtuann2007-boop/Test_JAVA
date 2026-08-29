package repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.Tournament;

public class JdbcTournamentRepository implements TournamentRepository {
    
    @Override
    public Tournament save(Tournament tournament) {
        // TODO Auto-generated method stub
        return null;
    }
    

    @Override
    public List<Tournament> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Tournament> findById(UUID id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public boolean deleteById(UUID id) {
        // TODO Auto-generated method stub
        return false;
    }

    
}
