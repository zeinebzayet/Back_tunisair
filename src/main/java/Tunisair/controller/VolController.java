package Tunisair.controller;

import Tunisair.entity.*;
import Tunisair.exception.ResourceNotFoundException;
import Tunisair.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VolController {

    @Autowired
    private volRepository volRepository;

    @Autowired
    private avionRepository avionRepository;

    @Autowired
    private aeroportsRepository aeroportRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private staffRepository staffRepository;

    @GetMapping("/vol")
    public List<Vol> getAllVols(){
        return volRepository.findAll();
    }

    @GetMapping("/aeroport")
    public List<Aeroport> getAllAeroports(){
        return aeroportRepository.findAll();
    }

    @GetMapping("/avion")
    public List<Avion> getAllAvions(){
        return avionRepository.findAll();
    }
    @GetMapping("/entrepriseResto")
    public List<EntrepriseRestauration> getAllEntreprises(){
        return entrepriseRepository.findAll();
    }

    @GetMapping("/staff")
    public List<Staff> getAllStaffs(){
        return staffRepository.findAll();
    }

    @PostMapping("/avions/{avionId}/staffs/{StaffId}/entreprises/{EntrepriseId}/aeroportsdep/{AeroportdepId}/aeroportsarrv/{AeroportarrvId}/vol")
    public Vol addVol(@PathVariable Long avionId,@PathVariable Long StaffId,@PathVariable Long EntrepriseId,@PathVariable Long AeroportdepId,@PathVariable Long AeroportarrvId, @RequestBody Vol v) throws ResourceNotFoundException {

        Avion avion = avionRepository.findById(avionId).orElseThrow(() -> new ResourceNotFoundException("avion not found  "));

        Staff staff = staffRepository.findById(StaffId).orElseThrow(() -> new ResourceNotFoundException("staff not found  "));
        EntrepriseRestauration entreprise = entrepriseRepository.findById(EntrepriseId).orElseThrow(() -> new ResourceNotFoundException("entrepriseRestauration not found  "));

        Aeroport aeroportDep = aeroportRepository.findById(AeroportdepId).orElseThrow(() -> new ResourceNotFoundException("Aeroport depart not found  "));
        Aeroport aeroportArrv = aeroportRepository.findById(AeroportarrvId).orElseThrow(() -> new ResourceNotFoundException("Aeroport arrivé not found  "));

        if (avion != null && staff != null && entreprise != null && aeroportDep != null && aeroportArrv != null) {
            v.setAvion(avion);
            v.setStaff(staff);
            v.setEntrepriseRestauration(entreprise);
            v.setAeroportDepart(aeroportDep);
            v.setAeroportArrivee(aeroportArrv);

            volRepository.save(v);
            return v;
        }
        return null;
    }


    @DeleteMapping("/vol/{id}")
    public void deleteVol(@PathVariable(value = "id") Long volId)throws ResourceNotFoundException {
        volRepository.deleteById(volId);
    }

    @DeleteMapping("/vol")
    public void deleteVol()throws ResourceNotFoundException {
        volRepository.deleteAll();
    }


    @PutMapping("/vol/{id}")
    public ResponseEntity<Vol> updateVol(@PathVariable(value = "id") Long volId, @RequestBody Vol volDetails) throws ResourceNotFoundException {
        Vol v = volRepository.findById(volId).orElseThrow(() -> new ResourceNotFoundException("Vol not found for this id :: " + volId));

        Avion avion=avionRepository.findById(volDetails.getAvion().getId()).orElseThrow(() -> new ResourceNotFoundException("Avion not found "));
        avion=new Avion(volDetails.getAvion().getId(),avion.getType(),avion.getEtat());

        Staff staff=staffRepository.findById(volDetails.getStaff().getId()).orElseThrow(() -> new ResourceNotFoundException("Staff not found "));
        staff=new Staff(volDetails.getStaff().getId(),staff.getNbEmployés());

        EntrepriseRestauration ese=entrepriseRepository.findById(volDetails.getEntrepriseRestauration().getId()).orElseThrow(() -> new ResourceNotFoundException("Entreprise not found "));
        ese=new EntrepriseRestauration(volDetails.getEntrepriseRestauration().getId(),ese.getNom(),ese.getAdresse(),ese.getTel());

        Aeroport aeroportDep=aeroportRepository.findById(volDetails.getAeroportDepart().getId()).orElseThrow(() -> new ResourceNotFoundException("Aeroport depart not found "));
        aeroportDep=new Aeroport(volDetails.getAeroportDepart().getId(),aeroportDep.getNom());

        Aeroport aeroportArriv=aeroportRepository.findById(volDetails.getAeroportArrivee().getId()).orElseThrow(() -> new ResourceNotFoundException("Aeroport arrivee not found "));
        aeroportArriv=new Aeroport(volDetails.getAeroportArrivee().getId(),aeroportArriv.getNom());

        v.setReference(volDetails.getReference());
        v.setDateDepart(volDetails.getDateDepart());
        v.setDateArrivee(volDetails.getDateArrivee());
        v.setEtat(volDetails.getEtat());
        v.setType(volDetails.getType());
        v.setPrix(volDetails.getPrix());
        v.setAvion(avion);
        v.setStaff(staff);
        v.setEntrepriseRestauration(ese);
        v.setAeroportDepart(aeroportDep);
        v.setAeroportArrivee(aeroportArriv);

        final Vol updatedVol = volRepository.save(v);

        return ResponseEntity.ok(updatedVol);
    }



}
