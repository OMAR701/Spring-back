package com.example.springangularbackend.service.impl;


import com.example.springangularbackend.service.DirecteurService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DirecteurServiceImpl implements DirecteurService {

//
//    @Autowired
//    private DirecteurRepository directeurRepository;
//    @Autowired
//    private  DotationMemberRepository dotationMemberRepository;
//    @Autowired
//    private MemberPrejtRepository memberPrejtRepository;
//    @Autowired
//    private MembreRepository membreRepository;
//    @Autowired
//    private ExpressionDesBesoinsRepository expressionDesBesoinsRepository;
//    @Autowired
//    private DotationRepository dotationRepository;
//
//    @Autowired
//    ProjetRepository projetRepository;
//
//    public DirecteurServiceImpl(DirecteurRepository directeurRepository,MembreRepository membreRepository, ExpressionDesBesoinsRepository expressionDesBesoinsRepository){
//        this.directeurRepository = directeurRepository;
//        this.membreRepository = membreRepository;
//        this.expressionDesBesoinsRepository = expressionDesBesoinsRepository;
//    }
//
//
//
//
//    @Override
//    public Optional<Member> getByEmail(String email) {
//        return membreRepository.findByEmail(email);
//    }
//
//    @Override
//    public Optional<Membre> getMemberById(int id) {
//            return  membreRepository.findById(id);
//    }
//
//    @Override
//    public List<Membre> getAllMembers() {
//        return membreRepository.findAll();
//    }
//
////    @Override
////    public void addMember(Membre membre) {
////        membreRepository.save(membre);
////    }
////
////    @Override
////    public Membre updateMember(int id , MemberDTO memberDTO) {
////
////        Membre membre = membreRepository.findById(id)
////                .orElseThrow(() -> new PersonNotFoundException("Person not found"));
////
////        membre.setNom(memberDTO.getNom());
////        membre.setEmail(memberDTO.getEmail());
////        return membreRepository.save(membre);
////    }
//
//
//
//    @Override
//    public boolean validateExpression(ExpressionDesBesoinsDTO expressionDesBesoinsDTO) {
//
//        if (expressionDesBesoinsDTO.getDate_de_validation().getYear() == 2019) {
//            ExpressionDesBesoins expressionDesBesoins = new ExpressionDesBesoins();
//            expressionDesBesoins.setDate_de_Demande(expressionDesBesoinsDTO.getDate_de_validation());
//
//            expressionDesBesoinsRepository.save(expressionDesBesoins);
//            return true;
//        }
//        else
//            return false;
//    }
//
//
////    @Override
////    public Projet createProjet(ProjectDTO projectDTO) {
////        Projet projet = new Projet();
////        projet.setTitre(projectDTO.getTitle());
////        return  projetRepository.save(projet);
////    }
//
//    @Override
//    public void affecteResponsableToProject(int idProjet, int Idmembre) {
//        MembreProjet membreProjet = new MembreProjet();
//        membreProjet.setMembre(membreRepository.findById(Idmembre).get());
//        membreProjet.setProjet(projetRepository.findById(idProjet).get());
//        memberPrejtRepository.save(membreProjet);
//
//    }
//
//    @Override
//    public void giveDotationToMember(int Iddotation, int Idmembre) {
//
//        DotationMembre dotationMembre = new DotationMembre();
//        dotationMembre.setDotation(dotationRepository.findById(Iddotation).get());
//        dotationMembre.setMembre(membreRepository.findById(Idmembre).get());
//        dotationMembre.setMontant(dotationRepository.findById(Iddotation).get().getMontant_total()/3);
//        dotationMemberRepository.save(dotationMembre);
//    }


}
