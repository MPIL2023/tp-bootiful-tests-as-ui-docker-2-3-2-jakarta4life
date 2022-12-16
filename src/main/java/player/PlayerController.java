package player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private IPlayerDAO dao;

    @ResponseBody
    @GetMapping(value="/players",produces = "application/json")
    public List<Player> getAllPlayers(
            @RequestParam(value = "nom", required = false) String nom,
            @RequestParam(value = "prenom", required = false) String prenom,
            @RequestParam(value = "poste", required = false) String poste
    ){
        return dao.findBy(player -> {
            boolean keep = true;
            if (nom != null && !player.getNom().equals(nom)) keep = false;
            if (prenom != null && !player.getPrenom().equals(prenom)) keep = false;
            if (poste != null && !player.getPoste().equals(poste)) keep = false;
            return keep;
        });
    }

    @ResponseBody
    @GetMapping(value="/players/3pts",produces = "application/json")
    public Player getBest3pts(){
        return dao.findBest3pts();
    }

    @ResponseBody
    @GetMapping(value="/players/{id}",produces = "application/json")
    public Player getPlayersById(@PathVariable String id){
        return dao.findById(id);
    }

    @ResponseBody
    @PostMapping(value="/players", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addPlayer(@RequestBody Player player){
        if (player.getNom() != null && player.getPrenom() != null && player.getPoste() != null ) {
            dao.addPlayer(player);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @DeleteMapping(value="/players/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> deletePlayer(@PathVariable String id){
        if (dao.deletePlayerByID(id))  return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @PutMapping(value="/players/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePlayer(@PathVariable String id,@RequestBody Player player){
        if (player.getNom() != null && player.getPrenom() != null && player.getPoste() != null ) {
            if (dao.updatePlayerByID(id,player)) return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
