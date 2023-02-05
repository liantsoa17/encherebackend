package com.example.vehicule1.service;

import com.example.vehicule1.model.Enchere;
import com.example.vehicule1.model.EnchereFait;
import com.example.vehicule1.model.Encherir;
import com.example.vehicule1.repository.EnchereRepo;
import com.example.vehicule1.repository.EncherirRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnchereFaitService {
    private final EncherirRepo encherirRepo;
    private final EnchereRepo enchereRepo;

    public EnchereFaitService(EncherirRepo encherirRepo, EnchereRepo enchereRepo) {
        this.encherirRepo = encherirRepo;
        this.enchereRepo = enchereRepo;
    }

    public List<EnchereFait> getEnchereFait(Integer idUser){
        List<EnchereFait> enchereFaits=new ArrayList<>();
        List<Encherir> encherirs=encherirRepo.findByIdutilisateur(idUser);
        for(int i=0;i<encherirs.size();i++){
            EnchereFait enchereFait=new EnchereFait();
            enchereFait.setEncherir(encherirs.get(i));
            enchereFait.setEnchere(enchereRepo.findById(encherirs.get(i).getIdEnchere()).get());
            if(enchereFait.getEnchere().getIdStatus()==1/*date fin enchere is not over date now*/){
                enchereFait.setObtention("En cours");
            }
           /* else if(encherirs.get(i).getPrix_encherir()==getMax(enchereFait.getEnchere())){
                enchereFait.setObtention("Obtenue");
            }
            else{
                enchereFait.setObtention("Perdu");
            }*/
            enchereFaits.add(enchereFait);
        }
        return  enchereFaits;
    }
    public double getMax(Enchere enchere){
        List<Encherir> encherirs=encherirRepo.findByIdEnchere(enchere.getId());
        double max=encherirs.get(0).getPrix_encherir();
        for(int i=1;i<encherirs.size();i++){
            if(encherirs.get(i).getPrix_encherir()>max){
                max=encherirs.get(i).getPrix_encherir();
            }
        }
        return max;

    }
}
